package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import java.util.List;

public class AccountPage extends BasePage {
    public AccountPage(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator successMessage() {
        return getByLocator(".message-success");
    }

    private Locator navItems() {
//        return getByLocator("nav.woocommerce-MyAccount-navigation ul li");
        return getByLocator("div.wd-my-account-links > div");
    }

    public String getSuccessMessage() {
        return successMessage().innerText();
    }

    public List<String> getNavItemsText() {
        return getLocatorTexts(navItems());
    }

    public void clickNavItemByText(String itemText) {
        Locator navItem = navItems().filter(new Locator.FilterOptions().setHasText(itemText));
        navItem.click();
        waitForStateDetached(navItem);
    }
}
