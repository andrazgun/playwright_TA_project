package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import session.ScenarioSession;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.Constants.LOGIN_EMAIL;
import static support.Constants.LOGIN_PASSWORD;

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

    @When("the customer types a user name {string}")
    public void typeAUserName(String username) {
        loginPage.typeUsername(username);
    }

    @When("the customer types a password {string}")
    public void typeAPassword(String password) {
        loginPage.typePassword(password);
    }

    @When("the customer types valid username and password")
    public void typeValidUsernameAndPassword() {
        loginPage.typeUsername(LOGIN_EMAIL);
        loginPage.clickLoginBtn();
        loginPage.typePassword(LOGIN_PASSWORD);
    }

    @When("I type a user name {string} and a password {string}")
    public void iTypeAUserNameUsernameAndAPasswordPassword(String username, String password) {
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
    }

    @And("the customer clicks login button")
    public void clicksOnLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("Login button is displayed")
    public void loginButtonIsDisplayed() {
        assertThat(loginPage.isLoginBtnDisplayed()).isTrue();
    }

    @Then("Register link is displayed")
    public void registerButtonIsDisplayed() {
        assertThat(loginPage.isRegisterLinkDisplayed()).isTrue();
    }

    @Then("LoginPage is displayed")
    public void loginPageIsDisplayed() {
        assertThat(loginPage.isAtUrl()).as("Wrong URL").isTrue();
    }

    @Then("Error message with text {string} is displayed")
    public void errorMessageWithTextTextIsDisplayed(String expectedText) {
        assertThat(loginPage.getAlertErrorMessage()).as("Wrong error message")
                .containsIgnoringCase(expectedText);
    }

    @When("the customer is logged in")
    public void customerIsLoggedIn() throws Exception {
        loginPage.logIn();
    }
}
