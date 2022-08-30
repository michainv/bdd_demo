package utils;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.core.CorePage;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
	
	public static By findSelectorWithRegexWord(By field, String word) {
		return By.cssSelector(String.format(field.toString(), word).split("By.*:")[1]);
	}
	
	public static Map<By, String> getHorizontalTableAsElementHashMap(DataTable table, CorePage page) {
		return table.asMaps(String.class, String.class).get(0)
				.entrySet()
				.stream()
				.collect(Collectors.toMap(
						e -> MyElementUtils.getPageElementSelector(e.getKey(), page),
						Map.Entry::getValue
						, (u, v) -> {
							throw new IllegalStateException(String.format("Duplicate key %s", u));
						}
						, LinkedHashMap::new
				));
	}
	
	public static void waitForPageLoaded(WebDriver driver) {
		boolean jQueryDone = false;
		boolean pageLoaded = false;
		int i = 0;
		while ((false == jQueryDone || false == pageLoaded) && i <= 6) {
			i++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				break;
			}
			pageLoaded = ((JavascriptExecutor) driver).executeScript("return document.readyState;").toString()
					.equals("complete");
			jQueryDone = (((JavascriptExecutor) driver)
					.executeScript("return (window.jQuery != null) && (jQuery.active === 0);").toString()
					.equals("true"));
		}
	}
}
