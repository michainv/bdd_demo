package com.interactions.login.steps;

import com.pages.login.LoginPage;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import utils.core.CoreSteps;
import utils.MyElementUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends CoreSteps {
	
	LoginPage loginPage;
	
	@ParameterType("((.*))")
	public By loginPageSelector(String selectorName) {
		return MyElementUtils.getPageElementSelector(selectorName, loginPage);
	}
	
	@When("I navigate to LoginPage")
	public void iNavigateToLoginPage() {
		this.getDriver().navigate().to(loginPage.getPageURL());
	}
	
	
	@When("I type {string} into LoginPage {loginPageSelector}")
	public void iTypeValueIntoLoginPageField(String value, By field) {
 		find(field).type(value);
	}
	
	@And("I click LoginPage {loginPageSelector}")
	public void iClickLoginPageButton(By button) {
		find(button).click();
	}
	
	@Then("I see error alert:{string} in the LoginPage")
	public void iSeeErrorInTheLoginPage(String expectedErrorMessage) {
		WebElementFacade error = find(LoginPage.ERROR_MESSAGE_ALERT);
		assertThat(error.getText()).isEqualTo(expectedErrorMessage);
	}
	
	@Then("I see error:{string} for {loginPageSelector} in the LoginPage")
	public void iSeeErrorForEMAIL_FIELDInTheLoginPageWithinSeconds(String expectedErrorMessage, By field) {
		MyElementUtils.waitForPageLoaded(this.getDriver());
		WebElementFacade error = find(field).then("..").then(LoginPage.FIELD_ERROR);
		assertThat(error.getText()).isEqualTo(expectedErrorMessage);
	}
	

}
