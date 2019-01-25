package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public final class Pneumatics extends Subsystem {

	public static final DoubleSolenoid.Value EXTEND = Value.kForward;
	public static final DoubleSolenoid.Value RETRACT = Value.kReverse;
	public static final DoubleSolenoid.Value OFF = Value.kOff;

	public static final int
		SHIFTER_EXTEND = 0,
		SHIFTER_RETRACT = 7,
		FORKLIFT_EXTEND = 1,
		FORKLIFT_RETRACT = 7;
	public static final int PCM = 1; // Pneumatics control module

	@SuppressWarnings("unused")
	private Compressor compressor = new Compressor(PCM);
	private DoubleSolenoid
		shifter = new DoubleSolenoid(PCM, SHIFTER_EXTEND, SHIFTER_RETRACT),
		forklift = new DoubleSolenoid(PCM, FORKLIFT_EXTEND, FORKLIFT_RETRACT);

	public void shift(DoubleSolenoid.Value v) {
		shifter.set(v);
	}

	public void forklift(DoubleSolenoid.Value value) {
		forklift.set(value);
	}

	@Override
	public void initDefaultCommand() {
	}
}
