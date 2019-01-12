package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;

public class Shifter extends Subsystem {
	private DoubleSolenoid shifter = new DoubleSolenoid(Config.SHIFTER_EXT, Config.SHIFTER_RET);

	public void shift(DoubleSolenoid.Value v) {
		shifter.set(v);
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
