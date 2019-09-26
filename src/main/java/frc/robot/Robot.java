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

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.pneumatics.arm.ArmOpen;
import frc.robot.commands.pneumatics.shifter.ShiftUp;
import frc.robot.subsystems.*;
import frc.util.Logger;

public final class Robot extends TimedRobot {

	private static Robot robot;

	public static Drivetrain drivetrain;
	public Pneumatics pneumatics;
	public Elevator elevator;
	public Intake intake;
	public Arm arm;
	public static DriverCamera camera; // disabled because it is missing
	public OI oi;
	public static Logger lg;


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
		lg = new Logger();
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

	//@Override
	public void autonomousInit() {
		/*Command shiftUp = new ShiftUp(),
			armOut = new ArmOpen();

		shiftUp.start();
		armOut.start();*/
	}

	@Override
	public void autonomousPeriodic() {
		teleopPeriodic();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		oi.check();
	}
}
