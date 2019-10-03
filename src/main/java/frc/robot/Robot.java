/*
frc-2019: Robot code for 3140 Flagship in FIRST Robotics Competition 2019 Deep Space
Copyright (C) 2018 3140 Flagship

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.	See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.	If not, see <https://www.gnu.org/licenses/>.
*/

package frc.robot;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.controllers.Record;
import frc.loopController.Looper;
import frc.robot.commands.DoNothing;
import frc.robot.commands.controllerCommands.FileCreator;
import frc.robot.commands.controllerCommands.FileDeletor;
import frc.robot.commands.controllerCommands.FilePicker;
import frc.robot.commands.controllerCommands.StartRecord;
import frc.robot.subsystems.*;
import frc.util.Logger;

public final class Robot extends TimedRobot implements Constants {

	private static Robot robot;

	// RECORD AND FILE STUFF
	private static Looper autoLooper;
    private static SendableChooser<Command> fileChooser;
    private static String newFileName = "";
    private static List<File> listOfFiles = new ArrayList<File>();
	private static int lastNumOfFiles = 0;
	private Command lastSelectedFile = new DoNothing();
	public static Logger lg;

	// SUBSYTEMS	
	public static Drivetrain drivetrain;
	public Pneumatics pneumatics;
	public Elevator elevator;
	public Intake intake;
	public Arm arm;
	public static DriverCamera camera; // disabled because it is missing
	public OI oi;


	public static Robot getRobot() {
		return robot;
	}

	@Override
	public void robotInit() {
		robot = this;

		drivetrain = new Drivetrain();
		pneumatics = new Pneumatics();
		elevator = new Elevator();
		intake = new Intake();
		arm = new Arm();
		camera = new DriverCamera();
		// OI must be at the bottom
		oi = new OI();

		// RECORD AND FILE STUFF
		lg = new Logger();
		autoLooper = new Looper(kLooperDt);
		autoLooper.register(new Record());

		SmartDashboard.putData("Record", new StartRecord());
		// File adder
		SmartDashboard.putString("New File Name", "");
		SmartDashboard.putData("Create a new file", new FileCreator()); 
		// File deleter
		SmartDashboard.putData("Delete a file", new FileDeletor());
		// FileSelector
    	fileChooser = new SendableChooser<>();
    	fileChooser.setDefaultOption("", new DoNothing());
		SmartDashboard.putData("File Selector", fileChooser);

		SmartDashboard.putString("NOTICE:", "Whenever you redeploy code you must restart shuffleboard; And whenever you "
		+ "delete a file you must restart robot code."); //TODO can we fix that and why is that the case
	}

	@Override
	public void robotPeriodic() {
		drivetrain.updateShuffleboard();
		elevator.updateShuffleboard();
		elevator.check();
		arm.check();
		arm.updateShuffleboard();
		intake.updateShuffleboard();
	}

	@Override
	public void autonomousPeriodic() {
		teleopPeriodic();
	}

	@Override
	public void teleopInit() {
		autoLooper.start();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		oi.check();
		checkForSmartDashboardUpdates();
		SmartDashboard.putString("Working File", lg.getWorkingFile()); // to know where the path is
	}

	/****************
	 * RECORD STUFF *
	 ****************/
	private void checkForSmartDashboardUpdates() {
		// Executed when the String in "New File Name" in SDB is changed
		// Updates the String value newFileName to the latest value entered in SDB
		if (!newFileName.equals(SmartDashboard.getString("New File Name", ""))) {
			newFileName = SmartDashboard.getString("New File Name", "");
			System.out.println(newFileName);
		}
		
		// Executed when the value of the Command lastSelectedFile changes 
		// (This is activated when a new file is selected in the SDB)
		// Changes the value of lastSelected file to the working file path
		if (fileChooser.getSelected() != lastSelectedFile && fileChooser.getSelected() != null) {
			fileChooser.getSelected().start();
			lastSelectedFile = fileChooser.getSelected();
		}
		
		// Executed when the number of files in our folder changes
		// (This is activated when a new file is created)
		// Creates a new file. Updates the value of lastNumOfFiles and listOfFiles
		if (lg.getFiles(outputPath).length != lastNumOfFiles) {
			for (File file : lg.getFiles(outputPath))
				if (!fileNameInListOfFiles(listOfFiles, file)) {
					fileChooser.addOption(file.getName(), new FilePicker(file.getPath(), true)); //what does the boolean do? TODO
					listOfFiles.add(file);
				}
			lastNumOfFiles = lg.getFiles(outputPath).length;
		} 
	}
	
	// Checks if a file is in the file list
	private boolean fileNameInListOfFiles(List<File> l, File f) {
		for(File file: l) {
			if(file.getName().toLowerCase().equals(f.getName().toLowerCase()))
				return true;
		}
		return false;
	}

	public static SendableChooser<Command> getFileChooser() {
		return fileChooser;
	}
	
	// Gets the file selected in SDB's "File Selector"
	// NOTE: this is NOT ALWAYS the same as the file in the working path!!!!!
	public static Command getFile() {
		return fileChooser.getSelected();
	}

	public static String getNewFileName() {
		return newFileName;
	}
}
