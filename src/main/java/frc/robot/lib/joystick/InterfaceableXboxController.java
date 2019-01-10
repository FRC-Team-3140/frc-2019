package frc.robot.lib.joystick;

import edu.wpi.first.wpilibj.Joystick;

public abstract class InterfaceableXboxController extends Joystick {
	public InterfaceableXboxController(int port) {
		super(port);
	}
	
	public abstract void check();
	public abstract void setInternalControl(boolean internalControl);
	public abstract boolean getInternalControl();
	public abstract void setButtonStatus(boolean a, boolean b, boolean x, boolean y, boolean leftBumper, boolean rightBumper,
										boolean select, boolean start, boolean leftJoystickPress, boolean rightJoystickPress,
										boolean leftTrigger, boolean rightTrigger);
}
