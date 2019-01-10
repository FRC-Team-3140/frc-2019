package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Hardware;
import frc.robot.Constants;

public class Drivetrain extends Subsystem implements Constants, Hardware {

  public Drivetrain() {
    setSlaves();
  }

  public void arcadeDrive(double throttle, double heading) {
    leftDriveMaster.set(throttle + heading);
    rightDriveMaster.set(throttle - heading);
  }

  public void setSlaves() {
    //TODO set slave motors
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
