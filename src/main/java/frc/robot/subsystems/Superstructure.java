package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * Future use to control subsystem interactions (like the cheesy poofs c:)
 */
public class Superstructure extends Subsystem {

	private Robot robot;

	public Superstructure() {
		robot = Robot.getRobot();
	}

	public void updateShuffleboard() {

	}

	@Override
	public void initDefaultCommand() {
	}
}
