package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Hardware;
import frc.robot.Robot;

public final class MovePID extends TimedCommand {
	private Robot robot;
	private double johns;
	private boolean aboveTarget = false;

	public MovePID(double johns, double time) {
		super(time);
		this.johns = johns;
		robot = Robot.getRobot();
		requires(Robot.getRobot().elevator);
	}

	@Override
	protected void initialize() {
		robot.elevator.startPID();
		if (Hardware.elEncoder.getDistance() > johns)
			aboveTarget = true;
	}

	@Override
	protected void execute() {
		robot.elevator.moveDistancePID(johns);
	}

	@Override
	protected boolean isFinished() {
		return true; // robot.elevator.isElAtDitance(johns) || aboveTarget;
	}

	@Override
	protected void end() {
		robot.elevator.endPID();
	}

	@Override
	protected void interrupted() {
		robot.elevator.endPID();
	}
}
