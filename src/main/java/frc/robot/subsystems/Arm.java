/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.arm.TiltArm;

/**
 * Add your docs here.
 */
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
