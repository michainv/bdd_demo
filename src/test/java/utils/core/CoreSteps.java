package utils.core;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class CoreSteps extends UIInteractionSteps {
	
	@Managed
	WebDriver driver;
	
}
