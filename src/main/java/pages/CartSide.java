package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

public class CartSide extends BasePage {
    public CartSide(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator cartButton() { return getByLocator("button btn-cart wc-forward");}
    private Locator checkoutButton() { return getByLocator("button checkout wc-forward");}

    public void goToCart() {
        cartButton().click();
    }
}
