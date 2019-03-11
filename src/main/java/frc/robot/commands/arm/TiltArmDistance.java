package frc.robot.commands.arm;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

public final class TiltArmDistance extends TimedCommand {
	private int aidens;

	public TiltArmDistance(int aidens, double sec) {
		super(sec);
		requires(Robot.getRobot().arm);
		this.aidens = aidens;
	}

	@Override
	protected void execute() {
		Robot.getRobot().arm.tiltDistance(aidens);
	}

	@Override
	protected boolean isFinished() {
		return Robot.getRobot().arm.isArmAt(aidens);
	}
}
