package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveVoltage extends Command {
  Robot robot;
  public DriveVoltage() {
    robot = Robot.getRobot();
    requires(robot.drivetrain);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.getRobot().drivetrain.drive(robot.oi.getXboxController().getMainY(),
          robot.oi.getXboxController().getAltX());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

}
