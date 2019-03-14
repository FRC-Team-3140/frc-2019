package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

public final class Pneumatics extends Subsystem implements Constants {

	public static final DoubleSolenoid.Value EXTEND = Value.kForward;
	public static final DoubleSolenoid.Value RETRACT = Value.kReverse;
	public static final DoubleSolenoid.Value OFF = Value.kOff;

	public boolean intakeOpen = false;
	public boolean isClimbing = false;

	@SuppressWarnings("unused")
	private Compressor compressor = new Compressor(PCM);

	private DoubleSolenoid shifter = new DoubleSolenoid(PCM, SHIFTER_EXTEND, SHIFTER_RETRACT);
	private DoubleSolenoid arm = new DoubleSolenoid(PCM, ARM_EXTEND, ARM_RETRACT);

	// Disabled climber and forklift for the upcoming practice robot
	// private DoubleSolenoid climber = new DoubleSolenoid(PCM, CLIMBER_EXTEND, CLIMBER_RETRACT);
	// private DoubleSolenoid forklift = new DoubleSolenoid(PCM, FORKLIFT_EXTEND, FORKLIFT_RETRACT);

	public void shift(DoubleSolenoid.Value v) {
		shifter.set(v);
	}

	public void toggleArm(DoubleSolenoid.Value b){
		if(b == EXTEND) intakeOpen = true;
		else if(b == RETRACT) intakeOpen = false;
		arm.set(b);
	}

	public void climb(DoubleSolenoid.Value a){
		// climber.set(a);
		if(a == EXTEND) isClimbing = false;
		else if(a == RETRACT) isClimbing = true;
	}

	public void forklift(DoubleSolenoid.Value value) {
		// forklift.set(value);
	}

	@Override
	public void initDefaultCommand() {
	}
}
