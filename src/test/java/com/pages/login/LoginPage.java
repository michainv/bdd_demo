package com.pages.login;

import org.openqa.selenium.By;
import utils.CorePage;

public class LoginPage extends CorePage {
	
	public static By EMAIL = By.id("email");
	public static By PASSWORD = By.id("pass");
	public static By SIGN_IN_BUTTON = By.cssSelector("[type='submit'][class*='login primary']");
	
	public String getPageURL() {
		return this.getEnvironmentalValueFor("login.page");
	}
}
