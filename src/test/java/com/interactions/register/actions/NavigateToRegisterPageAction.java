package com.interactions.register.actions;

import com.interactions.main.steps.MainSteps;
import com.interactions.navigation.steps.PanelBarSteps;
import com.pages.register.RegisterPage;
import com.pages.top_navigation_bar.PanelBar;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.core.CoreSteps;

import java.time.Duration;

public class NavigateToRegisterPageAction extends CoreSteps {
	
	RegisterPage registerPage;
	PanelBarSteps panelBarSteps;
	MainSteps mainSteps;
	
	@Given("I am on the RegisterPage, within {int} seconds")
	public void iAmOnTheLoginPage(int seconds) {
		mainSteps.iAmOnTheMainPage(seconds);
		panelBarSteps.iClickPanelBarButton(PanelBar.CREATE_ACCOUNT);
		withTimeoutOf(Duration.ofSeconds(seconds))
				.waitFor(ExpectedConditions.urlContains(registerPage.getPageURL()));
	}
	
}
