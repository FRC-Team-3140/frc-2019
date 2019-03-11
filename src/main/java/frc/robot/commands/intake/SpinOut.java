package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public final class SpinOut extends Command {
	public SpinOut() {
		requires(Robot.getRobot().intake);
	}

	@Override
	protected void execute() {
		Robot.getRobot().intake.spinOut();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
