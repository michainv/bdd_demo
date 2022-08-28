package com.interactions.steps.navigation;

import com.pages.top_navigation_bar.TopNavigationBar;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.core.CoreSteps;
import utils.MyElementUtils;


public class TopNavigationBarSteps extends CoreSteps {
	
	TopNavigationBar topNavigationBar;
	
	@ParameterType("((.*))")
	public By topPageSelector(String selectorName) {
		return MyElementUtils.getPageElementSelector(selectorName, topNavigationBar);
	}
	
	@Then("I hover option {string} in TopNavigationBar {topPageSelector}")
	public WebElementFacade iHoverTopNavigationBarOption(String word, By field) {
		Actions actions = new Actions(this.getDriver());
		By selector = MyElementUtils.findSelectorWithRegexWord(field, word);
		WebElementFacade element = findAll(selector).stream().filter(WebElement::isDisplayed).findFirst().orElse(null);
		actions.moveToElement(element).perform();
		return element;
	}
	
	@Then("I click option {string} in TopNavigationBar {topPageSelector}")
	public void iClickTopNavigationBarOption(String word, By field) {
		iHoverTopNavigationBarOption(word, field).click();
	}
}
