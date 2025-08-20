package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import context.RandomUser;
import pages.base.BasePage;

public class RegisterPage extends BasePage {
    public RegisterPage(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator firstNameField = getBrowserManager().getPage().getByTestId("customer.firstName");
    private Locator lastNameField = getBrowserManager().getPage().getByTestId("customer.lastName");

    private Locator addressField        = getBrowserManager().getPage().getByTestId("customer.address.street");
    private Locator cityField           = getBrowserManager().getPage().getByTestId("customer.address.city");
    private Locator stateField          = getBrowserManager().getPage().getByTestId("customer.address.state");
    private Locator zipCodeField        = getBrowserManager().getPage().getByTestId("customer.address.zipCode");
    private Locator phoneNumberField    = getBrowserManager().getPage().getByTestId("customer.phoneNumber");
    private Locator ssnField            = getBrowserManager().getPage().getByTestId("customer.ssn");
    private Locator usernameField       = getBrowserManager().getPage().getByTestId("customer.username");
    private Locator passwordField       = getBrowserManager().getPage().getByTestId("customer.password");
    private Locator confirmPasswordField= getBrowserManager().getPage().getByTestId("repeatedPassword");


    private Locator errorText = getBrowserManager().getPage().locator("#rightPanel");

    private Locator registerButton() { return getBrowserManager().getPage().locator("input[type='submit'][value='Register']"); }

    public void navigate() {
        navigate("https://parabank.parasoft.com/parabank/register.htm");
    }

    public void fillRegistrationForm(RandomUser user) {
        firstNameField.fill(user.firstName());
        lastNameField.fill(user.lastName());
        addressField.fill(user.address());
        cityField.fill(user.city());
        stateField.fill(user.state());
        zipCodeField.fill(user.zipCode());
        phoneNumberField.fill(user.phoneNumber());
        ssnField.fill(user.ssn());
        usernameField.fill(user.username());
        passwordField.fill(user.password());
        confirmPasswordField.fill(user.password()); // confirm uses same password
    }

    public void submitRegistration() { registerButton().click(); }

    public String getErrorMessage() {
//        getBrowserManager().getPage().pause();
        return errorText.innerText();
    }
}
