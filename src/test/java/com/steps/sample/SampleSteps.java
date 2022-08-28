package com.steps.sample;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleSteps {
	
	@Given("I am on precondition1")
	public void iAmOnPrecondition1(){
		System.out.println("Checking precondition1");
	}
	
	@When("I do action1")
	public void iDoAction1() {
		System.out.println("Performing action1");
	}
	
	@Then("I expect precondition1-result")
	public void iExpectAction1Result() {
		System.out.println("Expecting action1-result");
	}
	
	@Given("I am on precondition2")
	public void iAmOnPrecondition2() {
		System.out.println("Checking precondition2");
	}
	
	@Then("I expect precondition2-result")
	public void iExpectAction4() {
		System.out.println("Expecting action2-result");
	}
}
