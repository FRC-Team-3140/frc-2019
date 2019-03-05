package frc.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Hardware;
import frc.robot.Robot;

public class TiltBot extends Command {
	public TiltBot() {
		requires(Robot.getRobot().arm);
	}

	@Override
	protected void execute() {
		Robot.getRobot().arm.tiltArm(0.3);
	}

	@Override
	protected boolean isFinished() {
		return Hardware.isArmBot();
	}
}
