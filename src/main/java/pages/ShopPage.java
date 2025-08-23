package pages;

import browser.BrowserManager;
import pages.base.BasePage;

import static support.Constants.SHOP_PATH;

public class ShopPage extends BasePage {

    public ShopPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public boolean isAtUrl() {
        return super.isAtUrl(SHOP_PATH);
    }

    public void navigateToShopPage() {
        navigate(SHOP_PATH);
    }

}
