package frc.robot.lib.joystick;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.InternalButton;

/**
 * A D-pad button that gets its state from a GenericHID.
 * Created on 2018/2/4 15:45
 * @author Jason
 *
 */
public class DpadButton extends InternalButton {
	public static final int UP=0, DOWN=180, LEFT=270, RIGHT=90;
	private GenericHID hid;
	private int pov;
	
	/**
	 * Create a D-pad button for triggering commands.
	 * @param hid The GenericHID object that has the button (e.g. Joystick, KinectStick, etc)
	 * @param pov The target pov of the button
	 */
	public DpadButton(GenericHID hid, int pov) {
		super();
		this.hid=hid;
		this.pov=pov;
	}
	
	/**
	 * Returns whether or not the trigger is active.
	 */
	@Override
	public boolean get() {
		return hid.getPOV()==pov;
	}
	
	/**
	 * Resets the target pov of the button.
	 * @param pov The target pov of the button
	 */
	public void setPOV(int pov) {
		this.pov=pov;
	}
	
	/**
	 * Resets the GenericHID of the button.
	 * @param hid The GenericHID object that has the button (e.g. Joystick, KinectStick, etc)
	 */
	public void setHID(GenericHID hid) {
		this.hid=hid;
	}
}
