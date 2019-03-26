package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Hardware;
import frc.robot.commands.arm.TiltArm;

public final class Arm extends Subsystem {

	private double kP = 1;
	private double kI = 0;
	private double kD = 0;
	private double deadband = 0.08;

	public static final WPI_TalonSRX tiltMotor = new WPI_TalonSRX(TILT_MOTOR);

	public Arm() {
		configDefaults();
	}

	public void tiltArm(double throttle) {
		if (Math.abs(throttle) < deadband)
			throttle = 0;
		tiltMotor.set(throttle);
	}

	// Future use + TODO: add limit switch checking
	public void tiltDistance(int aidens) {
		// TODO do we need this?
	}

	public boolean isArmAt(int aidens) {
		// TODO do we need this?
		return false;
	}

	// SETTINGS

	public void configPID() {
		// TODO do we need this?
	}

	public void configDefaults() {
		tiltMotor.configFactoryDefault();
		tiltMotor.setInverted(true);
	}

	public void configSensors() {
		// TODO do we need this?
		resetEncoder();
	}

	public void resetEncoder() {
		// TODO do we need this?
	}

	public void check() {

	}

	public void updateShuffleboard() {
		double band = SmartDashboard.getNumber("Intake Deadband", deadband);
		double p = SmartDashboard.getNumber("Arm kP", kP);
		double i = SmartDashboard.getNumber("Arm kI", kI);
		double d = SmartDashboard.getNumber("Arm kD", kD);

		if (band != deadband || p != kP || i != kI || d != kD) {
			deadband = band;
			kP = p;
			kI = i;
			kD = d;
			if (Hardware.armSwitchesWorking)
				configPID();
		}
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new TiltArm());
	}
}
