package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

public class ProductComponent extends BasePage {

    public ProductComponent(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator productItem() {
        return getByLocator("[class='product-item product-details position-relative']");
    }

    public int getProductList() {
        return productItem().count();
    }
}
