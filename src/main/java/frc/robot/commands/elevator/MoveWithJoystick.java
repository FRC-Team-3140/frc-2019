package frc.robot.commands.elevator;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class MoveWithJoystick extends Command {
  private Robot robot;

  public MoveWithJoystick() {
    robot = Robot.getRobot();
    requires(robot.elevator);
  }

  @Override
  protected void execute() {
    robot.elevator.elevatorMove(robot.oi.getXboxController2().getMainY());
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

}
