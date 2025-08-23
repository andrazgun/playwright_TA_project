package pages;

import browser.BrowserManager;
import pages.base.BasePage;

public class AccountEditPage extends BasePage {

    private static final String ACCOUNT_EDIT_URL =
            "https://magento.softwaretestingboard.com/customer/account/edit/";

    public AccountEditPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public boolean isAtUrl() {
        return super.isAtUrl(ACCOUNT_EDIT_URL);
    }
}
