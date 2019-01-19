package frc.robot.commands.pneumatics.shifter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.subsystems.pneumatics.Pneumatics;

public final class ShiftUp extends CommandGroup {
	public ShiftUp() {
		addSequential(new Shift(Pneumatics.EXTEND));
		addSequential(new WaitCommand(0.3));
		addSequential(new Shift(Pneumatics.OFF));
	}
}
