package frc.robot.commands.pneumatics.arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.SwitchCommandGroup;

public final class SwitchArm extends SwitchCommandGroup {

	public SwitchArm(CommandGroup trueCommand, CommandGroup falseCommand) {
		super(trueCommand, falseCommand);
	}

	@Override
	public boolean source() {
		return Robot.getRobot().pneumatics.intakeOpen;
	}
}
