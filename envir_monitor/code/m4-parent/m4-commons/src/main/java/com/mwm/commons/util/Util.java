package com.mwm.commons.util;


public class Util {
	
	/**
	 * 产生一个的随机整数
	 */
	public static int createRadomNum(int max, boolean hasZero) {
		if (hasZero) {
			int s = new Double(max * Math.random()).intValue();
			return s;
		} else {
			int s = new Double(max * Math.random()).intValue();
			return s == 0 ? 1 : s;
		}
	}
	/**
	 * 产生随机字符串
	 * @param length
	 * @param isMin
	 * @param number
	 * @return
	 */
	public static String createRadomStrs(int length, Boolean isMin,boolean number) {
		char[] result = new char[length];
		int m = 0;
		for (; m < length;) {
			int by = createRadomNum(256, true);
			if (number) {
				if (isMin == null) {
					if ((by >= 48 && by <= 57)) {
						result[m] = (char) by;
						m++;
					}
				} else if (isMin) {
					if ((by >= 48 && by <= 57)) {
						result[m] = (char) by;
						m++;
					}
				} else {
					if ((by >= 48 && by <= 57)) {
						result[m] = (char) by;
						m++;
					}
				}
			} else {
				if (isMin) {
					if ((by >= 97 && by <= 122) || (by >= 65 && by <= 90)) {
						result[m] = (char) by;
						m++;
					}
				} else if (isMin) {
					if (by >= 97 && by <= 122) {
						result[m] = (char) by;
						m++;
					}
				} else {
					if ((by >= 65 && by <= 90)) {
						result[m] = (char) by;
						m++;
					}
				}

			}
		}
		return String.copyValueOf(result);
	}
}
