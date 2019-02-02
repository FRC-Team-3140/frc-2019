package frc.robot.oi;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Robot;

public final class ShuffleBoardController {
	private Robot robot = Robot.getRobot();
	private ShuffleboardTab
		settingsTab = Shuffleboard.getTab("Settings"),
		testTab = Shuffleboard.getTab("Test");
	private NetworkTableEntry
		throttleDeadbandEntry = settingsTab.add("Throttle Deadband", robot.drivetrain.getThrottleDeadband()).getEntry(),
		headingDeadbandEntry = settingsTab.add("Heading Deadband", robot.drivetrain.getHeadingDeadband()).getEntry(),
		testEntry = testTab.add("Stunt Double", 0).getEntry();

	/**
	 * Updates the necessary values from ShuffleBoard.
	 * <p>
	 * Note: When changing deadbands, e.g. entering value 0.05, the robot will recognize it as soon as "0" is entered.
	 * This can cause the robot to move a little bit while the deadbands are being changed.
	 * <p>
	 * TL;DR: Don't change deadbands when the robot is enabled.
	 */
	/*
	DO NOT cause any robot action in this method!
	It is called in all modes and any action will be triggered even when the robot is disabled.
	*/
	public void update() {
		double
			drive_throttle = robot.drivetrain.getThrottleDeadband(),
			drive_heading = robot.drivetrain.getHeadingDeadband(),
			throttle = throttleDeadbandEntry.getDouble(drive_throttle),
			heading = headingDeadbandEntry.getDouble(drive_heading);

		if (throttle != drive_throttle || heading != drive_heading) {
			robot.drivetrain.setDeadbands(throttle, heading);
			System.out.println("[Info] Deadbands updated: throttle=" + throttle + " heading=" + heading);
		}
	}

	public double getTestEntry() {
		return testEntry.getDouble(0);
	}
}