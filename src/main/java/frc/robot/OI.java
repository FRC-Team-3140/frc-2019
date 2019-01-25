package frc.robot;

import frc.robot.commands.pneumatics.ShiftDown;
import frc.robot.commands.pneumatics.ShiftUp;
import frc.robot.oi.ShuffleBoardController;
import frc.robot.oi.XboxController;

public final class OI {

	private static final int XBOX_PORT_1 = 0;

	private XboxController xbox1 = new XboxController(XBOX_PORT_1);
	private ShuffleBoardController shuffleboard = new ShuffleBoardController();

	public OI() {
		xbox1.leftBumper.whenPressed(new ShiftUp());
		xbox1.leftBumper.whenReleased(new ShiftDown());
	}

	/**
	 * Updates the OI information. No robot actions will be initiated.
	 */
	public void update() {
		shuffleboard.update();
	}

	public void check() {
		xbox1.check();
	}

	public XboxController getXboxController(){
		return xbox1;
	}
}
