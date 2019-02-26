package frc.util;

public class EncoderHelper {
	// Converts inches to encoder revolutions.
	// Inches is what you desire to convert. Circum is the circumference of the spindle that is moving
	public static double inchesToRevs(double inches, double circum) {
		return inches / circum;
	}
	
	// Converts inches to # of encoder ticks
	// Inches is what you need to convert. Circum is circumference of spindle. TicksPerRev is native units per
	// revolution of the encoder.
	public static int inchesToEncoderTicks(double inches, double circum, double ticksPerRev) {
		return (int) Math.round(inchesToRevs(inches, circum) * ticksPerRev);
	}
	
	// Converts encoder ticks to revolution #.
	// EncoderTicks is what you desire to convert. TicksPerRev is native units per revolution of the encoder
	public static double encoderTicksToRevs(double encoderTicks, double ticksPerRev) {
		return encoderTicks / ticksPerRev;
	}
	
	public static double encoderTicksToInches(double encoderTicks, double circum, double ticksPerRev) {
		return encoderTicksToRevs(encoderTicks, ticksPerRev) * circum;
    }
    
    public static double revsToInches(double revs, double circum) {
        return revs * circum;
    }
}