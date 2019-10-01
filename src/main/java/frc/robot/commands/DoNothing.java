package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class DoNothing extends CommandGroup {
  public DoNothing() {
	addSequential(new WaitCommand(15));
  }
}
