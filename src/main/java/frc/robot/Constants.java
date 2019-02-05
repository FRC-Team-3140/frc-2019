package frc.robot;

public interface Constants {
    /*
     * SUBSYSTEMS
     */
     // DRIVETRAIN
     // the following comments are the mechanical markers
	public final int LEFT_DRIVE_MASTER = 2, // 6
        LEFT_DRIVE_SLAVE1 = 3, // 5
        LEFT_DRIVE_SLAVE2 = 4, // 4
        RIGHT_DRIVE_MASTER = 5, // 3
        RIGHT_DRIVE_SLAVE1 = 6, // 2
        RIGHT_DRIVE_SLAVE2 = 7; // 1

    // PNEUMATICS
    public static final int SHIFTER_EXTEND = 0;
	public static final int SHIFTER_RETRACT = 7;
	public static final int PCM = 1; // Pneumatics control module

    
    /*
     * SENSORS
     */
    // ENCODER
    public static final int COUNTS_PER_REV = 42;

    // DRIVETRAIN
    public final double HIGH_GEAR_RATIO = 6.73;
	public final double LOW_GEAR_RATIO = 13.85;
	public final double WHEEL_CIRCUM_IN = 6 * Math.PI;

}
