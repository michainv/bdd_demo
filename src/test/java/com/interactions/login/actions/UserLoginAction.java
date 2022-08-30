package com.interactions.login.actions;

import com.interactions.login.steps.LoginSteps;
import com.interactions.navigation.steps.PanelBarSteps;
import com.pages.login.LoginPage;
import io.cucumber.java.en.Given;
import utils.core.CoreSteps;

public class UserLoginAction extends CoreSteps {
	
	LoginSteps loginSteps;
	NavigateToLoginPageAction navigateToLoginPage;
	PanelBarSteps panelBarSteps;
	
	@Given("I am logged in with user {string},{string}")
	public void iAmLoggedInWithUser(String email, String password) {
		navigateToLoginPage.iAmOnTheLoginPage(5);
		loginSteps.iTypeValueIntoLoginPageField(email, LoginPage.EMAIL);
		loginSteps.iTypeValueIntoLoginPageField(password, LoginPage.PASSWORD);
		loginSteps.iClickLoginPageButton(LoginPage.SIGN_IN_BUTTON);
		panelBarSteps.iAmLoggedIn(true, 10);
	}
	
	
}
