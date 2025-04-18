package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;


public class CheckoutPageStepDefinition {

    private CheckoutPage checkoutPage;

    public CheckoutPageStepDefinition(TestContextSetup setup) {
        this.checkoutPage = setup.getPageObjectManager().getCheckoutPage();
    }

    @Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
    public void userProceedToCheckoutAndValidate(String item) {
        checkoutPage.checkoutItems();
    }

    @And("Verify user has ability to enter promo code and place the order")
    public void verifyUserHasAbilityToEnterPromoCodeAndPlaceTheOrder() {
        Assert.assertTrue(checkoutPage.verifyPromoButton(), "Promo Button not visible/enable");
        Assert.assertTrue(checkoutPage.verifyPlaceOrder(), "Place Order Button not visible/enable");
        checkoutPage.placeOrder();
    }
}
