package stepDefinitions;

import io.cucumber.java.After;
import lombok.AllArgsConstructor;
import utils.TestContextSetup;

@AllArgsConstructor
public class Hooks {

    private TestContextSetup setup;


    @After
    public void afterScenario() {
        setup.getTestBase().webDriverManager().quit();
    }
}
