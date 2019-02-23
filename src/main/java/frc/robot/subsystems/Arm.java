package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.arm.TiltArm;

public class Arm extends Subsystem implements Constants {
  public static final WPI_TalonSRX tiltMotor = new WPI_TalonSRX(TILT_MOTOR);

  public void tiltArm(double throttle){
    tiltMotor.set(throttle);
  }

 @Override
 public void initDefaultCommand() {
   setDefaultCommand(new TiltArm());
 }
}
