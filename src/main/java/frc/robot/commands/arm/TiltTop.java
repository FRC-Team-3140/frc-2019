package frc.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Hardware;
import frc.robot.Robot;

public class TiltTop extends Command {
  public TiltTop() {
    requires(Robot.getRobot().arm);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      Robot.getRobot().arm.tiltArm(-0.7);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Hardware.isArmTop();
  }

}
