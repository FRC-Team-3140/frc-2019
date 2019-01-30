package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

  private final static int 
    INTAKE_MOTOR = 8,
    TILT_MOTOR = 9;

  public static final WPI_TalonSRX
    intakeMotor = new WPI_TalonSRX(INTAKE_MOTOR),
    tiltMotor = new WPI_TalonSRX(TILT_MOTOR);

  public void spinIn(){
    intakeMotor.set(-1.0);
  }

  public void spinOut(){
    intakeMotor.set(1.0);
  }

  public void spinOff(){
    intakeMotor.set(0.0);
  }

   public void tiltArm(double throttle){
     tiltMotor.set(throttle);
   }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
