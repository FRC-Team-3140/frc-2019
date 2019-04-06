package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Hardware;
import frc.robot.Robot;
import frc.robot.commands.elevator.MoveWithJoystick;

public final class Elevator extends Subsystem implements Constants {
  private static double deadband = 0.08;

  private double kP = 1;
  private double kI = 0;
  private double kD = 0;

  private CANSparkMax
	elevatorMaster = new CANSparkMax(ELEVATOR_MASTER, CANSparkMaxLowLevel.MotorType.kBrushless),
	elevatorSlave = new CANSparkMax(ELEVATOR_SLAVE, CANSparkMaxLowLevel.MotorType.kBrushless);

  private CANEncoder elEncoder = elevatorMaster.getEncoder();
  private CANPIDController elPIDController = elevatorMaster.getPIDController();
  private Timer timer = new Timer();

  public Elevator () {
	setSlaves();
	setNeutralMode(IdleMode.kBrake);
  }

 /**********
   * MOVING *
   **********/
  public void elevatorMove(double throttle) {
	  if(!Robot.getRobot().oi.getXboxController2().y.get())
	  	if(Hardware.isElDown() && throttle < 0) throttle = 0;
 
	  if(Math.abs(throttle) < deadband) throttle = 0;
	  elevatorMaster.set(throttle);
   }
 
   public void moveDistancePID(double johns) {
	   elPIDController.setReference(johns, ControlType.kPosition);
   }
 
   /***************
	* PID SUPPORT *
	***************/
   public void configPID() {
	 elPIDController.setP(kP);
	 elPIDController.setI(kI);
	 elPIDController.setD(kD);
   }
 
   public boolean isElAtDitance(double johns) {
	 return Math.abs(getPosition() - johns) < EL_TOL;
   }
 
   public double getPosition() {
	 return elEncoder.getPosition();
   }
 
   /**********
	* CONFIG *
	**********/
   public void setSlaves(){
	 elevatorSlave.follow(elevatorMaster);
   }
 
   public void setNeutralMode(IdleMode mode) {
	 elevatorMaster.setIdleMode(mode);
	 elevatorSlave.setIdleMode(mode);
   }
 
   public void updateShuffleboard() {
	 SmartDashboard.putNumber("El encoder", getPosition());
 
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
	   //if(Hardware.isElDown()) 
   }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveWithJoystick());
  }
}
