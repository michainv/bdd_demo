package com.interactions.steps.items;

import com.pages.items.ItemsListPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.core.CoreSteps;

import java.time.Duration;

public class ItemListSteps extends CoreSteps {
	
	ItemsListPage itemListPage;
	
	@Then("I should be in ItemsPage for {string},{string},{string}, within in {int} seconds")
	public void iShouldInPageFor(String mainCategory, String subCategory, String itemType, int seconds) {
		String myRegex = String.format(itemListPage.getPageURL(), mainCategory + "(.*)", subCategory + "(.*)", itemType);
		withTimeoutOf(Duration.ofSeconds(seconds)).
				waitFor(ExpectedConditions.urlMatches(myRegex));
	}
	
	@Then("I click on the item with order {int} in ItemListPage")
	public void iClickOnTheNthItemInItemListPage(int nth) {
		Actions actions = new Actions(this.getDriver());
		actions.moveToElement(findAll(ItemsListPage.ITEM_CARD).get(nth - 1)).click().perform();
	}
	
	@Then("I click on the item with name {string} in ItemListPage")
	public void iClickOnItemWithNameInItemListPage(String itemName) {
		Actions actions = new Actions(this.getDriver());
		actions.moveToElement(findAll(ItemsListPage.ITEM_CARD)
				.stream()
				.filter(e -> e.then(ItemsListPage.ITEM_NAME).containsOnlyText(itemName))
				.findFirst().orElse(null))
				.click()
				.perform();
	}
	
}
