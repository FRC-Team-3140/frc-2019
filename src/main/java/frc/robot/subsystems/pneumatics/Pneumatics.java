package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public final class Pneumatics extends Subsystem {

	public static final DoubleSolenoid.Value EXTEND = Value.kForward;
	public static final DoubleSolenoid.Value RETRACT = Value.kReverse;
	public static final DoubleSolenoid.Value OFF = Value.kOff;

	// 0 and 7 are the current ports on chassis bot
	public static final int SHIFTER_EXTEND = 1;
	public static final int SHIFTER_RETRACT = 6;
	public static final int ARM_EXTEND = 1;
	public static final int ARM_RETRACT = 6;	
	public static final int PUNCHER = 2;
	public static final int CLIMBER_EXTEND = 1;
	public static final int CLIMBER_RETRACT = 6;
	public static final int PCM = 1; // Pneumatics control module

	@SuppressWarnings("unused")
	private Compressor compressor = new Compressor(PCM);
	private DoubleSolenoid shifter = new DoubleSolenoid(PCM, SHIFTER_EXTEND, SHIFTER_RETRACT);
	private DoubleSolenoid arm = new DoubleSolenoid(PCM, ARM_EXTEND, ARM_RETRACT);
	private Solenoid puncher = new Solenoid(PCM, PUNCHER);
	private DoubleSolenoid climber = new DoubleSolenoid(PCM, CLIMBER_EXTEND, CLIMBER_RETRACT);

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

	@Override
	public void initDefaultCommand() {
	}
}
