package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import context.RandomUser;
import dto.CustomerDto;
import mapper.UserMapper;
import pages.base.BasePage;
import session.SessionKeys;

public class RegisterPage extends BasePage {
    public RegisterPage(BrowserManager browserManager) {
        super(browserManager);
    }

    private final RandomUser user = RandomUser.createRandom();
    CustomerDto customerDto = UserMapper.toDto(user);

    private Locator firstNameField() { return getByTestId("firstname"); }
    private Locator lastNameField() { return getByTestId("lastname"); }
    private Locator emailField() { return getByTestId("email_address"); }
    private Locator passwordField() { return getByTestId("password"); }
    private Locator confirmPasswordField() { return getByTestId("password-confirmation");}
    private Locator registerButton(){ return getByLocator("button[title='Create an Account']");}
    private Locator errorText() {return getByLocator("#rightPanel");}

    public void navigate() {
        navigate("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    public void fillRegistrationForm() {
        scenarioSession.put(SessionKeys.CUSTOMER_DTO, customerDto);

        fillIfNotNull(customerDto.getFirstName(), firstNameField());
        fillIfNotNull(customerDto.getLastName(), lastNameField());
        fillIfNotNull(customerDto.getEmail(), emailField());
        fillIfNotNull(customerDto.getPassword(), passwordField());
        fillIfNotNull(customerDto.getPassword(), confirmPasswordField());
    }

    public void submitRegistration() {
        registerButton().click();
    }

    public String getErrorMessage() {
        return errorText().innerText();
    }

    public void registerNewAccount() {
        navigate();
        fillRegistrationForm();
        submitRegistration();
    }
}
