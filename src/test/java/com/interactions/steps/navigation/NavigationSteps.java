package com.interactions.steps.navigation;

import com.pages.items.SingleItemPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.core.CoreSteps;

public class NavigationSteps extends CoreSteps {
	
	
	SingleItemPage singleItemPage;
	
	@Given("I Navigate to the product page for item:{string}")
	public void iNavigateToProductPageForItem(String itemName){
		this.getDriver().navigate().to(singleItemPage.getPageURL(itemName));
	}
	
	@Then("I am on the product page for item:{string}, within {int} seconds")
	public void iAmOnTheProductPageForItem(String itemName,int seconds){
	
	}
}
