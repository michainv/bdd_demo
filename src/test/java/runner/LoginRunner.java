package runner;

import io.cucumber.junit.CucumberOptions;
import utils.core.CoreTest;

@CucumberOptions(tags = "@UserLogin")
public class LoginRunner extends CoreTest {
}
