package com.interactions.steps.LoginSteps;

import com.pages.login.LoginPage;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.AllCoreSteps;
import utils.MyElementUtils;

public class LoginSteps extends AllCoreSteps {

	LoginPage loginPage;
	
	@ParameterType("((.*))")
	public By loginPageSelector(String selectorName) {
		return MyElementUtils.getPageElementSelector(selectorName, loginPage);
	}
	
	@Given("I am on the LoginPage, with {int} seconds")
	public void iAmOnTheLoginPage(int seconds){
		this.getDriver().navigate().to(loginPage.getPageURL());
		System.out.println("alive");
	}
	
	@Given("I say hi")
	public void iSayHi() {
		System.out.println("hi");
	}
	
	@When("I type {string} into LoginPage {loginPageSelector}")
	public void iTypeIntoLoginPageEMAIL(String value , By field) {
		find(field).type(value);
	}
	
	@And("I click LoginPage {loginPageSelector}")
	public void iClickLoginPageSIGN_IN_BUTTON(By button) {
		find(button).click();
	}
}
