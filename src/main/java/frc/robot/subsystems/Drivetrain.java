package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.Hardware;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.drivetrain.DriveVoltage;
import frc.util.DriveHelper;
import frc.util.EncoderHelper;

public final class Drivetrain extends Subsystem implements Constants {

	private static final int lineTargetRight = 3500;
	private static final int lineTargetLeft = 3050;
	private static final int lineTolerance = 20;
	private static final double leftLineFactor = 0.1 / 500;
	private static final double rightLineFactor = 0.1 / 100;

	public double kPLeft = 5e-5;
	public double kILeft = 1e-6;
	public double kDLeft = 0;
	public double kPRight = 5e-5;
	public double kIRight = 1e-6;
	public double kDRight = 0;
	public double kMaxOutput = 1;
	public double kMinOutput = -1;
	public double maxRPM = 5700;
	/**
	 * the minimum number of seconds the robot can go from zero to full throttle
	 */
	public double rampRate = 1.5;

	private boolean pid = true;

	private double throttleDeadband = 0.08;
	private double headingDeadband = 0.07;

	private CANSparkMax leftDriveMaster = new CANSparkMax(LEFT_DRIVE_MASTER, CANSparkMaxLowLevel.MotorType.kBrushless);
	private CANSparkMax leftDriveSlave1 = new CANSparkMax(LEFT_DRIVE_SLAVE1, CANSparkMaxLowLevel.MotorType.kBrushless);
	private CANSparkMax leftDriveSlave2 = new CANSparkMax(LEFT_DRIVE_SLAVE2, CANSparkMaxLowLevel.MotorType.kBrushless);
	private CANSparkMax rightDriveMaster = new CANSparkMax(RIGHT_DRIVE_MASTER, CANSparkMaxLowLevel.MotorType.kBrushless);
	private CANSparkMax rightDriveSlave1 = new CANSparkMax(RIGHT_DRIVE_SLAVE1, CANSparkMaxLowLevel.MotorType.kBrushless);
	private CANSparkMax rightDriveSlave2 = new CANSparkMax(RIGHT_DRIVE_SLAVE2, CANSparkMaxLowLevel.MotorType.kBrushless);

	private CANEncoder leftEncoder = leftDriveMaster.getEncoder();
	private CANEncoder rightEncoder = rightDriveMaster.getEncoder();

	private CANPIDController leftPIDController = leftDriveMaster.getPIDController();
	private CANPIDController rightPIDController = rightDriveMaster.getPIDController();

	private CANSparkMax[] motors = {
		leftDriveMaster,
		leftDriveSlave1,
		leftDriveSlave2,
		rightDriveMaster,
		rightDriveSlave1,
		rightDriveSlave2
	};

	private DriveHelper driveHelper = new DriveHelper(7.5, throttleDeadband, headingDeadband);

	public Drivetrain() {
		setSlaves();
		setInverts();
		pushToShuffleboard();
		setPIDDefaults();
		setNeutralMode(IdleMode.kCoast);
	}

	// DRIVE METHODS

	public void driveVelocityJoystick(double throttle, double heading) {
		if (Math.abs(throttle) < throttleDeadband)
			throttle = 0;
		if (Math.abs(heading) < headingDeadband)
			heading = 0;

		driveVelocityPID(throttle, heading);
	}

	public void driveVelocityPID(double throttle, double heading) {
		pid = true;
		double velo = throttle * maxRPM;
		double turn = heading * maxRPM * .75;

		leftPIDController.setReference(velo - turn, ControlType.kVelocity);
		rightPIDController.setReference(velo + turn, ControlType.kVelocity);

		double[] leftData = {velo - turn, leftEncoder.getVelocity()};
		double[] rightData = {velo + turn, rightEncoder.getVelocity()};
		SmartDashboard.putNumberArray("Left Velo Control", leftData);
		SmartDashboard.putNumberArray("Right Velo Control", rightData);
	}

	// drive for teleop
	public void drive(double throttle, double heading) {
		pid = false;
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
		double rightCorrection = rightLineFactor * (lineTargetRight - Hardware.rightLineSensor.getValue());
		double leftCorrection = leftLineFactor * (lineTargetLeft - Hardware.leftLineSensor.getValue());
		if (Math.abs(lineTargetRight - Hardware.rightLineSensor.getValue()) < lineTolerance)
			rightCorrection = 0;
		if (Math.abs(lineTargetLeft - Hardware.leftLineSensor.getValue()) < lineTolerance)
			leftCorrection = 0;

		double heading = leftCorrection - rightCorrection;
		if (heading > 0.2)
			heading = 0.2;
		else if (heading < -0.2)
			heading = -0.2;
		System.out.println(heading);

		double[] push = {leftCorrection, rightCorrection, heading};
		SmartDashboard.putNumberArray("Drive Along line: ", push);
		driveVelocityPID(0.15, heading);
	}

	// CONFIG METHODS

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

	private void setNeutralMode(IdleMode mode) {
		for (CANSparkMax motor : motors)
			motor.setIdleMode(mode);
	}

	private void setLimits() {
		// find appropriate ramp rate + current limits
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

		leftDriveMaster.setRampRate(rampRate);
		rightDriveMaster.setRampRate(rampRate);
	}

	// SHUFFLEBOARD

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
		if (kPL != kPLeft || kIL != kILeft || kDL != kDLeft || kPR != kPRight || kIR != kIRight || kDR != kDRight
				|| ramp != rampRate) {
			kPLeft = kPL;
			kILeft = kIL;
			kDLeft = kDL;
			kPRight = kPR;
			kIRight = kIR;
			kDRight = kDR;
			rampRate = ramp;
			setPIDDefaults();
		}

		SmartDashboard.putNumber("Line sensor R", Hardware.rightLineSensor.getValue());
		SmartDashboard.putNumber("Line sensor L", Hardware.leftLineSensor.getValue());

		double[] rightVolts = {rightDriveMaster.getAppliedOutput(), rightDriveSlave1.getAppliedOutput(),
				rightDriveSlave2.getAppliedOutput()};
		double[] leftVolts = {leftDriveMaster.getAppliedOutput(), leftDriveSlave1.getAppliedOutput(),
				leftDriveSlave2.getAppliedOutput()};

		SmartDashboard.putNumberArray("DT Right", rightVolts);
		SmartDashboard.putNumberArray("DT Left", leftVolts);

	}

	// GET METHODS

	public boolean getIsPID() {
		return pid;
	}

	public double getLeftInches() {
		return EncoderHelper.revsToInches(leftEncoder.getPosition(), WHEEL_CIRCUM_TN) / LOW_GEAR_RATIO;
	}

	public double getRightInches() {
		return EncoderHelper.revsToInches(rightEncoder.getPosition(), WHEEL_CIRCUM_TN) / LOW_GEAR_RATIO;
	}

	public double getThrottleDeadband() {
		return throttleDeadband;
	}

	public double getHeadingDeadband() {
		return headingDeadband;
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new DriveVoltage());
	}
}
