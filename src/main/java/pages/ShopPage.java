package pages;

import browser.BrowserManager;
import pages.base.BasePage;

import static support.Constants.PATH_SHOP;

public class ShopPage extends BasePage {

    public ShopPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public boolean isAtUrl() {
        return super.isAtUrl(PATH_SHOP);
    }

    public void navigateToShopPage() {
        navigate(PATH_SHOP);
    }
}
