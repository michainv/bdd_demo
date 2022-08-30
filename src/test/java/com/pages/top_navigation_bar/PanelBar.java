package com.pages.top_navigation_bar;

import org.openqa.selenium.By;
import utils.core.CorePage;

public class PanelBar extends CorePage {
	
	public static By SIGN_IN = By.cssSelector("[class='panel header'] [class='header links'] [href*='login']");
	public static By CREATE_ACCOUNT= By.cssSelector("[class='panel header'] [class='header links'] [href*='create']");
	public static By LOGGED_IN = By.cssSelector("[class='panel header'] [class='logged-in']");
	
	@Override
	public String getPageURL() {
		return null;
	}
}
