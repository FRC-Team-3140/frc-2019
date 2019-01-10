package frc.robot.lib.joystick;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.InternalButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class AdvJoystick extends InterfaceableJoystick {
	private static boolean internalControl = false;
	// Buttons
	private Button triggerButton;
	private Button thumbButton;
	private Button threeButton;
	private Button fourButton;
	private Button fiveButton;
	private Button sixButton;
	
	// Internal Buttons
	public InternalButton trigger;
	public InternalButton thumb;
	public InternalButton three;
	public InternalButton four;
	public InternalButton five;
	public InternalButton six;	
	
	public AdvJoystick(int port) {
		super(port);
		//Buttons
		triggerButton = new JoystickButton(this, 1);
		thumbButton = new JoystickButton(this, 2);
		threeButton = new JoystickButton(this, 3);
		fourButton = new JoystickButton(this, 4);
		fiveButton = new JoystickButton(this, 5);
		sixButton = new JoystickButton(this, 6);
		//Internal Buttons
		trigger = new InternalButton();
		thumb = new InternalButton();
		three = new InternalButton();
		four = new InternalButton();
		five = new InternalButton();
		six = new InternalButton();
	}
	
	@Override
	public void check() {
		if(!internalControl) {
			trigger.setPressed(triggerButton.get());
			thumb.setPressed(thumbButton.get());
			three.setPressed(threeButton.get());
			four.setPressed(fourButton.get());
			five.setPressed(fiveButton.get());
			six.setPressed(sixButton.get());

		}
	}
	
	public double getMainX() {
		//return Math.pow(super.getRawAxis(0), 3);
		return Math.sin(Math.PI/2 * super.getRawAxis(0));
	}

	public double getMainY() {
		//return Math.pow(super.getRawAxis(1), 3);
		return Math.sin(Math.PI/2 * super.getRawAxis(1));
	}

	@Override
	public void setButtonStatus(boolean trigger, boolean thumb, boolean three, boolean four, boolean five, 
								boolean six) {
		if(internalControl) {
			this.trigger.setPressed(trigger);
			this.thumb.setPressed(thumb);
			this.three.setPressed(four);
			this.four.setPressed(four);
			this.five.setPressed(five);
			this.six.setPressed(six);
		}
	}

	@Override
	public void setInternalControl(boolean internalControl) {
		AdvJoystick.internalControl = internalControl;
	}

	@Override
	public boolean getInternalControl() {
		return internalControl;
	}
}
