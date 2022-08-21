package com.pages.register;

import org.openqa.selenium.By;
import utils.CorePage;

public class RegisterPage extends CorePage {
	
	@Override
	public String getPageURL() {
		return this.getEnvironmentalValueFor("register.page");
	}
	
	public static By FIRST_NAME = By.id("firstname");
	
	public static By LAST_NAME = By.id("lastname");
	
	public static By EMAIL = By.id("email_address");
	
	public static By PASSWORD = By.id("password");
	
	public static By CONFIRM_PASSWORD = By.id("password-confirmation");
	
	public static By CREATE_ACCOUNT_BUTTON = By.cssSelector("[type='submit'][class='action submit primary']");
}
