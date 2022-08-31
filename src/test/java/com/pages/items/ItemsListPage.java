package com.pages.items;

import org.openqa.selenium.By;
import utils.core.CorePage;

public class ItemsListPage extends CorePage {
	
	public static By ITEM_CARD = By.cssSelector("li[class='item product product-item']");
	public static By ITEM_NAME = By.cssSelector("[class='product-item-link']");
	
	@Override
	public String getPageURL() {
		return this.getEnvironmentalValueFor("items.list.page");
	}
}
