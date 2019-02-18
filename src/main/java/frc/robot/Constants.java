package frc.robot;

public interface Constants {

    /****
     * SUBSYSTEMS
     */
    // DRIVETRAIN
    public final int LEFT_DRIVE_MASTER = 2, // 6
    LEFT_DRIVE_SLAVE1 = 3, // 5
    LEFT_DRIVE_SLAVE2 = 4, // 4
    RIGHT_DRIVE_MASTER = 5, // 3
    RIGHT_DRIVE_SLAVE1 = 6, // 2
    RIGHT_DRIVE_SLAVE2 = 7; // 1

    // PNEUMATICS
    // 0 and 7 are the current ports on chassis bot
    public static final int SHIFTER_EXTEND = 1, 
        SHIFTER_RETRACT = 6,
        ARM_EXTEND = 1, 
        ARM_RETRACT = 6,	
	    PUNCHER = 2,
        CLIMBER_EXTEND = 1, 
        CLIMBER_RETRACT = 6,
        FORKLIFT_EXTEND = 1,   
        FORKLIFT_RETRACT = 7;
    public static final int PCM = 1,
        PCM2 = 2; 

    // INTAKE
    public final static int 
        INTAKE_MOTOR = 8,
        TILT_MOTOR = 9;

    // ELEVATOR 
    public final int ELEVATOR_MASTER = 8, // 6
        ELEVATOR_SLAVE = 9;
}
