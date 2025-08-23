package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import static support.Constants.ORDERS_PATH;

public class OrdersPage extends BasePage {

    public OrdersPage(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator firstProduct() {
        return getByLocator("a.product-image-link");
    }

    public boolean isAtUrl() {
        return super.isAtUrl(ORDERS_PATH);
    }

    public void clickFirstProduct() {
        firstProduct().first().hover();
        firstProduct().first().click();
    }
}
