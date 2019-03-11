package frc.robot.commands.elevator;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public final class MoveLevel2 extends CommandGroup {
	private Robot bot = Robot.getRobot();
	private double height;

	public MoveLevel2() {
		if (bot.oi.getXboxController2().rightBumper.get())
			height = MID_HATCH;
		else
			height = MID_BALL;

		addSequential(new MovePID(height, 4));
	}
}
