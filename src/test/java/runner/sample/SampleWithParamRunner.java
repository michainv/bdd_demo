package runner.sample;

import runner.CoreTest;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(tags = "@SampleParam")
public class SampleWithParamRunner extends CoreTest {
}

