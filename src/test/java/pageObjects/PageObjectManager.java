package pageObjects;

import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;


public class PageObjectManager {
    private final WebDriver driver;
    private final Supplier<LandingPage> landingPageSupplier;
    private final Supplier<OffersPage> offersPageSupplier;
    private final Supplier<CheckoutPage> checkoutPageSupplier;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;

        landingPageSupplier = lazyInit(() -> new LandingPage(this.driver));
        offersPageSupplier = lazyInit(() -> new OffersPage(this.driver));
        checkoutPageSupplier = lazyInit(() -> new CheckoutPage(this.driver));
    }

    public LandingPage getLandingPage() {
        return landingPageSupplier.get();
    }

    public OffersPage getOffersPage() {
        return offersPageSupplier.get();
    }

    public CheckoutPage getCheckoutPage() {
        return checkoutPageSupplier.get();
    }

    private static <T> Supplier<T> lazyInit(Supplier<T> supplier) {
        return new Supplier<>() {
            private T instance;

            @Override
            public synchronized T get() {
                if (instance == null) {
                    instance = supplier.get();
                }
                return instance;
            }
        };
    }
}
