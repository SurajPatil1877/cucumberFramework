package pageObjects;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import utils.GenericUtils;

@AllArgsConstructor
public class PageObjectManager {
    private WebDriver driver;

    public LandingPage getLandingPage() {
        return new LandingPage(driver);
    }

    public OffersPage getOffersPage() {
        return new OffersPage(driver);
    }
}
