package utils;

import java.util.Locale;

public class MyStringUtils {
	
	public static String toPageFieldFormat(String s) {
		return s.replaceAll("(\\W|^_)*", "")
				.toUpperCase(Locale.ROOT);
	}
	
	public static boolean areStringsEqualIgnoringCaseAndSpecialCharacters(String s1, String s2) {
		return removeAllSpecialChars(s1).toLowerCase(Locale.ROOT)
				.equals(removeAllSpecialChars(s2).toLowerCase(Locale.ROOT));
	}
	
	public static String removeAllSpecialChars(String str) {
		return str.replaceAll("[\\W]|_", "");
	}
}
