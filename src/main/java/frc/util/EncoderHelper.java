package frc.util;

public final class EncoderHelper {
	/**
	 * Converts inches to encoder revolutions.
	 * @param inches - what you desire to convert
	 * @param circum - the circumference of the spindle that is moving
	 */
	public static double inchesToRevs(double inches, double circum) {
		return inches / circum;
	}

	/**
	 * Converts inches to number of encoder ticks.
	 * @param inches - what you desire to convert
	 * @param circum - the circumference of the spindle
	 * @param ticksPerRev - native units per revolution of the encoder
	 */
	public static int inchesToEncoderTicks(double inches, double circum, double ticksPerRev) {
		return (int) Math.round(inchesToRevs(inches, circum) * ticksPerRev);
	}

	/**
	 * Converts encoder ticks to revolution number.
	 * @param encoderTicks - what you desire to convert
	 * @param TicksPerRev - native units per revolution of the encoder
	 */
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