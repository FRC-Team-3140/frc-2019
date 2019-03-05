package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.Robot;

public class MoveLevel2 extends CommandGroup implements Constants {
  Robot bot = Robot.getRobot();
  double height;

  public MoveLevel2() {
    if(bot.oi.getXboxController2().rightBumper.get()) 
      height = MID_HATCH;
    else height = MID_BALL;

    addSequential(new MovePID(height, 4));
  }
}

