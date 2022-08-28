package com.interactions.steps.items;

import com.pages.items.SingleItemPage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.CoreSteps;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;


public class SingleItemSteps extends CoreSteps {
	
	SingleItemPage singleItemPage;
	
	@Given("I am on SingleItemPage for {string}, within {int} seconds")
	public void iAmOnSingleItemPageFor(String itemName, int seconds) {
		withTimeoutOf(Duration.ofSeconds(5)).waitFor(ExpectedConditions.textToBe(SingleItemPage.ITEM_NAME, itemName));
	}
	
	@Given("Product price on SingleItemPage equals to {string}")
	public void productPriceOnSingleItemPageEqualsTo(String expectedPrice) {
		assertThat(find(SingleItemPage.ITEM_PRICE).getText()).isEqualTo("€" + expectedPrice);
	}
}
