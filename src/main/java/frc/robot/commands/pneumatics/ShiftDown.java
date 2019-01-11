package frc.robot.commands.pneumatics;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.*;

public class ShiftDown extends CommandGroup {

  public ShiftDown() {
    addSequential(new Shift(RET));
    addSequential(new WaitCommand(.3));
    addSequential(new Shift(OFF));
   
  }
}
