package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import utils.TestContextSetup;

@AllArgsConstructor
public class LandingPageStepDefinition {

    private TestContextSetup setup;

    @Given("User is on GreenKart Landing Page")
    public void user_is_on_green_kart_landing_page() {
        System.setProperty("webdriver.chrome.driver", "D:\\Projects\\driver\\chromedriver-win64\\chromedriver.exe");
        setup.setDriver(new ChromeDriver());

        setup.getDriver().manage().window().maximize();
        setup.getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("User searched with short name {string} and extracted actual name of product")
    public void user_searched_with_short_name_and_extracted_actual_name_of_product(String item) {
        LandingPage landingPage = setup.getPageObjectManager().getLandingPage();
        landingPage.searchItem(item);
        setup.setLandingPageProductName(landingPage.getLandingPageProductName().split("-")[0].trim());
    }
}
