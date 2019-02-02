package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.drivetrain.Drive;
import frc.util.DriveHelper;
import frc.util.EncoderHelper;

public final class Drivetrain extends Subsystem implements Constants{

	// the following comments are the mechanical markers
	private final int LEFT_DRIVE_MASTER = 2, // 6
		LEFT_DRIVE_SLAVE1 = 3, // 5
		LEFT_DRIVE_SLAVE2 = 4, // 4
		RIGHT_DRIVE_MASTER = 5, // 3
		RIGHT_DRIVE_SLAVE1 = 6, // 2
		RIGHT_DRIVE_SLAVE2 = 7; // 1
	
	private double throttleDeadband = 0.08;
	private double headingDeadband = 0.07;
	public double
		kPLeft = 5e-5, kILeft = 1e-6, kDLeft = 0,
		kPRight = 5e-5, kIRight = 1e-6, kDRight = 0,
		kMaxOutput = 1, kMinOutput = -1,
		maxRPM = 5700;
	
	private CANSparkMax
		leftDriveMaster = new CANSparkMax(LEFT_DRIVE_MASTER, CANSparkMaxLowLevel.MotorType.kBrushless),
		leftDriveSlave1 = new CANSparkMax(LEFT_DRIVE_SLAVE1, CANSparkMaxLowLevel.MotorType.kBrushless),
		leftDriveSlave2 = new CANSparkMax(LEFT_DRIVE_SLAVE2, CANSparkMaxLowLevel.MotorType.kBrushless),
		rightDriveMaster = new CANSparkMax(RIGHT_DRIVE_MASTER, CANSparkMaxLowLevel.MotorType.kBrushless),
		rightDriveSlave1 = new CANSparkMax(RIGHT_DRIVE_SLAVE1, CANSparkMaxLowLevel.MotorType.kBrushless),
		rightDriveSlave2 = new CANSparkMax(RIGHT_DRIVE_SLAVE2, CANSparkMaxLowLevel.MotorType.kBrushless);

	private DigitalInput testSwitch = new DigitalInput(0);
	private DigitalInput physicalSwitch = new DigitalInput(1); //TODO test this
	private AnalogInput lineSensor = new AnalogInput(0);
	private AnalogInput lineSensor2 = new AnalogInput(1);

	private CANEncoder 
		leftEncoder = leftDriveMaster.getEncoder(),
		rightEncoder = rightDriveMaster.getEncoder();

	private CANPIDController 
		leftPIDController = leftDriveMaster.getPIDController(),
		rightPIDController = rightDriveMaster.getPIDController();

	private DriveHelper driveHelper = new DriveHelper(7.5, throttleDeadband, headingDeadband);
		
	public Drivetrain() {
		setSlaves();
		setInverts();
		pushToShuffleboard();
		setPIDDefaults();
	}

	/*****************
	 * DRIVE METHODS *
	 *****************/
	public void driveVelocityPID(double throttle, double heading) {
		double velo = throttle * maxRPM;
		double turn = heading * maxRPM;

		if (Math.abs(throttle) < throttleDeadband)
			velo = 0;
		if(Math.abs(heading) < headingDeadband)
			turn = 0;

		leftPIDController.setReference(velo - turn, ControlType.kVelocity);
		rightPIDController.setReference(velo + turn, ControlType.kVelocity);
		
		double[] leftData = {velo-turn, leftEncoder.getVelocity()};
		double[] rightData = {velo+turn, rightEncoder.getVelocity()};
		SmartDashboard.putNumberArray("Left Velo Control", leftData);
		SmartDashboard.putNumberArray("Right Velo Control", rightData);
	}

	// drive for teleop
	public void drive(double throttle, double heading) {
		arcadeDrive(driveHelper.calculateThrottle(throttle),
				driveHelper.handleOverPower(driveHelper.handleDeadband(heading, headingDeadband)));
	}

