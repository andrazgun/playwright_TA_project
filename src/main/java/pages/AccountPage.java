package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

public class AccountPage extends BasePage {
    public AccountPage(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator successMessage = getBrowserManager().getPage().locator(".message-success");

    public String getSuccessMessage() {
//        getBrowserManager().getPage().pause();
        return successMessage.innerText();
    }
}
