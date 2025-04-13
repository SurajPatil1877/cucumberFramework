package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private final WebDriver driver;

    private final By search = By.xpath("//input[@type='search']");
    private final By submit = By.xpath("//button[@type='submit']");
    private final By productName = By.className("product-name");
    private final By topDeals = By.xpath("//a[text()='Top Deals']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String item) {
        driver.findElement(search).sendKeys(item);
        driver.findElement(submit).click();
        try {
            Thread.sleep(499);
        } catch (Exception ignored) {

        }
    }

    public String getLandingPageProductName() {
        return driver.findElement(productName).getText();
    }

    public void clickOnTopDeals() {
        driver.findElement(topDeals).click();
    }
}
