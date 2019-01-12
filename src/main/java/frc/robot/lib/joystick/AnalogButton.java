package frc.robot.lib.joystick;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

public class AnalogButton extends Button {
	private GenericHID joystick;
	private int axisNumber;
	private double threshold = 0.5;

	public static double myDouble = 0.9;

	/**
	 * Create a button for triggering commands off a joystick's analog axis
	 * 
	 * @param joystick The GenericHID object that has the button (e.g. Joystick, KinectStick, etc)
	 * @param axisNumber The axis number
	 */
	public AnalogButton(GenericHID joystick, int axisNumber) {
		this.joystick = joystick;
		this.axisNumber = axisNumber;
	}

	/**
	 * Create a button for triggering commands off a joystick's analog axis
	 * 
	 * @param joystick - The GenericHID object that has the button (e.g. Joystick, Xbox-controller, etc)
	 * @param axisNumber - The axis number
	 * @param threshold - The threshold to trigger above (positive) or below (negative)
	 */
	public AnalogButton(GenericHID joystick, int axisNumber, double threshold) {
		this.joystick = joystick;
		this.axisNumber = axisNumber;
		this.threshold = threshold;
	}

	/**
	 * Set the value above which triggers should occur (for positive thresholds)
	 * or below which triggers should occur (for negative thresholds) The
	 * default threshold value is 0.5
	 * 
	 * @param threshold - the threshold value (1 to -1)
	 */
	public void setthreshold(double threshold) {
		this.threshold = threshold;
	}

	/**
	 * Get the defined threshold value.
	 * 
	 * @return the threshold value
	 */
	public double getthreshold() {
		return threshold;
	}

	public boolean get() {
		if (threshold < 0) {
			return joystick.getRawAxis(axisNumber) < threshold; 
		} else {
			return joystick.getRawAxis(axisNumber) > threshold; 
		}
	}
}
