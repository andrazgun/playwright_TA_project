package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import session.ScenarioSession;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginPage_steps {

    private final LoginPage loginPage;
    private final ScenarioSession scenarioSession;

    public LoginPage_steps(LoginPage loginPage, ScenarioSession scenarioSession) {
        this.loginPage = loginPage;
        this.scenarioSession = scenarioSession;
    }

    @Given("I navigate to LoginPage")
    public void iNavigateToLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("I type a user name {string}")
    public void iTypeAUserName(String username) {
        loginPage.typeUsername(username);
    }

    @When("I type a password {string}")
    public void iTypeAPassword(String password) {
        loginPage.typePassword(password);
    }

    @When("I type a user name {string} and a password {string}")
    public void iTypeAUserNameUsernameAndAPasswordPassword(String username, String password) {
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("Login button is displayed")
    public void loginPageIsDisplayed() {
        assertThat(loginPage.isLoginBtnDisplayed()).isTrue();
    }

    @Then("Register link is displayed")
    public void registerButtonIsDisplayed() {
        assertThat(loginPage.isRegisterLinkDisplayed()).isTrue();
    }

    @Then("Error message with text {string} is displayed")
    public void errorMessageWithTextTextIsDisplayed(String expectedText) {
        assertThat(loginPage.getAlertErrorMessage()).as("Wrong error message")
                .containsIgnoringCase(expectedText);
    }

    @When("I log in")
    public void iLogIn() {
        loginPage.logIn();
    }
}
