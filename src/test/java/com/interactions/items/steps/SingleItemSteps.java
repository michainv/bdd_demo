package com.interactions.items.steps;

import com.pages.items.SingleItemPage;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.MyElementUtils;
import utils.core.CoreSteps;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;


public class SingleItemSteps extends CoreSteps {
	
	SingleItemPage singleItemPage;
	
	@ParameterType("((.*))")
	public By singleItemSelector(String selectorName) {
		return MyElementUtils.getPageElementSelector(selectorName, singleItemPage);
	}
	
	@Given("I am on SingleItemPage for {string}, within {int} seconds")
	public void iAmOnSingleItemPageFor(String itemName, int seconds) {
		withTimeoutOf(Duration.ofSeconds(seconds)).waitFor(ExpectedConditions.textToBe(SingleItemPage.ITEM_NAME, itemName));
	}
	
	@Given("Product price on SingleItemPage equals to {string}")
	public void productPriceOnSingleItemPageEqualsTo(String expectedPrice) {
		assertThat(find(SingleItemPage.ITEM_PRICE).getText()).isEqualTo(expectedPrice);
	}
	
	@Then("I select {string} : {string} in SingleItemPage")
	public void iSelectOptionForFieldInSingleItemPage(String fieldName, String value) {
		By field = MyElementUtils.findSelectorWithRegexWord(SingleItemPage.ITEM_OPTION, fieldName);
		WebElementFacade selection = this.find(field)
				.thenFindAll(SingleItemPage.OPTION_LABEL)
				.stream()
				.filter(opt -> opt.getAttribute("aria-label").equals(value))
				.findFirst()
				.orElse(null);
		assert selection != null;
		selection.click();
	}
	
	@Then("I type {string} in SingleItemPage {singleItemSelector}")
	public void iTypeQuantityInSingleItemPage(String value, By field) {
		find(field).type(value);
	}
	
	@Then("I click {singleItemSelector} in SingleItemPage")
	public void iClickButtonInSingleItemPage(By button){
		find(button).click();
	}
}
