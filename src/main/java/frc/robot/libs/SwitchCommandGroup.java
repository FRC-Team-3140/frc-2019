/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.libs;

import edu.wpi.first.wpilibj.command.CommandGroup;

public abstract class SwitchCommandGroup extends CommandGroup {
	CommandGroup trueCommand;
	CommandGroup falseCommand;
	
	public SwitchCommandGroup(CommandGroup trueCommand, CommandGroup falseCommand) {
		this.trueCommand = trueCommand;
		this.falseCommand = falseCommand;
	}
	
	public void initialize() {
		if(source()) trueCommand.start();
        else falseCommand.start();
	}

	public boolean isFinished() {
		return true;
	}

	public abstract boolean source();
}