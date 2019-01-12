package frc.robot.commands.pneumatics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Shift extends Command {
	private DoubleSolenoid.Value v;

	public Shift(DoubleSolenoid.Value v) {
		 requires(Robot.shifter);
		 this.v = v;
	}

	@Override
	protected void execute() {
		Robot.shifter.shift(v);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
