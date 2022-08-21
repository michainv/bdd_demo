package com.interactions.steps.account;

import com.pages.account.MyAccountPage;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllCoreSteps;
import utils.MyElementUtils;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class MyAccountSteps extends AllCoreSteps {
	
	MyAccountPage myAccountPage;
	
	@ParameterType("((.*))")
	public By myAccountPageSelector(String selectorName) {
		return MyElementUtils.getPageElementSelector(selectorName, myAccountPage);
	}
	
	@When("I navigate to MyAccountPage")
	public void iNavigateToLoginPage() {
		this.getDriver().navigate().to( myAccountPage.getPageURL());
	}
	
	@Then("I am on the MyAccountPage, within {int} seconds")
	public void iAmOnMyAccountPage(int seconds) {
		withTimeoutOf(Duration.ofSeconds(seconds))
				.waitFor(ExpectedConditions.urlToBe(myAccountPage.getPageURL()));
	}
	
	
	@And("I see {string} in MyAccountPage {myAccountPageSelector}")
	public void iSeeInMyAccountPageMESSAGE(String message , By field) {
		assertThat(find(field).getText()).isEqualTo(message);
	}
}
