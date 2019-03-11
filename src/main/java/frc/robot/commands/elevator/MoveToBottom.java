package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Hardware;
import frc.robot.Robot;

public final class MoveToBottom extends TimedCommand {
	private Robot bot;

	public MoveToBottom() {
		super(5);
		bot = Robot.getRobot();
		requires(bot.elevator);
	}

	@Override
	protected void execute() {
		bot.elevator.elevatorMove(0.2);
	}

	@Override
	protected boolean isFinished() {
		return Hardware.isElDown();
	}
}
