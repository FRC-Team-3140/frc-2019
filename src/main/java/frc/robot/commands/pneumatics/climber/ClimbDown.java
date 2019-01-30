package frc.robot.commands.pneumatics.climber;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.subsystems.*;

public class ClimbDown extends CommandGroup {
  public ClimbDown() {
	addSequential(new Climb(Pneumatics.RETRACT));
	addSequential(new WaitCommand(0.3));
    addSequential(new Climb(Pneumatics.OFF));
  }
}
