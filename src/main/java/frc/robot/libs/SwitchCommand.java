/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.libs;

import edu.wpi.first.wpilibj.command.Command;

public abstract class SwitchCommand extends Command {
	Command trueCommand;
	Command falseCommand;
	
	public SwitchCommand(Command trueCommand, Command falseCommand) {
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