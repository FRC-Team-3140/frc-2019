package frc.robot.commands.controllerCommands;

import frc.robot.controllers.Record;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class StartRecord extends Command {
	public StartRecord() {
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lg.resetForWrite();
    	Record.reachedFirstNonZero(false);
    	Record.okToRecord(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    	//return true;//(remove when switching back to record and play & use line above)
    }

    // Called once after isFinished returns true
    protected void end() {
    	Record.okToRecord(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}