package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Hardware;
import frc.robot.commands.arm.TiltArm;

public class Arm extends Subsystem implements Constants {

  private double kP = 1,
      kI = 0,
      kD = 0;
  private double deadband = 0.08;

  public static final WPI_TalonSRX tiltMotor = new WPI_TalonSRX(TILT_MOTOR);

  public Arm() {
    configDefaults();
  }

  public void tiltArm(double throttle){
    if(Math.abs(throttle) < deadband) throttle = 0;
    if(Hardware.isArmTop() && throttle > 0) throttle = 0;
    else if(Hardware.isArmBot() && throttle < 0) throttle = 0;

    tiltMotor.set(throttle);
  }

  // Future use + TODO: add limit switch checking
  public void tiltDistance(int aidens) {
    //tiltMotor.set(ControlMode.Position, aidens);
  }

  public boolean isArmAt(int aidens) {
    return false;// Math.abs(aidens - tiltMotor.getSelectedSensorPosition()) < ARM_TOL_AI;
  }

  /*
   * SETTINGS
   */
  public void configPID() {
    /*tiltMotor.config_kP(0, kP);
    tiltMotor.config_kI(0, kI);
    tiltMotor.config_kD(0, kD);
    tiltMotor.selectProfileSlot(0, 0);
    tiltMotor.configAllowableClosedloopError(0, 0, 10);*/
  }

  public void configDefaults() {
    // tiltMotor.configFactoryDefault();
    // future inverts and stuff go here
    tiltMotor.setInverted(true);
  }

  public void configSensors() {
   // tiltMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    resetEncoder();
  }

  public void resetEncoder() {
   // tiltMotor.getSensorCollection().setQuadraturePosition(0, 10);
  }

  public void check() {
    if(Hardware.armSwitchesWorking && Hardware.isArmTop()) {
     // resetEncoder();
    }
  }

  public void updateShuffleboard() {
    double band = SmartDashboard.getNumber("Intake Deadband", deadband);
    double p = SmartDashboard.getNumber("Arm kP", kP);
    double i = SmartDashboard.getNumber("Arm kI", kI);
    double d = SmartDashboard.getNumber("Arm kD", kD);

    if(band != deadband || p != kP || i != kI || d != kD) {
      deadband = band;
      kP = p;
      kI = i;
      kD = d;
     // configPID();
    }

  }

 @Override
 public void initDefaultCommand() {
   setDefaultCommand(new TiltArm());
 }
}
