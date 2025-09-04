package pages;

import browser.BrowserManager;
import pages.base.BasePage;

import static support.Constants.PATH_HOW_TO;

public class HowToOrderPage extends BasePage {

    public HowToOrderPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public boolean isAtUrl() {
        return super.isAtUrl(PATH_HOW_TO);
    }
}
