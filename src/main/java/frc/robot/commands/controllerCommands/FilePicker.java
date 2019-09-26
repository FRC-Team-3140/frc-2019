package frc.robot.commands.controllerCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FilePicker extends Command {
	private String filePath = "";
	private boolean useFileLookup;
	
	public FilePicker(String filePath, boolean useFileLookup) {
		this.filePath = filePath;
		this.useFileLookup = useFileLookup;
		this.setName(filePath);
	}
	
	protected void initialize() {
		Robot.lg.changePath(filePath, useFileLookup);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
