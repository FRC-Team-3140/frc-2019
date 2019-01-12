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
import frc.robot.subsystems.pneumatics.Shifter;

public class Robot extends TimedRobot {

	public static Hardware hardware;
	public static Drivetrain drivetrain;
	public static Shifter shifter;
	public static OI oi;

	@Override
	public void robotInit() {
		hardware = new Hardware();
		drivetrain = new Drivetrain();
		shifter = new Shifter();
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
		Robot.oi.getXboxController().check();
	}

	@Override
	public void testPeriodic() {

	}
}
