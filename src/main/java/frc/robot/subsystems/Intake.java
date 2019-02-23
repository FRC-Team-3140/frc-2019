package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

public class Intake extends Subsystem implements Constants {

  public static final WPI_TalonSRX intakeMotor = new WPI_TalonSRX(INTAKE_MOTOR);
  public void spinIn(){
    intakeMotor.set(-1.0);
  }

  public void spinOut(){
    intakeMotor.set(1.0);
  }

  public void spinOff(){
    intakeMotor.set(0.0);
  }

  public void spinWithJoystick(double throttle) {
    
  }

  @Override
  public void initDefaultCommand() {
  }
}
