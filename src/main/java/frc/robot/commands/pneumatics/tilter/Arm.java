package frc.robot.commands.pneumatics.tilter;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public final class Arm extends Command {

  private DoubleSolenoid.Value b;

  public Arm(DoubleSolenoid.Value b) {
    requires(Robot.getRobot().pneumatics);
		 this.b = b;
  }

  @Override
  protected void execute() {
    Robot.getRobot().pneumatics.toggleArm(b);
  }

  @Override
  protected boolean isFinished() {
    return true;
  }
}
