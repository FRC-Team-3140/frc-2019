package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SwitchDrive extends Command {
  Command trueC;
  Command falseC;

  public SwitchDrive(Command trueCommand, Command falseCommand) {
    trueC = trueCommand;
    falseC = falseCommand;
  }

  protected void initialize() {
    if(source()) Robot.getRobot().drivetrain.setDefaultCommand(trueC);
    else Robot.getRobot().drivetrain.setDefaultCommand(falseC);
  }

  public boolean source() {
    return Robot.getRobot().drivetrain.getIsPID();
  }

  @Override
  protected boolean isFinished() {
    return true;
  }
}
