package pages.base;

import browser.BrowserManager;

import static support.Constants.PATH_CART;

public class CartPage extends BasePage{

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
