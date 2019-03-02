/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.drivetrain.TimedDrive;

public class SelfTest extends CommandGroup {
  public SelfTest() {
    
    // DRIVETRAIN
    addSequential(new TimedDrive(.5, 2));
    addSequential(new TimedDrive(-.5, 2));

    // INTAKE
   // addSequential(new );
  }

}
