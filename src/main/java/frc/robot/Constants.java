package frc.robot;

public interface Constants {
    /****
     * SUBSYSTEMS
     */
    // DRIVETRAIN
    public final int LEFT_DRIVE_MASTER = 3, // 6
    LEFT_DRIVE_SLAVE1 = 4, // 5
    LEFT_DRIVE_SLAVE2 = 5, // 4
    RIGHT_DRIVE_MASTER = 6, // 3
    RIGHT_DRIVE_SLAVE1 = 7, // 2
    RIGHT_DRIVE_SLAVE2 = 8; // 1

    // PNEUMATICS
    // 0 and 7 are the current ports on chassis bot
    public static final int 
        SHIFTER_EXTEND = 1, 
        SHIFTER_RETRACT = 6,
        ARM_EXTEND = 1, 
        ARM_RETRACT = 6,	
        CLIMBER_EXTEND = 1, 
        CLIMBER_RETRACT = 6,
        FORKLIFT_EXTEND = 1,   
        FORKLIFT_RETRACT = 7;
    public static final int PCM = 1; 

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
    // ENCODER
    public static final int COUNTS_PER_REV = 42;

    // DRIVETRAIN
    public final double HIGH_GEAR_RATIO = 6.73;
	public final double LOW_GEAR_RATIO = 13.85;
    public final double WHEEL_CIRCUM_IN = 6 * Math.PI;
    
    // ELEVATOR
    // Note: We will use the unit 'johns' to measure el height
    public final double LOW_HATCH = 0; // TODO these numbers
    public final double MID_HATCH = 0;
    public final double TOP_HATCH = 0;
    public final double LOW_BALL = 0;
    public final double MID_BALL = 0;
    public final double TOP_BALL = 0;


}
