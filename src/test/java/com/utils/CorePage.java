package com.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;

public abstract class CorePage extends PageObject {
	
	private EnvironmentVariables environmentVariables;
	
	public String getEnvironmentalValueFor(String key) {
		return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(key);
	}
	
	public abstract String getPageURL();
}