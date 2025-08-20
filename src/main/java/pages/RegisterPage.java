package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import context.RandomUser;
import pages.base.BasePage;

public class RegisterPage extends BasePage {
    public RegisterPage(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator firstNameField = getBrowserManager().getPage().getByTestId("firstname");
    private Locator lastNameField = getBrowserManager().getPage().getByTestId("lastname");

    private Locator emailField = getBrowserManager().getPage().getByTestId("email_address");
    private Locator passwordField = getBrowserManager().getPage().getByTestId("password");
    private Locator confirmPasswordField = getBrowserManager().getPage().getByTestId("password-confirmation");
    private Locator registerButton = getBrowserManager().getPage().locator("button[title='Create an Account']");
    private Locator errorText = getBrowserManager().getPage().locator("#rightPanel");

    public void navigate() {
        navigate("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    public void fillRegistrationForm(RandomUser user) {
        firstNameField.fill(user.firstName());
        lastNameField.fill(user.lastName());
        emailField.fill(user.email());
        passwordField.fill(user.password());
        confirmPasswordField.fill(user.password()); // confirm uses same password
    }

    public void submitRegistration() {
        registerButton.click();
    }

    public String getErrorMessage() {
//        getBrowserManager().getPage().pause();
        return errorText.innerText();
    }
}
