/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

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

