package frc.robot;

import edu.wpi.first.wpilibj.*;

public final class Hardware {
	public final int PCM = 0;
    // PNEUMATICS
    public Compressor compressor = new Compressor(PCM);
}