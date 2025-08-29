package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import static support.Constants.PATH_ACCOUNT;

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

    public String getSuccessMessage() {
        return successMessage().innerText();
    }

    public void clickNavItemByText(String itemText) {
        Locator navItem = navItems().filter(new Locator.FilterOptions().setHasText(itemText));
        navItem.click();
        waitForStateDetached(navItem);
    }
}
