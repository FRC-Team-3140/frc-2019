package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.drivetrain.Drive;
import frc.util.DriveHelper;
import frc.util.EncoderHelper;

public final class Drivetrain extends Subsystem implements Constants {
	
	private double throttleDeadband = 0.08;
	private double headingDeadband = 0.07;
	public double
		kPLeft = 5e-5, kILeft = 1e-6, kDLeft = 0,
		kPRight = 5e-5, kIRight = 1e-6, kDRight = 0,
		kMaxOutput = 1, kMinOutput = -1,
		maxRPM = 5700, rampRate = 1.5; // ramp rate is the min # of secs the robot can go from 0 to full throttle

	public int lineTarget1 = 3500; // right
	public int lineTarget2 = 3050; // left
	public int lineTolerance = 20;
	public double leftLineFactor = 0.1/500, rightLineFactor = 0.1/100;
	
	private CANSparkMax
		leftDriveMaster = new CANSparkMax(LEFT_DRIVE_MASTER, CANSparkMaxLowLevel.MotorType.kBrushless),
		leftDriveSlave1 = new CANSparkMax(LEFT_DRIVE_SLAVE1, CANSparkMaxLowLevel.MotorType.kBrushless),
		leftDriveSlave2 = new CANSparkMax(LEFT_DRIVE_SLAVE2, CANSparkMaxLowLevel.MotorType.kBrushless),
		rightDriveMaster = new CANSparkMax(RIGHT_DRIVE_MASTER, CANSparkMaxLowLevel.MotorType.kBrushless),
		rightDriveSlave1 = new CANSparkMax(RIGHT_DRIVE_SLAVE1, CANSparkMaxLowLevel.MotorType.kBrushless),
		rightDriveSlave2 = new CANSparkMax(RIGHT_DRIVE_SLAVE2, CANSparkMaxLowLevel.MotorType.kBrushless);

	// Temporarily disabled because unplugged :c
	//private DigitalInput testSwitch = new DigitalInput(0);
	//private DigitalInput physicalSwitch = new DigitalInput(1); //TODO test this
	
