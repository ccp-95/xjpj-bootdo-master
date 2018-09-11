package com.zztlj.xjpj.utils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtil {

	/**
	 * 判断字符串是否为数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("^\\d+(\\.\\d+)?$");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
	
	public static String formatDouble(double d,String formatStr) {
        DecimalFormat df = new DecimalFormat(formatStr);

        
        return df.format(d);
    }
	
	public static void main(String[] args) {
		System.out.println(isNumeric("9"));
		System.out.println(isNumeric("9.9"));
		System.out.println(isNumeric("9.9123123"));
		System.out.println(isNumeric("9,9"));

		System.out.println(isNumeric("啊啊"));

		System.out.println(isNumeric("9.9.9"));
	}
}
