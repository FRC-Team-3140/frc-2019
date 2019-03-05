package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Hardware;
import frc.robot.Robot;

public class MovePID extends TimedCommand {
	Robot robot;
	double johns;
	boolean aboveTarget = false;

	public MovePID(double johns, double time) {
		super(time);
		this.johns = johns;
		robot = Robot.getRobot();
		requires(Robot.getRobot().elevator);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		robot.elevator.startPID();
		if (Hardware.elEncoder.getDistance() > johns)
			aboveTarget = true;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		robot.elevator.moveDistancePID(johns);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true; // robot.elevator.isElAtDitance(johns) || aboveTarget;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		robot.elevator.endPID();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		robot.elevator.endPID();
	}
}
