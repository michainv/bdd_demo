package com.interactions.parameter_types;

import io.cucumber.java.ParameterType;

public class CommonParameters {
	
	
	@ParameterType("((.*))")
	public Boolean amOrNot(String text) {
		return !text.toLowerCase().contains("not");
	}
}
