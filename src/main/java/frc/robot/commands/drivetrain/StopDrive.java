/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class StopDrive extends Command {
	public StopDrive() {
		requires(Robot.getRobot().drivetrain);
	}
	
	@Override
	protected void execute() {
		Robot.getRobot().drivetrain.tankDrive(0, 0);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
}
