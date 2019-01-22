package frc.robot.commands.pneumatics.puncher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class PunchHatch extends CommandGroup {

  public PunchHatch() {
    addSequential(new Punch(true));
    addSequential(new WaitCommand(0.5));
    addSequential(new Punch(false));
  }
}
