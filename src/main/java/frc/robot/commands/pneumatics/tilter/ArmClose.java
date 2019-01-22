package frc.robot.commands.pneumatics.tilter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.pneumatics.Pneumatics;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ArmClose extends CommandGroup {
  
  public ArmClose() {
      addSequential(new Arm(Pneumatics.RETRACT));
      addSequential(new WaitCommand(0.3));
      addSequential(new Arm(Pneumatics.OFF));
  }
}