	public void arcadeDrive(double throttle, double heading) {
		leftDriveMaster.set(throttle - heading);
		rightDriveMaster.set(throttle + heading);
	}

	/******************
	 * CONFIG METHODS *
	 ******************/
	public void setSlaves() {
		leftDriveSlave1.follow(leftDriveMaster);
		leftDriveSlave2.follow(leftDriveMaster, true);
		rightDriveSlave1.follow(rightDriveMaster);
		rightDriveSlave2.follow(rightDriveMaster, true);
	}

	private void setInverts() {
		leftDriveMaster.setInverted(true);
		leftDriveSlave1.setInverted(true);
	}

	private void setPIDDefaults() {
		leftPIDController.setP(kPLeft);
		leftPIDController.setI(kILeft);
		leftPIDController.setD(kDLeft);
		rightPIDController.setP(kPRight);
		rightPIDController.setI(kIRight);
		rightPIDController.setD(kDRight);

		leftPIDController.setOutputRange(kMinOutput, kMaxOutput);
		rightPIDController.setOutputRange(kMinOutput, kMaxOutput);
	}

	/****************
	 * SHUFFLEBOARD *
	 ***************/
	public void pushToShuffleboard() {
		SmartDashboard.putNumber("Throttle deadband", throttleDeadband);
		SmartDashboard.putNumber("Heading deadband", headingDeadband);
		SmartDashboard.putNumber("Left DT kP", kPLeft);
		SmartDashboard.putNumber("Left DT kI", kILeft);
		SmartDashboard.putNumber("Left DT kD", kDLeft);
		SmartDashboard.putNumber("Right DT kP", kPRight);
		SmartDashboard.putNumber("Right DT kI", kIRight);
		SmartDashboard.putNumber("Right DT kD", kDRight);
	}

	public void updateShuffleboard() {
		throttleDeadband = SmartDashboard.getNumber("Throttle deadband", throttleDeadband);
		headingDeadband = SmartDashboard.getNumber("Heading deadband", headingDeadband);

		double kPL = SmartDashboard.getNumber("Left DT kP", kPLeft);
		double kIL = SmartDashboard.getNumber("Left DT kI", kILeft);
		double kDL = SmartDashboard.getNumber("Left DT kD", kDLeft);
		double kPR = SmartDashboard.getNumber("Right DT kP", kPRight);
		double kIR = SmartDashboard.getNumber("Right DT kI", kIRight);
		double kDR = SmartDashboard.getNumber("Right DT kD", kDRight);
		if(kPL != kPLeft ||kIL != kILeft || kDL != kDLeft || kPR != kPRight || kIR != kIRight || kDR != kDRight) {
			kPLeft = kPL;
			kILeft = kIL;
			kDLeft = kDL;
			kPRight = kPR;
			kIRight = kIR;
			kDRight = kDR;
			setPIDDefaults();
		}

		SmartDashboard.putBoolean("Switch", getSwitchValue());
		SmartDashboard.putNumber("Line sensor", lineSensor.getValue());
		SmartDashboard.putNumber("Line sensor 2", lineSensor2.getValue());
		SmartDashboard.putBoolean("Physical switch", getPhysicalSwitchValue());
	}

	/***************
	 * GET METHODS *
	 ***************/
	public double getLeftInches() {
		return EncoderHelper.revsToInches(leftEncoder.getPosition(), WHEEL_CIRCUM_IN) / LOW_GEAR_RATIO;
	}

	public double getRightInches() {
		return EncoderHelper.revsToInches(rightEncoder.getPosition(), WHEEL_CIRCUM_IN) / LOW_GEAR_RATIO;
	}

	public double getThrottleDeadband() {
		return throttleDeadband;
	}

	public double getHeadingDeadband() {
		return headingDeadband;
	}

	public boolean getPhysicalSwitchValue() {
		return !physicalSwitch.get();
	}

	public boolean getSwitchValue() {
		return !testSwitch.get();
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}
}
