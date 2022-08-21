package utils;

import java.util.Locale;

public class MyStringUtils {
	
	public static String toPageFieldFormat(String s) {
		return s.replaceAll("(\\W|^_)*", "")
				.toUpperCase(Locale.ROOT);
	}
}
