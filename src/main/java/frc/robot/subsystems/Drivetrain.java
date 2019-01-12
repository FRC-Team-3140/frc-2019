package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.drivetrain.ArcadeDrive;

public final class Drivetrain extends Subsystem {

	private final int LEFT_DRIVE_MASTER = 6,
		LEFT_DRIVE_SLAVE1 = 1,
		LEFT_DRIVE_SLAVE2 = 2,
		RIGHT_DRIVE_MASTER = 3,
    	RIGHT_DRIVE_SLAVE1 = 4,
		RIGHT_DRIVE_SLAVE2 = 5;
		
	private CANSparkMax
		leftDriveMaster = new CANSparkMax(LEFT_DRIVE_MASTER, CANSparkMaxLowLevel.MotorType.kBrushless),
		leftDriveSlave1 = new CANSparkMax(LEFT_DRIVE_SLAVE1, CANSparkMaxLowLevel.MotorType.kBrushless),
		leftDriveSlave2 = new CANSparkMax(LEFT_DRIVE_SLAVE2, CANSparkMaxLowLevel.MotorType.kBrushless),
		rightDriveMaster = new CANSparkMax(RIGHT_DRIVE_MASTER, CANSparkMaxLowLevel.MotorType.kBrushless),
		rightDriveSlave1 = new CANSparkMax(RIGHT_DRIVE_SLAVE1, CANSparkMaxLowLevel.MotorType.kBrushless),
		rightDriveSlave2 = new CANSparkMax(RIGHT_DRIVE_SLAVE2, CANSparkMaxLowLevel.MotorType.kBrushless);
		
	public Drivetrain() {
		setSlaves();
	}

	public void arcadeDrive(double throttle, double heading) {
		leftDriveMaster.set(throttle + heading);
		rightDriveMaster.set(throttle - heading);
	}

	public void setSlaves() {
		leftDriveSlave1.follow(leftDriveMaster);
		leftDriveSlave2.follow(leftDriveMaster);
		rightDriveSlave1.follow(rightDriveMaster);
		rightDriveSlave2.follow(rightDriveMaster);
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
	}
}
