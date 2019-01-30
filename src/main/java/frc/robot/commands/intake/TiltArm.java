package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TiltArm extends Command {
  public TiltArm() {
    requires(Robot.getRobot().intake);
  }

  @Override
  protected void execute() {
    //TODO change to xbox 2
    Robot.getRobot().intake.tiltArm(Robot.getRobot().oi.getXboxController().getSmoothedAltY());
  }

  @Override
  protected boolean isFinished() {
    return true;
  }
}
