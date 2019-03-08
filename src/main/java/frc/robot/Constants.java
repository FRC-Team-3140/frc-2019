package frc.robot;

public interface Constants {

	// SUBSYSTEMS

	// DRIVETRAIN
	public static final int LEFT_DRIVE_MASTER = 3; // 6
	public static final int LEFT_DRIVE_SLAVE1 = 4; // 5
	public static final int LEFT_DRIVE_SLAVE2 = 5; // 4
	public static final int RIGHT_DRIVE_MASTER = 6; // 3
	public static final int RIGHT_DRIVE_SLAVE1 = 7; // 2
	public static final int RIGHT_DRIVE_SLAVE2 = 8; // 1

	// PNEUMATICS
	// 0 and 7 are the current ports on chassis bot
	public static final int SHIFTER_EXTEND = 1;
	public static final int SHIFTER_RETRACT = 6;
	public static final int ARM_EXTEND = 1;
	public static final int ARM_RETRACT = 6;
	public static final int CLIMBER_EXTEND = 1;
	public static final int CLIMBER_RETRACT = 6;
	public static final int FORKLIFT_EXTEND = 1;
	public static final int FORKLIFT_RETRACT = 7;
	public static final int PCM = 1;

	// INTAKE
	public static final int INTAKE_MOTOR = 10;
	public static final int TILT_MOTOR = 9;

	// ELEVATOR
	public static final int ELEVATOR_MASTER = 11; // el 1 (right1)
	public static final int ELEVATOR_SLAVE = 12; // el 2

	// SENSORS

	// DT ENCODER
	public static final int COUNTS_PER_REV = 42;

	// DRIVETRAIN
	// Note: Drivetrain distance will be measured in anthonies, aka tonies (tn)
	public static final double HIGH_GEAR_RATIO = 6.73;
	public static final double LOW_GEAR_RATIO = 13.85;
	public static final double WHEEL_CIRCUM_TN = 6 * Math.PI;

	// ELEVATOR
	// Note: We will use the unit 'johns' (jo) to measure el height
	public static final double LOW_HATCH = 0; // TODO these numbers
	public static final double MID_HATCH = 0;
	public static final double TOP_HATCH = 0;
	public static final double LOW_BALL = 0;
	public static final double MID_BALL = 0;
	public static final double TOP_BALL = 0;
	public static final double EL_TOL = 2;

	// ARM
	// Note: We will use the unit 'aidens' (ai) to measure arm position
	public static final double ARM_BOT_POS = 0; // TODO this one too
	public static final double ARM_TOL_AI = 0;
}
