package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

public class LHNComponent extends BasePage {

    public LHNComponent(BrowserManager browserManager) {
        super(browserManager);
    }

    public void clickProductCategoryByName(String name) {
        Locator productCategoryByText = getByRole("link", name);
        productCategoryByText.click();
    }
}

