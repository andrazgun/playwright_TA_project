package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;
import session.SessionKeys;

public class LoginPage extends BasePage {

    private final Locator loginButton = getByLocator("button.action.login.primary");

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
        getBrowserManager().getPage().onceDialog(dialog -> {
            String alertText = dialog.message();
            scenarioSession.put(SessionKeys.ALERT_TEXT, alertText);
            dialog.accept();
        });
        Locator loginButton = getBrowserManager().getPage().locator("#login-button");
        waitAndClick(loginButton);
    }

    public void navigate() {
        navigate("https://magento.softwaretestingboard.com/customer/account/login/");
    }

    public boolean isLoginBtnDisplayed() {
        return loginButton.isVisible();
    }
}
