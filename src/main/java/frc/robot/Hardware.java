package frc.robot;

import edu.wpi.first.wpilibj.*;
import frc.robot.lib.joystick.XboxController;

public interface Hardware extends Constants {

    // XBOX
    public static XboxController xbox1 = new XboxController(XBOX_1);

    // DRIVETRAIN
    public static Spark leftDriveMaster = new Spark(LEFT_DRIVE_MASTER);
    public static Spark leftDriveSlave1 = new Spark(LEFT_DRIVE_SLAVE1);
    public static Spark leftDriveSlave2 = new Spark(LEFT_DRIVE_SLAVE2);
    public static Spark rightDriveMaster = new Spark(RIGHT_DRIVE_MASTER);
    public static Spark rightDriveSlave1 = new Spark(RIGHT_DRIVE_SLAVE1);
    public static Spark rightDriveSlave2 = new Spark(RIGHT_DRIVE_SLAVE2);

    // PNEUMATICS
    public static Compressor comp = new Compressor(PCM);
    public static DoubleSolenoid shifter = new DoubleSolenoid(SHIFTER_EXT, SHIFTER_RET);
}