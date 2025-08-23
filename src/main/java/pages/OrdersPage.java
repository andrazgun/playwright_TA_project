package pages;

import browser.BrowserManager;
import pages.base.BasePage;

import static support.Constants.ORDERS_PATH;

public class OrdersPage extends BasePage {

    public OrdersPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public boolean isAtUrl() {
        return super.isAtUrl(ORDERS_PATH);
    }
}
