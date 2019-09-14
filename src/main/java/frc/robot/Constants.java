package frc.robot;

public interface Constants {

    /****
     * SUBSYSTEMS
     */
    // DRIVETRAIN
    // Comments are mechanical markers of the competition bot
    public final int LEFT_DRIVE_MASTER = 3, // 6
    LEFT_DRIVE_SLAVE1 = 5, // 5
    LEFT_DRIVE_SLAVE2 = 4, // 4
    RIGHT_DRIVE_MASTER = 6, // 2
    RIGHT_DRIVE_SLAVE1 = 7, // 3
    RIGHT_DRIVE_SLAVE2 = 8; // 1

    // PNEUMATICS
    // Only shiter, climber, and arm are the correct ports on the competition bot
    public static final int 
        SHIFTER_EXTEND = 2,
        SHIFTER_RETRACT = 5,
        ARM_EXTEND = 0,
        ARM_RETRACT = 3,	
        CLIMBER_EXTEND = 1, 
        CLIMBER_RETRACT = 6,

        FORKLIFT_EXTEND = 1,   
        FORKLIFT_RETRACT = 7;
    public static final int PCM = 1, PCM2 = 2;

    // INTAKE
    public final static int 
        INTAKE_MOTOR = 10,
        TILT_MOTOR = 9;

    // ELEVATOR 
    public final int ELEVATOR_MASTER = 11, // el 1 (right1)
        ELEVATOR_SLAVE = 12; // el 2
    
    /*
     * SENSORS
     */
    // DT ENCODER
    public static final int COUNTS_PER_REV = 42;

    // DRIVETRAIN
    // Note: Drivetrain distance will be measured in anthonies, aka tonies (tn)
    public final double HIGH_GEAR_RATIO = 6.73;
	public final double LOW_GEAR_RATIO = 13.85;
    public final double WHEEL_CIRCUM_TN = 6 * Math.PI;
    
    // ELEVATOR
    // Note: We will use the unit 'johns' (jo) to measure el height
    public final double LOW_HATCH = 0; // TODO these numbers
    public final double MID_HATCH = 0;
    public final double TOP_HATCH = 0;
    public final double LOW_BALL = 0;
    public final double MID_BALL = 0;
    public final double TOP_BALL = 0;
    public final double EL_TOL = 2;

    // ARM
    // Note: We will use the unit 'aidens' (ai) to measure arm position
    public final double ARM_BOT_POS = 0; // TODO this one too
    public final double ARM_TOL_AI = 0;


}
