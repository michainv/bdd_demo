package com.interactions.main.steps;

import com.pages.main.MainPage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.core.CoreSteps;

import java.time.Duration;

public class MainSteps extends CoreSteps {
	
	MainPage mainPage;
	
	@Given("I am on the MainPage, within {int} seconds")
	public void iAmOnTheMainPage(int seconds) {
		this.getDriver().navigate().to(mainPage.getPageURL());
		withTimeoutOf(Duration.ofSeconds(seconds))
				.waitFor(ExpectedConditions.urlMatches(mainPage.getPageURL()));
	}
}
