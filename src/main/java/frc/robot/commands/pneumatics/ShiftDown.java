package frc.robot.commands.pneumatics;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.*;

public class ShiftDown extends CommandGroup implements Constants {
  public ShiftDown() {
    addSequential(new Shift(RET));
    addSequential(new WaitCommand(.3));
    addSequential(new Shift(OFF));
  }
}
