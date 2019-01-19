package frc.robot.commands.pneumatics.climber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public final class Climb extends Command {
  private DoubleSolenoid.Value a;
  public Climb(DoubleSolenoid.Value a) {
    requires(Robot.getRobot().pneumatics);
		 this.a = a;
}

  @Override
  protected void execute() {
    Robot.getRobot().pneumatics.climb(a);
  }

  @Override
  protected boolean isFinished() {
    return true;
  }
}