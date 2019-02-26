package frc.robot.commands.pneumatics.arm;

import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.*;

public final class ArmOpen extends CommandGroup {

  public ArmOpen() { 
    addSequential(new Arm(Pneumatics.EXTEND));
    addSequential(new WaitCommand(0.3));
    addSequential(new Arm(Pneumatics.OFF));  
  }
}
