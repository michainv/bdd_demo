import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class MyStepdefs {

	
	int result ;
	
	@Given("I add 2")
	public void iAddANumber(int number){
		result += number;
	}
	
	@Then("The result is {int}")
	public void theResultIs(int expectedResult) {
		assertThat(result).isEqualTo(expectedResult);
	}
	
}
