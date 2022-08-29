package com.interactions.steps.register;

import com.pages.register.RegisterPage;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.MyElementUtils;
import utils.core.CoreSteps;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegisterSteps extends CoreSteps {
	
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
	public void iAmOnTheLoginPage(int seconds) {
		withTimeoutOf(Duration.ofSeconds(seconds))
				.waitFor(ExpectedConditions.urlContains(registerPage.getPageURL()));
	}
	
	
	@When("I type {string} into RegisterPage {registerPageSelector}")
	public void iTypeIntoLoginPageField(String value, By field) {
		find(field).type(value);
	}
	
	@And("I click RegisterPage {registerPageSelector}")
	public void iClickRegisterPageButton(By button) {
		find(button).click();
	}
	
	
	@And("I see {string} in RegisterPage {registerPageSelector}")
	public void iSeeInRegisterPageMESSAGE(String expectedError, By field) {
		WebElementFacade error = find(field);
		assertThat(error.getText()).isEqualTo(expectedError);
	}
	
	@Then("I see error:{string} for {registerPageSelector} in the RegisterPage")
	public void iSeeErrorForInTheRegisterPage(String expectedError, By field) {
		WebElementFacade error = find(field).then("..").then(RegisterPage.ERROR);
		assertThat(error.getText()).isEqualTo(expectedError);
	}
}
