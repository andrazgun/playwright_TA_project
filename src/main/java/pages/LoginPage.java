package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import static support.Constants.*;

public class LoginPage extends BasePage {

    private Locator usernameField() {
        return getByTestId("username");
    }

    private Locator passwordField() {
        return getByTestId("password");
    }

    private Locator loginButton() {
        return getByRole("button", "Logare");
    }

    private Locator registrationLink() {
        return getByRole("link", "Înregistrare");
    }

    public LoginPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void typeUsername(String username) {
        usernameField().fill(username);
    }

    public void typePassword(String password) {
        passwordField().fill(password);
    }

    public void clickLoginBtn() {
        loginButton().click();
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

    public String getErrorMessage() {
        return getAlertText();
    }

    public void logIn() {
        typeUsername(LOGIN_EMAIL);
        typePassword(LOGIN_PASSWORD);
        clickLoginBtn();
    }
}
