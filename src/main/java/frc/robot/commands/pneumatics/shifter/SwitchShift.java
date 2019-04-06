/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.pneumatics.shifter;


import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.libs.SwitchCommandGroup;


public class SwitchShift extends SwitchCommandGroup {

  	public SwitchShift(CommandGroup trueC, CommandGroup falseC) {
		super(trueC, falseC);
  	}

	@Override
	public boolean source() {
		return Robot.getRobot().pneumatics.highGear;
	}
}
