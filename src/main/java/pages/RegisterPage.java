package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import context.RandomUser;
import dto.CustomerDto;
import mapper.UserMapper;
import pages.base.BasePage;
import session.SessionKeys;

import static support.Constants.PATH_REGISTRATION;

public class RegisterPage extends BasePage {
    public RegisterPage(BrowserManager browserManager) {
        super(browserManager);
    }

    private final RandomUser user = RandomUser.createRandom();
    CustomerDto customerDto = UserMapper.toDto(user);

    private Locator usernameField() {
        return getByTestId("reg_username");
    }

    private Locator emailField() {
        return getByTestId("reg_email");
    }

    private Locator passwordField() {
        return getByTestId("reg_password");
    }

    private Locator registerButton() {
        return getByLocator("button[name='register']");
    }

    private Locator errorText() {
        return getByLocator("#rightPanel");
    }

    private Locator registerBtn() {
        return getByRole("button","Înregistrare");
    }

    private Locator loginLink() {
        return getByRole("link", "Autentificare");

    }

    public void navigateToRegistrationPage() {
        navigate(PATH_REGISTRATION);
    }

    public void fillRegistrationForm() {
        scenarioSession.put(SessionKeys.CUSTOMER_DTO, customerDto);

        fillIfNotNull(customerDto.getUsername(), usernameField());
        fillIfNotNull(customerDto.getEmail(), emailField());
        fillIfNotNull(customerDto.getPassword(), passwordField());
    }

    public void submitRegistration() {
        registerButton().click();
    }

    public String getErrorMessage() {
        return errorText().innerText();
    }

    public void registerNewAccount() {
        navigateToRegistrationPage();
        fillRegistrationForm();
        submitRegistration();
    }

    public boolean registerBtnIsDisplayed() {
        return registerBtn().isVisible();

    }

    public boolean isLoginLinkDisplayed() {
        return loginLink().isVisible();
    }
}
