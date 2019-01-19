package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public final class Pneumatics extends Subsystem {

	public static final DoubleSolenoid.Value EXTEND = Value.kForward;
	public static final DoubleSolenoid.Value RETRACT = Value.kReverse;
	public static final DoubleSolenoid.Value OFF = Value.kOff;

	public static final int SHIFTER_EXTEND = 0;
	public static final int SHIFTER_RETRACT = 7;
	public static final int CLIMBER_EXTEND = 1;
	public static final int CLIMBER_RETRACT = 6;
	public static final int PCM = 1; // Pneumatics control module

	@SuppressWarnings("unused")
	private Compressor compressor = new Compressor(PCM);
	private DoubleSolenoid shifter = new DoubleSolenoid(PCM, SHIFTER_EXTEND, SHIFTER_RETRACT);
	private DoubleSolenoid climber = new DoubleSolenoid(PCM, CLIMBER_EXTEND, CLIMBER_RETRACT);

	public void shift(DoubleSolenoid.Value v) {
		shifter.set(v);
	}

	public void climb(DoubleSolenoid.Value a){
		climber.set(a);
	}

	@Override
	public void initDefaultCommand() {
	}
}
