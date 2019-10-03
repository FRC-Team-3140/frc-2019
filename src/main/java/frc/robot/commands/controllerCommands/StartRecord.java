package frc.robot.commands.controllerCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.controllers.Record;
import frc.robot.Robot;

public class StartRecord extends Command {
	public StartRecord() {
    }

    protected void initialize() {
    	Robot.lg.resetForWrite();
    	Record.reachedFirstNonZero(false);
    	Record.okToRecord(true);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    	//return true;//(remove when switching back to record and play & use line above)
    }

    protected void end() {
    	Record.okToRecord(false);
    }

    protected void interrupted() {
    	end();
    }
}