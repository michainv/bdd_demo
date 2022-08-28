package com.pages.items;

import org.openqa.selenium.By;
import utils.Keys;
import utils.core.CorePage;

public class SingleItemPage extends CorePage {
	
	public static By ITEM_NAME = By.cssSelector("[data-ui-id='page-title-wrapper']");
	public static By ITEM_PRICE = By.cssSelector("[class='product-info-main'] [data-price-amount][data-price-type='finalPrice']");
	public static By ITEM_OPTION = By.cssSelector("[attribute-code='%s']");
	public static By OPTION_LABEL = By.cssSelector("[aria-label]");
	public static By ITEM_QUANTITY = By.id("qty");
	public static By ADD_TO_CART = By.id("product-addtocart-button");
	
	@Override
	public String getPageURL() {
		return this.getEnvironmentalValueFor("single.item.page");
	}
	
	public String getPageURL(String itemName) {
		return String.format(this.getPageURL(),
				itemName.replaceAll("\\s+","-") + "." + Keys.HTML.getValue());
	}
}
