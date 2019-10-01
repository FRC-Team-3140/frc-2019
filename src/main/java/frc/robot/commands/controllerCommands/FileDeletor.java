package frc.robot.commands.controllerCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FileDeletor extends Command {
	public FileDeletor() {
	}
	
    protected void initialize() {
		Robot.lg.deleteFile(Robot.getFileChooser().getSelected().getName());
    }    	

	@Override
	protected boolean isFinished() {
		return true;
	}

}
