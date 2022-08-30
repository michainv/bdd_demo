package com.interactions.z_parameter_types;

import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import org.apache.commons.lang.StringUtils;

import java.util.Objects;

public class CommonParameters {
	
	@DataTableType
	public String nullToString(String cell) {
		return Objects.isNull(cell) ? StringUtils.EMPTY : cell;
	}
	
	@ParameterType("((.*))")
	public Boolean amOrNot(String text) {
		return !text.toLowerCase().contains("not");
	}
}
