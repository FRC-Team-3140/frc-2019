package frc.robot.commands.pneumatics;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.subsystems.pneumatics.Pneumatics;

public final class ShiftDown extends CommandGroup {
	public ShiftDown() {
		addSequential(new Shift(Pneumatics.RETRACT));
		addSequential(new WaitCommand(0.3));
		addSequential(new Shift(Pneumatics.OFF));
	}
}
