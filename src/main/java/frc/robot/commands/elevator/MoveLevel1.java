package frc.robot.commands.elevator;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public final class MoveLevel1 extends CommandGroup {
	private Robot bot = Robot.getRobot();
	private double height;

	public MoveLevel1() {
		if (bot.oi.getXboxController2().rightBumper.get())
			height = LOW_HATCH;
		else
			height = LOW_BALL;

		addSequential(new MovePID(height, 2));
	}
}
