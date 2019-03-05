package frc.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TiltArm extends Command {
	public TiltArm() {
		requires(Robot.getRobot().arm);
	}

	@Override
	protected void execute() {
		Robot.getRobot().arm.tiltArm(Robot.getRobot().oi.getXboxController2().getSmoothedMainY());
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
