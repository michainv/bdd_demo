package com.pages.items;

import org.openqa.selenium.By;
import utils.CorePage;

public class SingleItemPage extends CorePage {
	
	public static By ITEM_NAME = By.cssSelector("[data-ui-id='page-title-wrapper']");
	public static By ITEM_PRICE = By.cssSelector("[class='product-info-main'] [data-price-amount][data-price-type='finalPrice']");
	
	@Override
	public String getPageURL() {
		return this.getEnvironmentalValueFor("single.item.page");
	}
}
