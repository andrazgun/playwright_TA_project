package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.AccountPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountPage_steps {

    private final AccountPage accountPage;

    public AccountPage_steps(AccountPage accountPage) {
        this.accountPage = accountPage;
    }

    @When("I click {string} from LHN")
    public void clickNavItem(String itemText) {
        accountPage.clickNavItemByText(itemText);
    }

    @Then("Message {string} is displayed on AccountPage")
    public void messageIsDisplayed(String message) {
        String actualMessage = accountPage.getSuccessMessageText();
        Assertions.assertThat(actualMessage).contains(message);
    }

    @When("AccountPage is displayed")
    public void accountPageIsDisplayed() {
        assertThat(accountPage.isAtUrl()).as("Wrong URL").isTrue();
    }
}

