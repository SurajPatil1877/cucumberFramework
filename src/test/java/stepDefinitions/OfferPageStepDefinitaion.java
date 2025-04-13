package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.AllArgsConstructor;
import org.testng.Assert;
import pageObjects.OffersPage;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

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
        setup.getDriver().quit();
    }

    private void switchToOffersPage() {
        Set<String> windowHandles = setup.getDriver().getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        setup.getDriver().switchTo().window(childWindow);
    }
}
