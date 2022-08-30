package com.interactions.navigation.steps;

import com.pages.items.SingleItemPage;
import io.cucumber.java.en.Given;
import utils.core.CoreSteps;

public class NavigationSteps extends CoreSteps {
	
	
	SingleItemPage singleItemPage;
	
	@Given("I Navigate to the product page for item:{string}")
	public void iNavigateToProductPageForItem(String itemName) {
		this.getDriver().navigate().to(singleItemPage.getPageURL(itemName));
	}
	
}
