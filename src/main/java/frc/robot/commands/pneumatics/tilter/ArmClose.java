package frc.robot.commands.pneumatics.tilter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.pneumatics.Pneumatics;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class TiltUp extends CommandGroup {
  
  public TiltUp() {
      addSequential(new Tilt(Pneumatics.RETRACT));
      addSequential(new WaitCommand(0.3));
      addSequential(new Tilt(Pneumatics.OFF));
  }
}
