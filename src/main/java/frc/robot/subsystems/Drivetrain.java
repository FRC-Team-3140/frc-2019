package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.drivetrain.Drive;
import frc.util.DriveHelper;

public final class Drivetrain extends Subsystem {

	// the following comments are the mechanical markers
	private final int LEFT_DRIVE_MASTER = 2, // 6
		LEFT_DRIVE_SLAVE1 = 3, // 5
		LEFT_DRIVE_SLAVE2 = 4, // 4
		RIGHT_DRIVE_MASTER = 5, // 3
		RIGHT_DRIVE_SLAVE1 = 6, // 2
		RIGHT_DRIVE_SLAVE2 = 7; // 1
	
	private double throttleDeadband = 0.08;
	private double headingDeadband = 0.07;
	
	private CANSparkMax
		leftDriveMaster = new CANSparkMax(LEFT_DRIVE_MASTER, CANSparkMaxLowLevel.MotorType.kBrushless),
		leftDriveSlave1 = new CANSparkMax(LEFT_DRIVE_SLAVE1, CANSparkMaxLowLevel.MotorType.kBrushless),
		leftDriveSlave2 = new CANSparkMax(LEFT_DRIVE_SLAVE2, CANSparkMaxLowLevel.MotorType.kBrushless),
		rightDriveMaster = new CANSparkMax(RIGHT_DRIVE_MASTER, CANSparkMaxLowLevel.MotorType.kBrushless),
		rightDriveSlave1 = new CANSparkMax(RIGHT_DRIVE_SLAVE1, CANSparkMaxLowLevel.MotorType.kBrushless),
		rightDriveSlave2 = new CANSparkMax(RIGHT_DRIVE_SLAVE2, CANSparkMaxLowLevel.MotorType.kBrushless);

	private DriveHelper driveHelper = new DriveHelper(7.5, throttleDeadband, headingDeadband);
		
	public Drivetrain() {
		setSlaves();
		// the robot should drive the other way
		setInverts();
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

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}

	public void setDeadbands(double throttle, double heading) {
		if (!(Double.isFinite(throttle) && Double.isFinite(heading))) throw new IllegalArgumentException("Deadbands must be finite!");

		throttleDeadband=throttle;
		headingDeadband=heading;
		driveHelper.setDeadbands(throttle, heading);
	}

	public double getThrottleDeadband() {
		return throttleDeadband;
	}

	public double getHeadingDeadband() {
		return headingDeadband;
	}
}
