package step_definitions;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.AccountPage;

public class AccountPage_steps {

    private final AccountPage accountPage;

    public AccountPage_steps(AccountPage accountPage) {
        this.accountPage = accountPage;
    }

    @Then("Message {string} is displayed on AccountPage")
    public void messageIsDisplayed(String message) {
        String actualMessage = accountPage.getSuccessMessage();
        Assertions.assertThat(actualMessage).contains(message);
    }
}

