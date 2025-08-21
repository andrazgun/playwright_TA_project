package step_definitions;

import io.cucumber.java.en.Then;
import pages.AccountEditPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountEditPage_steps {

    private final AccountEditPage accountEditPage;

    public AccountEditPage_steps(AccountEditPage accountEditPage) {
        this.accountEditPage = accountEditPage;
    }

    @Then("^AccountEditPage is displayed$")
    public void accountEditPageIsDisplayed() {
        assertThat(accountEditPage.isDisplayed()).as("Account Information page is not displayed!").isTrue();
    }
}
