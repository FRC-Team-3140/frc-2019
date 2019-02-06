package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.elevator.MoveWithJoystick;
import frc.util.DriveHelper;


public final class Elevator extends Subsystem implements Constants {
  private static final double THROTTLE_DEADBAND = 0.05;
  private static final double HEADING_DEADBAND = 0.05;

  private CANSparkMax
		elevatorMaster = new CANSparkMax(ELEVATOR_MASTER, CANSparkMaxLowLevel.MotorType.kBrushless),
    elevatorSlave = new CANSparkMax(ELEVATOR_SLAVE, CANSparkMaxLowLevel.MotorType.kBrushless);
    
  private DriveHelper driveHelper = new DriveHelper(7.5, THROTTLE_DEADBAND, HEADING_DEADBAND);

  public Elevator () {
    setSlaves();
  }

  public void elevatorMove(double throttle) {
    elevatorMaster.set(driveHelper.calculateThrottle(throttle));
  }

  public void setSlaves(){
    elevatorSlave.follow(elevatorMaster);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveWithJoystick());
  }
}
