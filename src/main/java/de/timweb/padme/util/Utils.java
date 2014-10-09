package de.timweb.padme.util;

public class Utils {
	public static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * returns if a number is between (include equals) the given parameters
	 * 
	 * @param min
	 * @param max
	 * @param is
	 * @return
	 */
	public static boolean between(float min, float max, float is) {
		boolean upper = is <= max;
		boolean lower = is >= min;

		return upper && lower;
	}
}
