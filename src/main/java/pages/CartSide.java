package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

public class CartSide extends BasePage {
    public CartSide(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator cart() { return getByLocator("button btn-cart wc-forward");}
    private Locator checkout() { return getByLocator("button checkout wc-forward");}

    public void goToCart() {
        cart().click();
    }
}
