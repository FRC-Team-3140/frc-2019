package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.Robot;

public class MoveLevel3 extends CommandGroup implements Constants {
  Robot bot = Robot.getRobot();
  double height;

  public MoveLevel3() {
    if(bot.oi.getXboxController2().rightBumper.get()) 
      height = TOP_HATCH;
    else height = TOP_BALL;

    addSequential(new MovePID(height, 6));
  }
}

