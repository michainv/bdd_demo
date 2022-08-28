package com.pages.top_navigation_bar;

import org.openqa.selenium.By;
import utils.core.CorePage;

public class TopNavigationBar extends CorePage {
	
	public static By CATEGORY = By.cssSelector("[href*='/%s']");
	
	@Override
	public String getPageURL() {
		return null;
	}
	
}
