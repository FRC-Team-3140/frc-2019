package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

public final class Pneumatics extends Subsystem implements Constants {

	public static final DoubleSolenoid.Value EXTEND = Value.kForward;
	public static final DoubleSolenoid.Value RETRACT = Value.kReverse;
	public static final DoubleSolenoid.Value OFF = Value.kOff;

	@SuppressWarnings("unused")
	private Compressor compressor = new Compressor(PCM),
		 compressor2 = new Compressor(PCM2);

	private DoubleSolenoid shifter = new DoubleSolenoid(PCM, SHIFTER_EXTEND, SHIFTER_RETRACT);
	private DoubleSolenoid arm = new DoubleSolenoid(PCM, ARM_EXTEND, ARM_RETRACT);
	private Solenoid puncher = new Solenoid(PCM, PUNCHER);
	private DoubleSolenoid climber = new DoubleSolenoid(PCM, CLIMBER_EXTEND, CLIMBER_RETRACT);
	private DoubleSolenoid forklift = new DoubleSolenoid(PCM2, FORKLIFT_EXTEND, FORKLIFT_RETRACT);

	public void shift(DoubleSolenoid.Value v) {
		shifter.set(v);
	}

	public void toggleArm(DoubleSolenoid.Value b){
		arm.set(b);
	}

	public void puncher(boolean on){
		puncher.set(on);
	}

	public void climb(DoubleSolenoid.Value a){
		climber.set(a);
	}

	public void forklift(DoubleSolenoid.Value value) {
		forklift.set(value);
	}

	@Override
	public void initDefaultCommand() {
	}
}