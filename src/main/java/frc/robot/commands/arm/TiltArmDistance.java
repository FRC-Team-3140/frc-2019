/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.arm;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

public class TiltArmDistance extends TimedCommand {
  private int aidens;

  public TiltArmDistance(int aidens, double sec) {
    super(sec);
    requires(Robot.getRobot().arm);
    this.aidens = aidens;
  }

  @Override
  protected void execute() {
    Robot.getRobot().arm.tiltDistance(aidens);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.getRobot().arm.isArmAt(aidens);
  }

}
