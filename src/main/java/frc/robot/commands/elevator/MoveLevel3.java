package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.Robot;

public final class MoveLevel3 extends CommandGroup implements Constants {
	private Robot bot = Robot.getRobot();
	private double height;

	public MoveLevel3() {
		if (bot.oi.getXboxController2().rightBumper.get())
			height = TOP_HATCH;
		else
			height = TOP_BALL;

		addSequential(new MovePID(height, 6));
	}
}
