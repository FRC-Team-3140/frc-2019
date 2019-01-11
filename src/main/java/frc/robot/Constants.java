package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public interface Constants {

    /*************
     * CONSTANTS *
     *************/
    // PNEUMATIC STATES
	public final DoubleSolenoid.Value EXT = Value.kForward;
	public final DoubleSolenoid.Value RET = Value.kReverse;
	public final DoubleSolenoid.Value OFF = Value.kOff;

    /*********
     * PORTS *
     *********/
    // XBOX
    public final int XBOX_1 = 0;

    // DRIVETRAIN
    public final int LEFT_DRIVE_MASTER = 6;
    public final int LEFT_DRIVE_SLAVE1 = 1;
    public final int LEFT_DRIVE_SLAVE2 = 2;
    public final int RIGHT_DRIVE_MASTER = 3;
    public final int RIGHT_DRIVE_SLAVE1 = 4;
    public final int RIGHT_DRIVE_SLAVE2 = 5;

    public final int SHIFTER_EXT = 1;
    public final int SHIFTER_RET = 0;

    // PCM
    public final int PCM = 0;

    


}
