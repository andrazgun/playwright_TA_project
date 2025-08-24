package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import static support.Constants.*;

public class LoginPage extends BasePage {

    public LoginPage(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator usernameField() {
        return getByTestId("auth-email");
    }

    private Locator passwordField() {
        return getByTestId("auth-login-password");
    }

    private Locator loginButton() {
        return getByTestId("auth-next-btn");
    }

    private Locator alert() {
        return getByRole("alert");
    }

    private Locator registrationLink() {
        return getByRole("link", "Înregistrare");
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

    public String getAlertErrorMessage() {
        return getLocatorText(alert());
    }

    public void logIn() {
        navigateToLoginPage();
        typeUsername(LOGIN_EMAIL);
        clickLoginBtn();
        typePassword(LOGIN_PASSWORD);
        clickLoginBtn();
    }
}
