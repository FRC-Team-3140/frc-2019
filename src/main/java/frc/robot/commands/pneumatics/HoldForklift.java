package frc.robot.commands.pneumatics;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.subsystems.pneumatics.Pneumatics;

public final class HoldForklift extends CommandGroup {
	public HoldForklift() {
		addSequential(new Forklift(Pneumatics.EXTEND));
		addSequential(new WaitCommand(0.3));
		addSequential(new Forklift(Pneumatics.OFF));
	}
}