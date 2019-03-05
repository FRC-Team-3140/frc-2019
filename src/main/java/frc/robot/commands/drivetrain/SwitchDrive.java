package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SwitchDrive extends Command {
	Command true_command;
	Command false_command;

	public SwitchDrive(Command trueCommand, Command falseCommand) {
		true_command = trueCommand;
		false_command = falseCommand;
	}

	protected void initialize() {
		if (source())
			Robot.getRobot().drivetrain.setDefaultCommand(true_command);
		else
			Robot.getRobot().drivetrain.setDefaultCommand(false_command);
	}

	public boolean source() {
		return Robot.getRobot().drivetrain.getIsPID();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
