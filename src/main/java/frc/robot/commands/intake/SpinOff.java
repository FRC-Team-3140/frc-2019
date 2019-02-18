package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SpinOff extends Command {
  public SpinOff() {
    requires(Robot.getRobot().intake);
  }

  @Override
  protected void execute() {
    Robot.getRobot().intake.spinOff();
  }

  @Override
  protected boolean isFinished() {
    return true;
  }
}