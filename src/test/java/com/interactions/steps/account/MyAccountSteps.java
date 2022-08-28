package com.interactions.steps.account;

import com.pages.account.MyAccountPage;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.core.CoreSteps;
import utils.MyElementUtils;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class MyAccountSteps extends CoreSteps {
	
	MyAccountPage myAccountPage;
	
	@ParameterType("((.*))")
	public By myAccountPageSelector(String selectorName) {
		return MyElementUtils.getPageElementSelector(selectorName, myAccountPage);
	}
	
	@When("I navigate to MyAccountPage")
	public void iNavigateToLoginPage() {
		this.getDriver().navigate().to(myAccountPage.getPageURL());
	}
	
	@Then("I {amOrNot} on the MyAccountPage, within {int} seconds")
	public void iAmOnMyAccountPage(boolean expected, int seconds) {
		boolean actual;
		try{
			actual = withTimeoutOf(Duration.ofSeconds(seconds))
				.waitFor(ExpectedConditions.urlToBe(myAccountPage.getPageURL()));}
		catch(Exception e){ actual = false;}
		assertThat(expected).isEqualTo(actual);
	}
	
	
	@And("I see {string} in MyAccountPage {myAccountPageSelector}")
	public void iSeeInMyAccountPageMESSAGE(String message, By field) {
		assertThat(find(field).getText()).isEqualTo(message);
	}
}
