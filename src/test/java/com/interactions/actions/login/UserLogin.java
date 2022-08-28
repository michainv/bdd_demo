package com.interactions.actions.login;

import com.interactions.steps.account.MyAccountSteps;
import com.interactions.steps.login.LoginSteps;
import com.pages.login.LoginPage;
import io.cucumber.java.en.Given;
import utils.core.CoreSteps;

public class UserLogin extends CoreSteps {
	
	LoginSteps loginSteps;
	MyAccountSteps myAccountSteps;
	
	@Given("I am logged in with user {string},{string}")
	public void iAmLoggedInWithUser(String email, String password){
		loginSteps.iNavigateToLoginPage();
		loginSteps.iAmOnTheLoginPage(5);
		loginSteps.iTypeValueIntoLoginPageField(email , LoginPage.EMAIL);
		loginSteps.iTypeValueIntoLoginPageField(password , LoginPage.PASSWORD);
		loginSteps.iClickLoginPageButton(LoginPage.SIGN_IN_BUTTON);
		myAccountSteps.iAmOnMyAccountPage(true , 5);
	}
}
