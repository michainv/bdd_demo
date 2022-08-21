package com.pages.account;

import utils.CorePage;

public class MyAccountPage extends CorePage {
	
	@Override
	public String getPageURL() {
		return this.getEnvironmentalValueFor("account.page");
	}
}
