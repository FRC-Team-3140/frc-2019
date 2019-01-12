package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Config {

    /*************
     * CONSTANTS *
     *************/
    // PNEUMATIC STATES
	public static final DoubleSolenoid.Value EXTEND = Value.kForward;
	public static final DoubleSolenoid.Value RETRACT = Value.kReverse;
	public static final DoubleSolenoid.Value OFF = Value.kOff;

    /*********
     * PORTS *
     *********/
    // XBOX
    public static final int XBOX_1 = 0;

    // DRIVETRAIN
    public static final int LEFT_DRIVE_MASTER = 6,
    	LEFT_DRIVE_SLAVE1 = 1,
    	LEFT_DRIVE_SLAVE2 = 2,
    	RIGHT_DRIVE_MASTER = 3,
    	RIGHT_DRIVE_SLAVE1 = 4,
    	RIGHT_DRIVE_SLAVE2 = 5;

    public static final int SHIFTER_EXT = 1;
    public static final int SHIFTER_RET = 0;
}
