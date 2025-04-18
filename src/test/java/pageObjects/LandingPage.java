package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private final WebDriver driver;

    private final By search = By.xpath("//input[@type='search']");
    private final By submit = By.xpath("//button[@type='submit']");
    private final By productName = By.className("product-name");
    private final By topDeals = By.xpath("//a[text()='Top Deals']");
    private final By increment = By.xpath("//a[text()='+']");
    private final By addToCart = By.xpath("//button[text()='ADD TO CART']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String item) {
        driver.findElement(search).sendKeys(item);
        driver.findElement(submit).click();
    }

    public String getLandingPageProductName() {
        return driver.findElement(productName).getText();
    }

    public void clickOnTopDeals() {
        driver.findElement(topDeals).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void increaseQuantity(int quantity) {
        for (int i = 1; i < quantity; i++)
            driver.findElement(increment).click();

    }

    public void addToCart() {
        driver.findElement(addToCart).click();
    }
}
