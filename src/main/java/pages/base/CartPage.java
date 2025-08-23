package pages.base;

import browser.BrowserManager;

import static support.Constants.CART_PATH;

public class CartPage extends BasePage{

    public CartPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public boolean isAtUrl() {
        return super.isAtUrl(CART_PATH);
    }

    public void navigateToCartPage() {
        navigate(CART_PATH);
    }
}
