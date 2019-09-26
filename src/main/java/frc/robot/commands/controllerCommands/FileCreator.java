package frc.robot.commands.controllerCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FileCreator extends Command {
	public FileCreator() {
	}
	
	// TODO this
    protected void initialize() {
		//Robot.lg.createNewFile(Robot.getNewFileName());
    }    	

	@Override
	protected boolean isFinished() {
		return true;
	}
}
