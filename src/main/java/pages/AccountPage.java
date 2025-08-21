package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import java.util.List;

public class AccountPage extends BasePage {
    public AccountPage(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator successMessage = getBrowserManager().getPage().locator(".message-success");
//    private List<Locator> navItems = getBrowserManager().getPage().locator("li.nav.item a");

    public String getSuccessMessage() {
//        getBrowserManager().getPage().pause();
        return successMessage.innerText();
    }

    public List<String> getNavItemsText() {
        return getLocatorTexts(navItems());
    }

    public void clickNavItemByText(String itemText) {
        navItems().filter(new Locator.FilterOptions().setHasText(itemText)).click();
    }

    private Locator navItems() {
        return getBrowserManager().getPage().locator("li.nav.item a");
    }
}
