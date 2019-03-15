package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.commands.intake.SpinWithTrigger;

public class Intake extends Subsystem implements Constants {
  private double deadband = 0.08;

  //public static final WPI_TalonSRX intakeMotor = new WPI_TalonSRX(INTAKE_MOTOR);
  
  public void spinIn(){
    //intakeMotor.set(-1.0);
  }

  public void spinOut(){
    //intakeMotor.set(1.0);
  }

  public void spinOff(){
    //intakeMotor.set(0.0);
  }

  public void spinWithTriggers(double forward, double backward) {
    double throttle = 0;
    if(forward > backward) throttle = forward;
    else throttle = -backward;

    if(Math.abs(throttle) < deadband) throttle = 0;
   // intakeMotor.set(throttle);
  }

  public void updateShuffleboard() {
    double band = SmartDashboard.getNumber("Intake Deadband", deadband);

    if(band != deadband) {
      deadband = band;
    }
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new SpinWithTrigger());
  }
}
