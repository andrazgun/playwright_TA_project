package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

public class LHNComponent extends BasePage {

    public LHNComponent(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator productCategoryLevelOne() {
        return getByLocator("[id='main-menu'] ul li");
    }

    private Locator productCategoryLevelTwo() {
        return getByLocator("[class='submenu'] li");
    }

    private Locator productCategoryLevelThree() {
        return getByLocator("[class='level-3']");
    }

    public void clickProductCategoryByName(String name) {
        Locator productCategoryByText = getByText(name);
        productCategoryByText.click();
//        TODO fix below steps
        productCategoryLevelTwo().first().click();
        productCategoryLevelThree().first().click();
    }

}

