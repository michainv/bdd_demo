package com.interactions.cart.steps;

import com.pages.cart.MainCart;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.MyElementUtils;
import utils.core.CoreSteps;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class MainCartSteps extends CoreSteps {
	
	MainCart mainCart;
	
	
	@ParameterType("((.*))")
	public By mainCartSelector(String selectorName) {
		return MyElementUtils.getPageElementSelector(selectorName, mainCart);
	}
	
	@Given("I navigate on the MainCart page")
	public void iNavigateOnMainCartPage() {
		this.getDriver().navigate().to(mainCart.getPageURL());
	}
	
	@Given("I am on the MainCart page,with in seconds")
	public void iAmOnMainCartPage(int seconds) {
		withTimeoutOf(Duration.ofSeconds(5)).waitFor(ExpectedConditions.urlToBe(mainCart.getPageURL()));
	}
	
	@Given("My MainCart is empty")
	public void myMainCartIsEmpty() {
		assertThat(findAll(MainCart.PRODUCT_ROW)).isEmpty();
	}
	
	@Then("I should see item with {mainCartSelector} : {string} in MainCart")
	public WebElementFacade iShouldSeeItemRowWitGivenItemNameInMainCart(By field, String value) {
		WebElementFacade productRow = this.findAll(MainCart.PRODUCT_ROW).stream()
				.filter(product -> product.then(field).getText().equals(value))
				.findFirst()
				.orElse(null);
		assert productRow != null;
		return productRow;
	}
	
	@And("I should see {string} with {mainCartSelector} : {string} in MainCart")
	public void iShouldSeeItemWithValueInMainCart(String itemName, By field, String value) {
		WebElementFacade itemRow = iShouldSeeItemRowWitGivenItemNameInMainCart(MainCart.PRODUCT_NAME, itemName);
		WebElementFacade val = itemRow.then(field);
		assertThat(value).satisfiesAnyOf(
				l -> assertThat(val.getText().trim()).isEqualTo(l),
				l -> assertThat(val.getAttribute("value")).isEqualTo(l));
	}
}
