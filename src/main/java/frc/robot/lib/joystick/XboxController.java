package frc.robot.lib.joystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.InternalButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public final class XboxController extends Joystick {
	private static boolean internalControl = false;
	// Button
	private JoystickButton aButton;
	private JoystickButton bButton;
	private JoystickButton xButton;
	private JoystickButton yButton;
	private JoystickButton selectButton;
	private JoystickButton startButton;
	// Thumb-stick buttons
	private JoystickButton leftJoystickPressButton;
	private JoystickButton rightJoystickPressButton;
	// Bumpers
	private JoystickButton leftBumperButton;
	private JoystickButton rightBumperButton;
	// Triggers
	private Button leftTriggerButton;
	private Button rightTriggerButton;
	
	// Internal Buttons
	public InternalButton a;
	public InternalButton b;
	public InternalButton x;
	public InternalButton y;
	public InternalButton select;
	public InternalButton start;
	// Thumb-stick InternalButtons
	public InternalButton leftJoystickPress;
	public InternalButton rightJoystickPress;
	// Bumpers
	public InternalButton leftBumper;
	public InternalButton rightBumper;
	// Triggers
	public InternalButton leftTrigger;
	public InternalButton rightTrigger;
	
	public XboxController(int port) {
		super(port);
		// Buttons
		aButton = new JoystickButton(this, 1);
		bButton = new JoystickButton(this, 2);
		xButton = new JoystickButton(this, 3);
		yButton = new JoystickButton(this, 4);
		leftBumperButton = new JoystickButton(this, 5);
		rightBumperButton = new JoystickButton(this, 6);
		selectButton = new JoystickButton(this, 7);
		startButton = new JoystickButton(this, 8);
		leftJoystickPressButton = new JoystickButton(this, 9);
		rightJoystickPressButton = new JoystickButton(this, 10);
		leftTriggerButton = new AnalogButton(this, 2, 0.1);
		rightTriggerButton = new AnalogButton(this, 3, 0.1);
		// InternalButtons
		a = new InternalButton();
		b = new InternalButton();
		x = new InternalButton();
		y = new InternalButton();
		leftBumper = new InternalButton();
		rightBumper = new InternalButton();
		select = new InternalButton();
		start = new InternalButton();
		leftJoystickPress = new InternalButton();
		rightJoystickPress = new InternalButton();
		leftTrigger = new InternalButton();
		rightTrigger = new InternalButton();
	}
	
	public void check() {
		if(!internalControl) {
			a.setPressed(aButton.get());
			b.setPressed(bButton.get());
			x.setPressed(xButton.get());
			y.setPressed(yButton.get());
			leftBumper.setPressed(leftBumperButton.get());
			rightBumper.setPressed(rightBumperButton.get());
			select.setPressed(selectButton.get());
			start.setPressed(startButton.get());
			leftJoystickPress.setPressed(leftJoystickPressButton.get());
			rightJoystickPress.setPressed(rightJoystickPressButton.get());
			leftTrigger.setPressed(leftTriggerButton.get());
			rightTrigger.setPressed(rightTriggerButton.get());
		}
	}
	
	public double getMainX(){
		return -super.getRawAxis(0);
	}
	
	public double getMainY(){
		return -super.getRawAxis(1);
	}
	
	public double getAltX(){
		return -super.getRawAxis(4);
	}
	
	public double getAltY(){
		return -super.getRawAxis(5);
	}
	
	public double getSmoothedMainX() {
		return -Math.sin(Math.PI/2 * super.getRawAxis(0));
	}
	
	public double getSmoothedMainY() {
		return -Math.sin(Math.PI/2 * super.getRawAxis(1));
	}
	
	public double getSmoothedAltX() {
		return -Math.sin(Math.PI/2 * super.getRawAxis(4));
	}
	
	public double getSmoothedAltY() {
		return -Math.sin(Math.PI/2 * super.getRawAxis(5));
	}
	
	public void setButtonStatus(boolean a, boolean b, boolean x, boolean y, boolean leftBumper, boolean rightBumper,
								boolean select, boolean start, boolean leftJoystickPress, boolean rightJoystickPress,
								boolean leftTrigger, boolean rightTrigger) {
		if(internalControl) {
			this.a.setPressed(a);
			this.b.setPressed(b);
			this.x.setPressed(x);
			this.y.setPressed(y);
			this.leftBumper.setPressed(leftBumper);
			this.rightBumper.setPressed(rightBumper);
			this.select.setPressed(select);
			this.start.setPressed(start);
			this.leftJoystickPress.setPressed(leftJoystickPress);
			this.rightJoystickPress.setPressed(rightJoystickPress);
			this.leftTrigger.setPressed(leftTrigger);
			this.rightTrigger.setPressed(rightTrigger);
		}
	}
	
	public void setInternalControl(boolean internalControl) {
		XboxController.internalControl = internalControl;		
	}

	public boolean getInternalControl() {
		return internalControl;
	}
}
