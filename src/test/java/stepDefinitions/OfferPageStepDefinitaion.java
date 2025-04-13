package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.OffersPage;
import utils.TestContextSetup;

@AllArgsConstructor
public class OfferPageStepDefinitaion {

    private final TestContextSetup setup;

    @Then("User searched for same shortname {string} in offers page")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_the_product_exist(String item) {
        setup.getPageObjectManager().getLandingPage().clickOnTopDeals();
        OffersPage offersPage = setup.getPageObjectManager().getOffersPage();

        switchToOffersPage();
        offersPage.searchItem(item);
        setup.setActualProductName(offersPage.getProductName());
    }

    @And("Validate product name matches with Landing Page")
    public void validateProductInOffersPage() {
        Assert.assertEquals(setup.getActualProductName(), setup.getLandingPageProductName(), "Product name is not matching");
        setup.getTestBase().webDriverManager().quit();

    }

    private void switchToOffersPage() {
        setup.getGenericUtils().switchToChildWindow();
    }
}
