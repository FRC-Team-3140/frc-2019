package frc.robot.commands.pneumatics.climber;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.Robot;
import frc.robot.commands.SwitchCommandGroup;

public class SwitchClimb extends SwitchCommandGroup {

	public SwitchClimb(CommandGroup true_command, CommandGroup false_command) {
		super(true_command, false_command);
	}

	@Override
	public boolean source() {
		return Robot.getRobot().pneumatics.isClimbing;
	}
}
