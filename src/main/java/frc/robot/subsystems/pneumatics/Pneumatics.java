package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public final class Pneumatics extends Subsystem {

	public static final DoubleSolenoid.Value EXTEND = Value.kForward;
	public static final DoubleSolenoid.Value RETRACT = Value.kReverse;
	public static final DoubleSolenoid.Value OFF = Value.kOff;

	public static final int EXTEND_CHANNEL = 1;
	public static final int RETRACT_CHANNEL = 0;
	
	private DoubleSolenoid shifter = new DoubleSolenoid(EXTEND_CHANNEL, RETRACT_CHANNEL);

	public void shift(DoubleSolenoid.Value v) {
		shifter.set(v);
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
