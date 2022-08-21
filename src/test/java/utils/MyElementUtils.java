package utils;

import org.openqa.selenium.By;

import java.lang.reflect.Field;

public class MyElementUtils {
	
	public static By getPageElementSelector(String selectorName, CorePage page) {
		Field field;
		try {
			field = page.getClass().getDeclaredField(MyStringUtils.toPageFieldFormat(selectorName));
			field.setAccessible(true);
			return (By) field.get(page);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
