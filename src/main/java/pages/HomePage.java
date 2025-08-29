package pages;

import browser.BrowserManager;
import pages.base.BasePage;

import static support.Constants.PATH_HOME;

public class HomePage extends BasePage {
    public HomePage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void navigateToHomePage() {
        navigate(PATH_HOME);
    }

    public void clickLoginBtn() {
        getBrowserManager().setPage(getBrowserManager().getContext().waitForPage(() ->
                clickAndWaitByRole("button", "Logare")));
    }
}
