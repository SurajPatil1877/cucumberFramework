package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;


public class LandingPageStepDefinition {

    private final TestContextSetup setup;
    private final LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup setup) {
        this.setup = setup;
        landingPage = this.setup.getPageObjectManager().getLandingPage();
    }

    @Given("User is on GreenKart Landing Page")
    public void user_is_on_green_kart_landing_page() {
        Assert.assertEquals(landingPage.getTitle(), "GreenKart - veg and fruits kart", "Not on landing page");
    }

    @When("^User searched with short name (.+) and extracted actual name of product$")
    public void user_searched_with_short_name_and_extracted_actual_name_of_product(String item) {

        landingPage.searchItem(item);
        setup.setLandingPageProductName(landingPage.getLandingPageProductName().split("-")[0].trim());
    }

    @And("Added {string} items of the selected product to cart")
    public void increaseQuantityOfSelectedItem(String quantity) {
        landingPage.increaseQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
    }

}
