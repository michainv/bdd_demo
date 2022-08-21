package com.interactions.steps.register;

import com.pages.register.RegisterPage;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllCoreSteps;
import utils.MyElementUtils;

import java.time.Duration;

public class RegisterSteps extends AllCoreSteps {
	
	RegisterPage registerPage;
	
	@ParameterType("((.*))")
	public By registerPageSelector(String selectorName) {
		return MyElementUtils.getPageElementSelector(selectorName, registerPage);
	}
	
	@When("I navigate to RegisterPage")
	public void iNavigateToRegisterPage() {
		this.getDriver().navigate().to(registerPage.getPageURL());
	}
	
	
	@Given("I am on the RegisterPage, within {int} seconds")
	public void iAmOnTheLoginPage(int seconds){
		withTimeoutOf(Duration.ofSeconds(seconds))
				.waitFor(ExpectedConditions.urlContains(registerPage.getPageURL()));
	}
	
	
	@When("I type {string} into RegisterPage {registerPageSelector}")
	public void iTypeIntoLoginPageField(String value , By field) {
		find(field).type(value);
	}
	
	@And("I click RegisterPage {registerPageSelector}")
	public void iClickRegisterPageButton(By button) {
		find(button).click();
	}
	

}
