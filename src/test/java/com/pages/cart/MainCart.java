package com.pages.cart;

import org.openqa.selenium.By;
import utils.core.CorePage;

public class MainCart extends CorePage {
	
	public static By PRODUCT_ROW = By.cssSelector("[class='cart item']");
	public static By PRODUCT_NAME = By.cssSelector("[class='product-item-name']");
	public static By PRODUCT_SIZE = By.cssSelector("[class='item-options'] dd:nth-of-type(1)");
	public static By PRODUCT_COLOR = By.cssSelector("[class='item-options'] dd:nth-of-type(2)");
	public static By PRODUCT_PRICE = By.cssSelector("[class='cart-price']");
	public static By PRODUCT_QUANTITY = By.cssSelector("[title='Qty']");
	public static By PRODUCT_SUBTOTAL = By.cssSelector("[data-th='Subtotal'] [class='price']");
	public static By REMOVE_PRODUCT_BUTTON = By.cssSelector("[class='action action-delete']");
	
	@Override
	public String getPageURL() {
		return this.getEnvironmentalValueFor("main.cart.page");
	}
}
