package frc.robot.commands.controllerCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FileCreator extends Command {
	public FileCreator() {
	}
	
	// Called just before this Command runs the first time
    protected void initialize() {
		Robot.lg.createNewFile();
    }    	

	@Override
	protected boolean isFinished() {
		return true;
	}
}
