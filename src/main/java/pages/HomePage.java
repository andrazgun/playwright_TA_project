package pages;

import browser.BrowserManager;
import pages.base.BasePage;

import static support.Constants.HOME_PATH;

public class HomePage extends BasePage {
    public HomePage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void navigateToHomePage() {
        navigate(HOME_PATH);
    }

    public void clickLoginBtn() {
        getBrowserManager().setPage(getBrowserManager().getContext().waitForPage(() ->
                clickAndWaitByRole("button", "Logare")));
    }
}
