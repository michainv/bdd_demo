package com.pages.main;

import utils.core.CorePage;

public class MainPage extends CorePage {
	
	@Override
	public String getPageURL() {
		return this.getEnvironmentalValueFor("base.url");
	}
}
