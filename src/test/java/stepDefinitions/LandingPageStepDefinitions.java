package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class LandingPageStepDefinitions {

    private WebDriver driver;
    private String expectedProductName;
    String actualProductName;

    @Given("User is on GreenKart Landing Page")
    public void user_is_on_green_kart_landing_page() {
        System.setProperty("webdriver.chrome.driver", "D:\\Projects\\driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("User searched with short name {string} and extracted actual name of product")
    public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shotname) {
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shotname);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            Thread.sleep(499);
        } catch (Exception ignored) {

        }
        expectedProductName = driver.findElement(By.className("product-name")).getText().split("-")[0].trim();
    }

    @Then("User searched for same shortname {string} in offers page")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_the_product_exist(String shortname) {
        driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.id("search-field")).sendKeys(shortname);

        actualProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
    }

    @And("Validate product name matches with Landing Page")
    public void validateProductInOffersPage() {
        Assert.assertEquals(actualProductName, expectedProductName, "Product name is not matching");
        driver.quit();
    }
}
