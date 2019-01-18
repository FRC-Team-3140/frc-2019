package frc.robot;

import edu.wpi.first.wpilibj.*;

public interface Hardware {
	public final int PCM = 0;
    // PNEUMATICS
    public Compressor compressor = new Compressor(PCM);

    public static final int SHIFTER_EXT = 4;
	public static final int SHIFTER_RET = 0;
	
	public static final DoubleSolenoid shifter = new DoubleSolenoid(SHIFTER_EXT, SHIFTER_RET);
}