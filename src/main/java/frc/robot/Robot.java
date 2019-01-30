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
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;
import frc.robot.subsystems.Pneumatics;

public final class Robot extends TimedRobot {

	private static Robot robot;

	public Hardware hardware;
	public Drivetrain drivetrain;
	public Pneumatics pneumatics;
	public Elevator elevator;
	public Intake intake;
	public OI oi;

	public static Robot getRobot() {
		return robot;
	}

	@Override
	public void robotInit() {
		robot = this;

		hardware = new Hardware();
		drivetrain = new Drivetrain();
		pneumatics = new Pneumatics();
		elevator = new Elevator();
		intake = new Intake();
		// OI must be at the bottom
		oi = new OI();
	}

	@Override
	public void robotPeriodic() {

	}

	@Override
	public void autonomousInit() {

	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		oi.getXboxController().check();
	}

	@Override
	public void testPeriodic() {

	}
}
