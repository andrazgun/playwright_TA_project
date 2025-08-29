package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import static support.Constants.PATH_ACCOUNT;
import static support.Constants.STATE_DETACHED;

public class AccountPage extends BasePage {
    public AccountPage(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator successMessage() {
        return getByLocator(".message-success");
    }

    private Locator navItems() {
        return getByLocator("div.wd-my-account-links > div");
    }

    public boolean isAtUrl() {
        return super.isAtUrl(PATH_ACCOUNT);
    }

    public String getSuccessMessageText() {
        return getLocatorInnerText(successMessage());
    }

    public void clickNavItemByText(String itemText) {
        Locator navItem = navItems().filter(new Locator.FilterOptions().setHasText(itemText));
        navItem.click();
        waitForLocatorByState(navItem, STATE_DETACHED);
    }
}
