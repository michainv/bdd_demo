package com.interactions.register.actions;

import com.interactions.register.steps.RegisterSteps;
import com.pages.register.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.MyElementUtils;
import utils.core.CoreSteps;

import java.util.Map;

public class FillRegistrationFormAction extends CoreSteps {
	
	RegisterPage registerPage;
	RegisterSteps registerSteps;
	
	@When("I fill the RegistrationForm")
	public void FillRegistrationForm(DataTable datatable) {
		Map<By , String> fieldsMap = MyElementUtils.getHorizontalTableAsElementHashMap(datatable , registerPage);
		fieldsMap.forEach((key, value) -> registerSteps.iTypeIntoRegisterPageField(value, key));
	}
}
