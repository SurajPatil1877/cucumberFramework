package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TestContextSetup;

@AllArgsConstructor
public class LandingPageStepDefinition {

    private TestContextSetup setup;

//    public LandingPageStepDefinition(TestContextSetup setup) {
//        this.setup = setup;
//    }


    @Given("User is on GreenKart Landing Page")
    public void user_is_on_green_kart_landing_page() {
        System.setProperty("webdriver.chrome.driver", "D:\\Projects\\driver\\chromedriver-win64\\chromedriver.exe");
        setup.setDriver(new ChromeDriver());

        setup.getDriver().manage().window().maximize();
        setup.getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("User searched with short name {string} and extracted actual name of product")
    public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shotname) {
        setup.getDriver().findElement(By.xpath("//input[@type='search']")).sendKeys(shotname);
        setup.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        try {
            Thread.sleep(499);
        } catch (Exception ignored) {

        }
        setup.setLandingPageProductName(setup.getDriver().findElement(By.className("product-name")).getText().split("-")[0].trim());
    }
}
