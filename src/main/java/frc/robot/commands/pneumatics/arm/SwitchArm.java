package frc.robot.commands.pneumatics.arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.libs.SwitchCommandGroup;

public class SwitchArm extends SwitchCommandGroup {

	public SwitchArm(CommandGroup trueC, CommandGroup falseC) {
		super(trueC, falseC);
	}

	@Override
	public boolean source() {
		return Robot.getRobot().pneumatics.intakeOpen;
	}
}
