package com.interactions.navigation.steps;

import com.pages.top_navigation_bar.PanelBar;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.MyElementUtils;
import utils.core.CoreSteps;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class PanelBarSteps extends CoreSteps {
	
	PanelBar panelBar;
	
	@ParameterType("((.*))")
	public By panelBarSelector(String selectorName) {
		return MyElementUtils.getPageElementSelector(selectorName, panelBar);
	}
	
	@When("I click PanelBar {panelBarSelector}")
	public void iClickPanelBarButton(By button) {
		find(button).click();
	}
	
	@Then("I {amOrNot} logged in, within {int} seconds")
	public void iAmLoggedIn(boolean expected, int seconds) {
		boolean actual;
		try {
			MyElementUtils.waitForPageLoaded(this.getDriver());
			withTimeoutOf(Duration.ofSeconds(seconds)).waitFor(PanelBar.LOGGED_IN).isDisplayed();
			actual = true;
		} catch (Exception e) {
			actual = false;
		}
		assertThat(actual).isEqualTo(expected);
	}
	

}
