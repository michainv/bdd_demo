package com.interactions.login.actions;

import com.interactions.main.steps.MainSteps;
import com.interactions.navigation.steps.PanelBarSteps;
import com.pages.login.LoginPage;
import com.pages.top_navigation_bar.PanelBar;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.core.CoreSteps;

import java.time.Duration;

public class NavigateToLoginPageAction extends CoreSteps {
	
	MainSteps mainSteps;
	PanelBarSteps panelBarSteps;
	LoginPage loginPage;
	
	@Given("I am on the LoginPage, within {int} seconds")
	public void iAmOnTheLoginPage(int seconds) {
		mainSteps.iAmOnTheMainPage(seconds);
		panelBarSteps.iClickPanelBarButton(PanelBar.SIGN_IN);
		withTimeoutOf(Duration.ofSeconds(seconds))
				.waitFor(ExpectedConditions.urlContains(loginPage.getPageURL()));
	}
	
}
