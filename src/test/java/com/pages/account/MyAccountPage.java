package com.pages.account;

import org.openqa.selenium.By;
import utils.core.CorePage;

public class MyAccountPage extends CorePage {
	
	public static By MESSAGE = By.cssSelector("[data-bind*='messages']");
	
	@Override
	public String getPageURL() {
		return this.getEnvironmentalValueFor("account.page");
	}
}
