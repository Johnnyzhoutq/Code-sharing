package com.mwm.commons.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 拼音工具类
 * 
 * @author lsf
 */
public class PinYinUtil {
	/**
	 * 将字符串中的中文转化为拼音,其他字符不变
	 * 
	 * @param inputString
	 * @return
	 * @throws BadHanyuPinyinOutputFormatCombination 
	 */
	public static String getPingYin(String inputString) throws BadHanyuPinyinOutputFormatCombination{
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);

		char[] input = inputString.trim().toCharArray();
		String output = "";

		for (int i = 0; i < input.length; i++) {
			if (java.lang.Character.toString(input[i]).matches("[\\u4E00-\\u9FA5]+")) {
				String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
				output += temp[0];
			} else{
				output += java.lang.Character.toString(input[i]);
			}
		}
		return output;
	}

	/**
	 * 获取汉字串拼音首字母，英文字符不变
	 * 
	 * @param chinese
	 *            汉字串
	 * @return 汉语拼音首字母
	 * @throws BadHanyuPinyinOutputFormatCombination 
	 */
	public static String getFirstSpell(String chinese) throws BadHanyuPinyinOutputFormatCombination{
		StringBuffer pybf = new StringBuffer();
		char[] arr = chinese.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 128) {
				String[] temp = PinyinHelper.toHanyuPinyinStringArray(
						arr[i], defaultFormat);
				if (temp != null) {
					pybf.append(temp[0].charAt(0));
				}
			} else {
				pybf.append(arr[i]);
			}
		}
		return pybf.toString().replaceAll("\\W", "").trim();
	}

	/**
	 * 获取汉字串拼音，英文字符不变
	 * 
	 * @param chinese
	 *            汉字串
	 * @return 汉语拼音
	 * @throws BadHanyuPinyinOutputFormatCombination 
	 */
	public static String getFullSpell(String chinese) throws BadHanyuPinyinOutputFormatCombination{
		StringBuffer pybf = new StringBuffer();
		char[] arr = chinese.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 128) {
				pybf.append(PinyinHelper.toHanyuPinyinStringArray(arr[i],
						defaultFormat)[0]);
			} else {
				pybf.append(arr[i]);
			}
		}
		return pybf.toString();
	}
}
