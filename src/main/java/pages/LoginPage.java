package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import static support.Constants.LOGIN_PATH;

public class LoginPage extends BasePage {

    private Locator loginButton() {
        return getButtonByName("Logare");
    }

    private Locator registrationLink() {
        return getLinkByName("Înregistrare");
    }

    public LoginPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void typeEmail(String email) {
        fillField("email", email);
    }

    public void typePassword(String password) {
        fillField("password", password);
    }

    public void clickLoginBtn() {
        waitAndClick(loginButton());
    }

    public void navigateToLoginPage() {
        navigate(LOGIN_PATH);
    }

    public boolean isLoginBtnDisplayed() {
        return loginButton().isVisible();
    }

    public boolean isRegisterLinkDisplayed() {
        return registrationLink().isVisible();
    }
}
