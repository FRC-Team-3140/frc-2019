package frc.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Hardware;
import frc.robot.Robot;

public final class TiltTop extends Command {
	public TiltTop() {
		requires(Robot.getRobot().arm);
	}

	@Override
	protected void execute() {
		Robot.getRobot().arm.tiltArm(-0.7);
	}

	@Override
	protected boolean isFinished() {
		return Hardware.isArmTop();
	}
}
