package frc.robot.commands.pneumatics.forklift;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public final class Forklift extends Command {
	private DoubleSolenoid.Value value;

	public Forklift(DoubleSolenoid.Value value) {
		requires(Robot.getRobot().pneumatics);
		this.value = value;
	}

	@Override
	protected void execute() {
		Robot.getRobot().pneumatics.forklift(value);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}