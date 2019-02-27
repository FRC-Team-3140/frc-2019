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

