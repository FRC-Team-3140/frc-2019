package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Hardware;
import frc.robot.Robot;

public class MoveToBottom extends TimedCommand {
  Robot bot;

  public MoveToBottom() {
    super(5);
    bot = Robot.getRobot();
    requires(bot.elevator);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    bot.elevator.elevatorMove(0.2);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Hardware.isElDown();
  }
}
