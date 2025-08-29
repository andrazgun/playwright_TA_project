package pages;

import browser.BrowserManager;
import pages.base.BasePage;

import static support.Constants.PATH_CART;

public class CartPage extends BasePage {

    public CartPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public boolean isAtUrl() {
        return super.isAtUrl(PATH_CART);
    }

    public void navigateToCartPage() {
        navigate(PATH_CART);
    }
}
