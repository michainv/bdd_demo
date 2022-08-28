package com.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleSteps extends utils.CoreSteps {
	
	@Given("I am on precondition1")
	public void iAmOnPrecondition1(){
		System.out.println("Checking precondition1");
	}
	
	@When("I do action1")
	public void iDoAction1() {
		System.out.println("Performing action1");
	}
	
	@Then("I expect action1-result")
	public void iExpectAction1Result() {
		System.out.println("Expecting action1-result");
	}
	
	@Given("I am on precondition2")
	public void iAmOnPrecondition2() {
		System.out.println("Checking precondition2");
	}
	
	@When("I do action2")
	public void iDoAction2() {
		System.out.println("Performing action2");
	}
	
	@Then("I expect action2-result")
	public void iExpectAction4() {
		System.out.println("Expecting action2-result");
	}
}
