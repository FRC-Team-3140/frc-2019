package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class Superstructure extends Subsystem {

  private Robot robot;

  public Superstructure() {
    robot = Robot.getRobot();
  }
  
  public void updateShuffleboard() {

  }

  @Override
  public void initDefaultCommand() {
  }
}
