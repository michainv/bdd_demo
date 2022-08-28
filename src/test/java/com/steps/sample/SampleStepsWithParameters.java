package com.steps.sample;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleStepsWithParameters {
	
	@Given ("I have done precondition : {word}")
	public void iHaveDonePrecondition(String precondition){
		System.out.println("Precondition " + precondition + " is met");
	}
	
	@When("I perform action : {word}")
	public void iPerformAction(String action){
		System.out.println("Performing action : " + action);
	}
	
	@Then("I should see result : {word}")
	public void iShouldSeeResult(String result){
		System.out.println("I should see " + result);
	}
}
