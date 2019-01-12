package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.drivetrain.ArcadeDrive;

public class Drivetrain extends Subsystem {

	private final int LEFT_DRIVE_MASTER = 6,
		LEFT_DRIVE_SLAVE1 = 1,
		LEFT_DRIVE_SLAVE2 = 2,
		RIGHT_DRIVE_MASTER = 3,
    	RIGHT_DRIVE_SLAVE1 = 4,
    	RIGHT_DRIVE_SLAVE2 = 5;
	private Spark leftDriveMaster = new Spark(LEFT_DRIVE_MASTER),
		leftDriveSlave1 = new Spark(LEFT_DRIVE_SLAVE1),
		leftDriveSlave2 = new Spark(LEFT_DRIVE_SLAVE2),
		rightDriveMaster = new Spark(RIGHT_DRIVE_MASTER),
		rightDriveSlave1 = new Spark(RIGHT_DRIVE_SLAVE1),
		rightDriveSlave2 = new Spark(RIGHT_DRIVE_SLAVE2);
		
	public Drivetrain() {
		setSlaves();
	}

	public void arcadeDrive(double throttle, double heading) {
		leftDriveMaster.set(throttle + heading);
		rightDriveMaster.set(throttle - heading);
	}

	public void setSlaves() {
		// TODO set slave motors
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
	}
}
