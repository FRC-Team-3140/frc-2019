package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Hardware;
import frc.robot.commands.elevator.MoveWithJoystick;
import frc.util.DriveHelper;


public final class Elevator extends Subsystem implements Constants {
  private static double deadband = 0.05;

  private double prevError = 0, errorSum = 0, lastTime = 0;

  private double kP = 1;
  private double kI = 0;
  private double kD = 0;

  private CANSparkMax
		elevatorMaster = new CANSparkMax(ELEVATOR_MASTER, CANSparkMaxLowLevel.MotorType.kBrushless),
    elevatorSlave = new CANSparkMax(ELEVATOR_SLAVE, CANSparkMaxLowLevel.MotorType.kBrushless);
    
  private Timer timer = new Timer();

  public Elevator () {
    setSlaves();
  }

  /**********
   * MOVING *
   **********/
  public void elevatorMove(double throttle) {
    if(Math.abs(throttle) < deadband) throttle = 0;
    elevatorMaster.set(throttle);
  }

  public void moveDistancePID(double johns) {
    double error = johns - Hardware.elEncoder.getDistance();
    double t = timer.get();
    double dt = lastTime - t;
    
    errorSum += error * dt;
    double p = kP * error;
    double i = kI * (errorSum);
    double d = kD * (error - prevError)/dt;
    double throttle = p + i + d;
    elevatorMaster.set(throttle);
    
    prevError = error;
    lastTime = t;
  }

  /***************
   * PID SUPPORT *
   ***************/
  public void startPID() {
    timer.start();
  }

  public void endPID() {
    timer.stop();
    timer.reset();
    prevError = 0;
    lastTime = 0;
    errorSum = 0;
  }

  public boolean isElAtDitance(double johns) {
    return Math.abs(Hardware.elEncoder.getDistance() - johns) < EL_TOL;
  }

  /**********
   * CONFIG *
   **********/
  public void setSlaves(){
    elevatorSlave.follow(elevatorMaster);
  }

  public void updateShuffleboard() {
    SmartDashboard.putNumber("El encoder", Hardware.elEncoder.getDistance());

    double newKP = SmartDashboard.getNumber("El kP", kP);
    double newKI = SmartDashboard.getNumber("El kI", kI);
    double newKD = SmartDashboard.getNumber("El kD", kD);
    double band = SmartDashboard.getNumber("Elevator Deadband", deadband);

    if(newKP != kP || newKI != kI || newKD != kD || band != deadband) {
      kP = newKP;
      kI = newKI;
      kD = newKD;
      deadband = band;
    }
  }

  public void check() {
    if(Hardware.isElDown() && Hardware.elSwitchWorking) Hardware.elEncoder.reset();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveWithJoystick());
  }
}
