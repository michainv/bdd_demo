package com.interactions.cart.actions;

import com.interactions.cart.steps.MainCartSteps;
import com.pages.cart.MainCart;
import io.cucumber.java.en.Given;
import net.serenitybdd.core.pages.WebElementFacade;
import utils.MyElementUtils;
import utils.core.CoreSteps;

import java.util.List;


public class EmptyCartActionsAction extends CoreSteps {
	
	MainCartSteps mainCartSteps;
	
	@Given("I empty every item in my MainCart")
	public void iEmptyAllMainCartItems(){
		MyElementUtils.waitForPageLoaded(this.getDriver());
		mainCartSteps.iNavigateOnMainCartPage();
		mainCartSteps.iAmOnMainCartPage(5);
		List<WebElementFacade> allProducts = findAll(MainCart.PRODUCT_ROW);
		int maxTries = 15;
		while (allProducts.size() > 0 && maxTries > 0){
			maxTries--;
			allProducts.get(0).then(MainCart.REMOVE_PRODUCT_BUTTON).click();
			allProducts = findAll(MainCart.PRODUCT_ROW);
		}
		mainCartSteps.myMainCartIsEmpty();
	}
	

}
