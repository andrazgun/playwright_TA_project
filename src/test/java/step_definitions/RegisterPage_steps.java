package step_definitions;

import context.RandomUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.RegisterPage;
import session.ScenarioSession;

public class RegisterPage_steps {

    private final RegisterPage registerPage;
    private final ScenarioSession scenarioSession;
    private final RandomUser user = RandomUser.createRandom();

    public RegisterPage_steps(RegisterPage registerPage, ScenarioSession scenarioSession) {
        this.registerPage = registerPage;
        this.scenarioSession = scenarioSession;
    }

    @Given("^I navigate to RegisterPage$")
    public void navigateToRegisterPage() {
        registerPage.navigate();
    }

    @When("I fill the registration form")
    public void fillRegistrationForm() {
        registerPage.fillRegistrationForm();
    }

    @When("I click Register button")
    public void iClickOnTheSubmitButton() {
        registerPage.submitRegistration();
    }

    @Then("Message {string} is displayed on LoginPage")
    public void messageIsDisplayed(String message) {
        String actualMessage = registerPage.getErrorMessage();
        Assertions.assertThat(actualMessage).contains(message);
    }

    @Given("I register a new account")
    public void iRegisterANewAccount() {
        registerPage.registerNewAccount();
    }
}

