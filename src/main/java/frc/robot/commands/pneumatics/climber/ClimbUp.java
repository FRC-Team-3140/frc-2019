package frc.robot.commands.pneumatics.climber;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.subsystems.*;

public final class ClimbUp extends CommandGroup {

	public ClimbUp() {
		addSequential(new Climb(Pneumatics.EXTEND));
		addSequential(new WaitCommand(0.3));
		addSequential(new Climb(Pneumatics.OFF));
	}
}
