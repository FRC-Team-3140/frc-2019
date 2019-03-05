package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.Robot;

public class MoveLevel1 extends CommandGroup implements Constants {
  Robot bot = Robot.getRobot();
  double height;

  public MoveLevel1() {
    if(bot.oi.getXboxController2().rightBumper.get()) 
      height = LOW_HATCH;
    else height = LOW_BALL;

    addSequential(new MovePID(height, 2));
  }
}
