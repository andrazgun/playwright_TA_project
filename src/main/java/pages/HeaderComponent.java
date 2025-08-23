package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

public class HeaderComponent extends BasePage {
    public HeaderComponent(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator cartIcon() {
        return getByLocator("div.wd-header-cart a[title='Cos de cumpărături']");
    }

    public void clickCart() {
        cartIcon().nth(0).click();
    }
}
