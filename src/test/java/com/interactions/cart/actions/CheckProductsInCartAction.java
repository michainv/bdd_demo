package com.interactions.cart.actions;

import com.interactions.cart.steps.MainCartSteps;
import com.pages.cart.MainCart;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import utils.MyElementUtils;
import utils.core.CoreSteps;

public class CheckProductsInCartAction extends CoreSteps {
	
	MainCartSteps mainCartSteps;
	
	@Given("I can see following products added to MainCart")
	public void iAddItemNameToCart(DataTable table) {
		MyElementUtils.waitForPageLoaded(this.getDriver());
		table.asLists().subList(1, table.height()).forEach(l -> {
			mainCartSteps.iShouldSeeItemRowWitGivenItemNameInMainCart(MainCart.PRODUCT_NAME, l.get(0));
			mainCartSteps.iShouldSeeItemWithValueInMainCart(l.get(0), MainCart.PRODUCT_PRICE, l.get(1));
			mainCartSteps.iShouldSeeItemWithValueInMainCart(l.get(0), MainCart.PRODUCT_SIZE, l.get(2));
			mainCartSteps.iShouldSeeItemWithValueInMainCart(l.get(0), MainCart.PRODUCT_COLOR, l.get(3));
			mainCartSteps.iShouldSeeItemWithValueInMainCart(l.get(0), MainCart.PRODUCT_QUANTITY, l.get(4));
			mainCartSteps.iShouldSeeItemWithValueInMainCart(l.get(0), MainCart.PRODUCT_SUBTOTAL, l.get(5));
		});
	}
	

}
