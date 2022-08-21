package com.interactions.steps.login;

import com.pages.login.LoginPage;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllCoreSteps;
import utils.MyElementUtils;

import java.time.Duration;

public class LoginSteps extends AllCoreSteps {

	LoginPage loginPage;
	
	@ParameterType("((.*))")
	public By loginPageSelector(String selectorName) {
		return MyElementUtils.getPageElementSelector(selectorName, loginPage);
	}
	
	@When("I navigate to LoginPage")
	public void iNavigateToLoginPage() {
		this.getDriver().navigate().to(loginPage.getPageURL());
	}
	
	@Given("I am on the LoginPage, within {int} seconds")
	public void iAmOnTheLoginPage(int seconds){
		withTimeoutOf(Duration.ofSeconds(seconds))
				.waitFor(ExpectedConditions.urlContains(loginPage.getPageURL()));
	}

	@When("I type {string} into LoginPage {loginPageSelector}")
	public void iTypeIntoLoginPageField(String value , By field) {
		find(field).type(value);
	}
	
	@And("I click LoginPage {loginPageSelector}")
	public void iClickLoginPageButton(By button) {
		find(button).click();
	}
}
