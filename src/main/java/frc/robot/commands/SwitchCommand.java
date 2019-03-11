package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public abstract class SwitchCommand extends Command {
	private Command trueCommand;
	private Command falseCommand;

	public SwitchCommand(Command trueCommand, Command falseCommand) {
		this.trueCommand = trueCommand;
		this.falseCommand = falseCommand;
	}

	public void initialize() {
		if (source())
			trueCommand.start();
		else
			falseCommand.start();
	}

	public boolean isFinished() {
		return true;
	}

	public abstract boolean source();
}