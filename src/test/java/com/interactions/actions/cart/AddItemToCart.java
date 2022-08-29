package com.interactions.actions.cart;

import com.interactions.steps.items.SingleItemSteps;
import com.interactions.steps.navigation.NavigationSteps;
import com.pages.items.SingleItemPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import utils.core.CoreSteps;


public class AddItemToCart extends CoreSteps {
	
	
	NavigationSteps navigationSteps;
	SingleItemSteps singleItemSteps;
	
	@Given("I add item/items to my cart")
	public void iAddItemNameToCart(DataTable table) {
		table.asLists().subList(1, table.height() - 1).forEach(l -> {
			navigationSteps.iNavigateToProductPageForItem(l.get(0));
			singleItemSteps.iAmOnSingleItemPageFor(l.get(0), 5);
			singleItemSteps.productPriceOnSingleItemPageEqualsTo(l.get(1));
			singleItemSteps.iSelectOptionForFieldInSingleItemPage("size", l.get(2));
			singleItemSteps.iSelectOptionForFieldInSingleItemPage("color", l.get(3));
			singleItemSteps.iTypeQuantityInSingleItemPage(l.get(4), SingleItemPage.ITEM_QUANTITY);
			singleItemSteps.iClickButtonInSingleItemPage(SingleItemPage.ADD_TO_CART);
		});
		
		
	}
}

