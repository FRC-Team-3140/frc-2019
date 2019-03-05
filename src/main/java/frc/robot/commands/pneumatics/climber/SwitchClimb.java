package frc.robot.commands.pneumatics.climber;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.Robot;
import frc.robot.libs.SwitchCommandGroup;

public class SwitchClimb extends SwitchCommandGroup {

	public SwitchClimb(CommandGroup trueC, CommandGroup falseC) {
		super(trueC, falseC);
	}

	@Override
	public boolean source() {
		return Robot.getRobot().pneumatics.isClimbing;
	}
}
