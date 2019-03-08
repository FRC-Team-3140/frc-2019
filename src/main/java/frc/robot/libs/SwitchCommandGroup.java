package frc.robot.libs;

import edu.wpi.first.wpilibj.command.CommandGroup;

public abstract class SwitchCommandGroup extends CommandGroup {
	private CommandGroup trueCommand;
	private CommandGroup falseCommand;

	public SwitchCommandGroup(CommandGroup trueCommand, CommandGroup falseCommand) {
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