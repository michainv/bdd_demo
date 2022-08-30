package com.steps.calculator;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class Calculator {
	
	double total;
	
	@Given("The calculator is reset")
	public void iResetTheCalculator() {
		System.out.println("Resetting total");
		this.total = 0;
	}
	
	@When("I add {float} to the total")
	public void iAddNumberToTotal(float number) {
		System.out.println("Adding " + number);
		total += number;
	}
	
	
	@When("I add numbers to the total")
	public void iAddTheNumbersToTotal(DataTable table) {
		table.asList().stream()
				.filter(Objects::nonNull)
				.forEach(n -> iAddNumberToTotal(Float.parseFloat(n)));
	}
	
	@Then("The total should be {float}")
	public void totalShouldBe(float expectedTotal) {
		System.out.println(total + " should equal " + expectedTotal);
		assertThat(total).isEqualTo(expectedTotal);
	}
}
