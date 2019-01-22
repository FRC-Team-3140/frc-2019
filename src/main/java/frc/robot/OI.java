package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.commands.pneumatics.ShiftDown;
import frc.robot.commands.pneumatics.ShiftUp;
import frc.robot.lib.joystick.XboxController;

public final class OI {

	private static final int XBOX_PORT_1 = 0;

	private Robot robot = Robot.getRobot();
	private XboxController xbox1 = new XboxController(XBOX_PORT_1);
	private ShuffleboardTab
		settingsTab = Shuffleboard.getTab("Settings"),
		testTab = Shuffleboard.getTab("Test");
	private NetworkTableEntry
		throttleDeadbandEntry = settingsTab.add("Throttle Deadband", robot.drivetrain.getThrottleDeadband()).getEntry(),
		headingDeadbandEntry = settingsTab.add("Heading Deadband", robot.drivetrain.getHeadingDeadband()).getEntry(),
		testEntry = testTab.add("Stunt Double", 0).getEntry();

	public OI() {
		xbox1.leftBumper.whenPressed(new ShiftUp());
		xbox1.leftBumper.whenReleased(new ShiftDown());
	}

	/**
	 * Updates the necessary values from ShuffleBoard.
	 * <p>
	 * DO NOT cause any robot action in this method!
	 * It is called in all modes and any action will be triggered even when the robot is disabled.
	 */
	public void update() {
		double
			drive_throttle = robot.drivetrain.getThrottleDeadband(),
			drive_heading = robot.drivetrain.getHeadingDeadband(),
			throttle = throttleDeadbandEntry.getDouble(drive_throttle),
			heading = headingDeadbandEntry.getDouble(drive_heading);

		/*
		Note: When changing deadbands, e.g. entering value 0.05, the robot will recognize it as soon as "0" is entered.
		This can cause the robot to move a little bit while the deadbands are being changed.
		TL;DR: Don't change deadbands when the robot is enabled.
		*/
		if (throttle != drive_throttle || heading != drive_heading) {
			robot.drivetrain.setDeadbands(throttle, heading);
			System.out.println("[Info] Deadbands updated: throttle=" + throttle + " heading=" + heading);
		}
	}

	public void check() {
		xbox1.check();
	}

	public XboxController getXboxController(){
		return xbox1;
	}

	public double getTestEntry() {
		return testEntry.getDouble(0);
	}
}
