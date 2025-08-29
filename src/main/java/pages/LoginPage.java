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
        return getByTestId("auth-next-btn").first();
    }

    private Locator alert() {
        return getByRole("alert");
    }

    private Locator registrationLink() {
        return getByRole("link", "Înregistrare");
    }

    String redirectApiUrl = "https://comenzi.bebetei.ro/users/login/dologin";
    String expectedRedirectJson = "{\"redirect-to\":\"https:\\/\\/comenzi.bebetei.ro\\/dashboard\"}";

    public void typeUsername(String username) {
        usernameField().fill(username);
        logger.info("Type username, {}", username);
    }

    public void typePassword(String password) {
        passwordField().fill(password);
        logger.info("Type password, {}", password);
    }

    public void clickLoginBtn() {
        loginButton().click();
        logger.info("Clicked Login button");
    }

    public void navigateToLoginPage() {
        navigate(PATH_LOGIN);
    }

    public boolean isAtUrl() {
        return super.isAtUrl(PATH_LOGIN);
    }

    public boolean isLoginBtnDisplayed() {
        return loginButton().isVisible();
    }

    public boolean isRegisterLinkDisplayed() {
        return registrationLink().isVisible();
    }

    public String getAlertErrorMessage() {
        return getLocatorInnerText(alert());
    }

    public void logIn() throws Exception {
        navigateToLoginPage();
        typeUsername(LOGIN_EMAIL);
        clickLoginBtn();
        waitForLoaderToDisappear();
        typePassword(LOGIN_PASSWORD);
        clickUntilRedirect(loginButton(), redirectApiUrl, expectedRedirectJson);
        waitForLoaderToDisappear();
        waitForPageLoad();
    }
}