	private AnalogInput lineSensor = new AnalogInput(0); // right
	private AnalogInput lineSensor2 = new AnalogInput(1); // left
	private Encoder enc = new Encoder(3, 4); // 256 pulses per revolution
	private Ultrasonic sonar = new Ultrasonic(0, 1);
	// private DigitalInput encoderB = new DigitalInput(3);
	// private DigitalInput encoderA = new DigitalInput(4);

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
		setBreakMode();
	}

	/*****************
	 * DRIVE METHODS *
	 *****************/
	public void driveVelocityJoystick(double throttle, double heading) {
		if (Math.abs(throttle) < throttleDeadband)
			throttle = 0;
		if(Math.abs(heading) < headingDeadband)
			heading = 0;

		driveVelocityPID(throttle, heading);
	}

	public void driveVelocityPID(double throttle, double heading) {
		double velo = throttle * maxRPM;
		double turn = heading * maxRPM * .75;

		//System.out.println(velo);
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

	public void tankDrive(double right, double left) {
		leftDriveMaster.set(left);
		rightDriveMaster.set(right);
	}

	public void driveAlongLine() {
		// TODO figure out + and - headings here... 		
		double rightCorrection = rightLineFactor * (lineTarget1- lineSensor.getValue());
		double leftCorrection = leftLineFactor * (lineTarget2- lineSensor2.getValue());
		if(Math.abs(lineTarget1 - lineSensor.getValue()) < lineTolerance) rightCorrection = 0;
		if(Math.abs(lineTarget2 - lineSensor2.getValue()) < lineTolerance) leftCorrection = 0;

		double heading = leftCorrection - rightCorrection;
		if(heading > 0.2) heading = 0.2;
		else if(heading < -0.2) heading = -0.2;
		System.out.println(heading);

		double[] push = {leftCorrection, rightCorrection, heading};
		SmartDashboard.putNumberArray("Drive Along line: ", push);
		driveVelocityPID(0.15, heading);
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
		rightDriveMaster.setInverted(true);
		rightDriveSlave1.setInverted(true);
	}

	private void setBreakMode() {
		leftDriveMaster.setIdleMode(CANSparkMax.IdleMode.kBrake);
		leftDriveSlave1.setIdleMode(CANSparkMax.IdleMode.kBrake);
		leftDriveSlave2.setIdleMode(CANSparkMax.IdleMode.kBrake);
		rightDriveMaster.setIdleMode(CANSparkMax.IdleMode.kBrake);
		rightDriveSlave1.setIdleMode(CANSparkMax.IdleMode.kBrake);
		rightDriveSlave2.setIdleMode(CANSparkMax.IdleMode.kBrake);
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

		// leftDriveMaster.setRampRate(rampRate);
		// rightDriveMaster.setRampRate(rampRate);
	}

	/****************
	 * SHUFFLEBOARD *
	 ***************/
	public void pushToShuffleboard() {
		SmartDashboard.putNumber("DT Throttle deadband", throttleDeadband);
		SmartDashboard.putNumber("DT Heading deadband", headingDeadband);
		SmartDashboard.putNumber("Left DT kP", kPLeft);
		SmartDashboard.putNumber("Left DT kI", kILeft);
		SmartDashboard.putNumber("Left DT kD", kDLeft);
		SmartDashboard.putNumber("Right DT kP", kPRight);
		SmartDashboard.putNumber("Right DT kI", kIRight);
		SmartDashboard.putNumber("Right DT kD", kDRight);
		SmartDashboard.putNumber("DT Ramp Rate", rampRate);
	}

	public void updateShuffleboard() {
		throttleDeadband = SmartDashboard.getNumber("DT Throttle deadband", throttleDeadband);
		headingDeadband = SmartDashboard.getNumber("DT Heading deadband", headingDeadband);

		double kPL = SmartDashboard.getNumber("Left DT kP", kPLeft);
		double kIL = SmartDashboard.getNumber("Left DT kI", kILeft);
		double kDL = SmartDashboard.getNumber("Left DT kD", kDLeft);
		double kPR = SmartDashboard.getNumber("Right DT kP", kPRight);
		double kIR = SmartDashboard.getNumber("Right DT kI", kIRight);
		double kDR = SmartDashboard.getNumber("Right DT kD", kDRight);
		double ramp = SmartDashboard.getNumber("DT Ramp Rate", rampRate);
		if(kPL != kPLeft ||kIL != kILeft || kDL != kDLeft || kPR != kPRight || kIR != kIRight || kDR != kDRight || ramp != rampRate) {
			kPLeft = kPL;
			kILeft = kIL;
			kDLeft = kDL;
			kPRight = kPR;
			kIRight = kIR;
			kDRight = kDR;
			rampRate = ramp;
			setPIDDefaults();
		}

		SmartDashboard.putBoolean("Switch", getSwitchValue());
		SmartDashboard.putNumber("Line sensor", lineSensor.getValue());
		SmartDashboard.putNumber("Line sensor 2", lineSensor2.getValue());
		SmartDashboard.putBoolean("Physical switch", getPhysicalSwitchValue());
		SmartDashboard.putNumber("Quad. Encoder Distance", enc.getDistance());
		SmartDashboard.putNumber("Quad. Encoder Scaled", enc.get());
		SmartDashboard.putNumber("Ultrasonic", sonar.getRangeInches())
;
		// Encoder DIO Ports
		/*int a = 0, b = 0;
		if(encoderA.get()) a = 1;
		if(encoderB.get()) b = 1;
		double[] encoder = {a,b};
		SmartDashboard.putNumberArray("Encoder DIO Ports", encoder);*/

		double[] rightVolts = {rightDriveMaster.getAppliedOutput(), rightDriveSlave1.getAppliedOutput(), rightDriveSlave2.getAppliedOutput()};
		double[] leftVolts = {leftDriveMaster.getAppliedOutput(), leftDriveSlave1.getAppliedOutput(), leftDriveSlave2.getAppliedOutput()};

		SmartDashboard.putNumberArray("DT Right", rightVolts);
		SmartDashboard.putNumberArray("DT Left", leftVolts);

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
		//return !physicalSwitch.get();

		return false;
	}

	public boolean getSwitchValue() {
		//return !testSwitch.get();
		return false;
	}

	public int getLineDiff() {
		return lineSensor2.getValue() - lineSensor.getValue(); // left - right
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}
}
