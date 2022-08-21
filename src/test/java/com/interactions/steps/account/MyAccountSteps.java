package com.interactions.steps.account;

import com.pages.account.MyAccountPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllCoreSteps;

import java.time.Duration;

public class MyAccountSteps extends AllCoreSteps {
	
	MyAccountPage myAccountPage;
	
	@Then("I am on the MyAccountPage, with {int} seconds")
	public void iAmOnMyAccountPage(int seconds) {
		withTimeoutOf(Duration.ofSeconds(seconds))
				.waitFor(ExpectedConditions.urlToBe(myAccountPage.getPageURL()));
		System.out.println("ok");
	}
}
