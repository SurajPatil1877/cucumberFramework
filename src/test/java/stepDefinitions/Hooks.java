package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

@AllArgsConstructor
public class Hooks {

    private TestContextSetup setup;


    @After
    public void afterScenario() {
        setup.getTestBase().webDriverManager().quit();
    }

    @AfterStep
    public void addScreenShot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File screenshotAs = ((TakesScreenshot) setup.getTestBase().webDriverManager()).getScreenshotAs(OutputType.FILE);
            scenario.attach(FileUtils.readFileToByteArray(screenshotAs), "image/png", "image");
        }
    }
}
