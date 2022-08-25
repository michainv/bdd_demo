package com.pages.items_page;

import org.openqa.selenium.By;
import utils.CorePage;

public class ItemsListPage extends CorePage {
	
	public static By ITEM_CARD = By.cssSelector("li[class='item product product-item']");
	
	@Override
	public String getPageURL() {
		return this.getEnvironmentalValueFor("items.list.page");
	}
}
