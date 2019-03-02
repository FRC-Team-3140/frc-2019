package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

public class TimedDrive extends TimedCommand {
  double throttle;
  
  public TimedDrive(double throttle, double time) {
    super(time);
    requires(Robot.getRobot().drivetrain);
    this.throttle = throttle;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.getRobot().drivetrain.arcadeDrive(throttle, 0);
  }

  // Called once after timeout
  @Override
  protected void end() {
    Robot.getRobot().drivetrain.arcadeDrive(0,0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
