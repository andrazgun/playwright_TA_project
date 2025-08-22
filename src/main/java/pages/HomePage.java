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

    public void clickRegisterBtn() {
        getBrowserManager().setPage(getBrowserManager().getContext().waitForPage(() ->
                waitAndClickByRole("link", "CONTACT US Contact Us Form")));

        getBrowserManager().getPage().bringToFront(); //point to new opened tab
    }

    public void clickLoginBtn() {
        getBrowserManager().setPage(getBrowserManager().getContext().waitForPage(() ->
                waitAndClickByRole("link", "LOGIN PORTAL Login Portal")));

        getBrowserManager().getPage().bringToFront(); //point to new opened tab
    }
}
