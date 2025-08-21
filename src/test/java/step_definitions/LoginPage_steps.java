package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import session.ScenarioSession;
import session.SessionKeys;

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
        loginPage.navigate();
    }

    @When("I type a user name {string}")
    public void iTypeAUserName(String username) {
        loginPage.typeEmail(username);
    }

    @When("I type a password {string}")
    public void iTypeAPassword(String password) {
        loginPage.typePassword(password);
    }

    @When("I type a user name {string} and a password {string}")
    public void iTypeAUserNameUsernameAndAPasswordPassword(String username, String password) {
        loginPage.typeEmail(username);
        loginPage.typePassword(password);
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("I should be presented with an alert box which contains text {string}")
    public void iShouldBePresentedWithAnAlertBoxWhichContainsTextExpectedAlertText(String expectedAlertText) {
        String alertText = scenarioSession.get(SessionKeys.ALERT_TEXT, String.class);
        Assert.assertEquals(alertText, expectedAlertText, "Text doesn't match");
    }

    @Then("Login button is displayed")
    public void loginPageIsDisplayed() {
        assertThat(loginPage.isLoginBtnDisplayed()).isTrue();
    }
}
