package frc.robot.commands.pneumatics.puncher;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public final class Punch extends Command {

	private boolean c;

	public Punch(boolean c) {
		 requires(Robot.getRobot().pneumatics);
		 this.c = c;
	}

	@Override
	protected void execute() {
		Robot.getRobot().pneumatics.puncher(c);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
