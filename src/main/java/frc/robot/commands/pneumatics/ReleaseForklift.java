package frc.robot.commands.pneumatics;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.subsystems.Pneumatics;

public final class ReleaseForklift extends CommandGroup {
	public ReleaseForklift() {
		addSequential(new Forklift(Pneumatics.RETRACT));
		addSequential(new WaitCommand(0.3));
		addSequential(new Forklift(Pneumatics.OFF));
	}
}