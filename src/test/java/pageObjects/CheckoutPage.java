package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private final WebDriver driver;

    private final By cartBag = By.cssSelector("img[alt='Cart']");
    private final By checkoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
    private final By promoApplyButton = By.cssSelector(".promoBtn");
    private final By placeOrder = By.xpath("//button[text()='Place Order']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }


    public void checkoutItems() {
        driver.findElement(cartBag).click();
        driver.findElement(checkoutButton).click();
    }

    public boolean verifyPromoButton() {
        return driver.findElement(promoApplyButton).isDisplayed();
    }

    public boolean verifyPlaceOrder() {
        return driver.findElement(placeOrder).isDisplayed();
    }

    public void placeOrder(){
        driver.findElement(placeOrder).click();
    }

}
