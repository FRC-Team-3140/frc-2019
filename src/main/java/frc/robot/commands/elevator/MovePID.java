package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

public final class MovePID extends TimedCommand {
	private Robot robot;
	private double johns;

	public MovePID(double johns, double time) {
		super(time);
		this.johns = johns;
		robot = Robot.getRobot();
		requires(Robot.getRobot().elevator);
	}

	@Override
	protected void execute() {
		robot.elevator.moveDistancePID(johns);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
