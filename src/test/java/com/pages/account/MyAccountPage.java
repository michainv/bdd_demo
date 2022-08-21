package com.pages.account;

import org.openqa.selenium.By;
import utils.CorePage;

public class MyAccountPage extends CorePage {
	
	@Override
	public String getPageURL() {
		return this.getEnvironmentalValueFor("account.page");
	}
	
	public static By MESSAGE = By.cssSelector("[data-bind*='messages']");
}
