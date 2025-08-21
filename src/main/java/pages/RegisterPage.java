package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import context.RandomUser;
import dto.CustomerDto;
import mapper.UserMapper;
import pages.base.BasePage;
import session.SessionKeys;

import java.util.Optional;
import java.util.function.Consumer;

public class RegisterPage extends BasePage {
    public RegisterPage(BrowserManager browserManager) {
        super(browserManager);
    }

    private final RandomUser user = RandomUser.createRandom();
    CustomerDto customerDto = UserMapper.toDto(user);

    private final Locator firstNameField = getBrowserManager().getPage().getByTestId("firstname");
    private final Locator lastNameField = getBrowserManager().getPage().getByTestId("lastname");
    private final Locator emailField = getBrowserManager().getPage().getByTestId("email_address");
    private final Locator passwordField = getBrowserManager().getPage().getByTestId("password");
    private final Locator confirmPasswordField = getBrowserManager().getPage().getByTestId("password-confirmation");
    private final Locator registerButton = getBrowserManager().getPage().locator("button[title='Create an Account']");
    private final Locator errorText = getBrowserManager().getPage().locator("#rightPanel");

    public void navigate() {
        navigate("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    public void fillRegistrationForm() {
        scenarioSession.put(SessionKeys.CUSTOMER_DTO, customerDto);

        enterNotNullValue(customerDto.getFirstName(), firstNameField::fill);
        enterNotNullValue(customerDto.getLastName(), lastNameField::fill);
        enterNotNullValue(customerDto.getEmail(), emailField::fill);
        enterNotNullValue(customerDto.getPassword(), passwordField::fill);
        enterNotNullValue(customerDto.getPassword(), confirmPasswordField::fill); // confirm
    }

    private void enterNotNullValue(String field, Consumer<String> consumer) {
        Optional.ofNullable(field).ifPresent(consumer);
    }

    public void submitRegistration() {
        registerButton.click();
    }

    public String getErrorMessage() {
//        getBrowserManager().getPage().pause();
        return errorText.innerText();
    }

    public void registerNewAccount() {
        navigate();
        fillRegistrationForm();
        submitRegistration();
    }
}
