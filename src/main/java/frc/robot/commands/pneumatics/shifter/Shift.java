package frc.robot.commands.pneumatics.shifter;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public final class Shift extends Command {
	private DoubleSolenoid.Value v;

	public Shift(DoubleSolenoid.Value v) {
		requires(Robot.getRobot().pneumatics);
		this.v = v;
	}

	@Override
	protected void execute() {
		Robot.getRobot().pneumatics.shift(v);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
