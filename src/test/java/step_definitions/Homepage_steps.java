package step_definitions;

import io.cucumber.java.en.Given;
import pages.HomePage;

public class Homepage_steps {
    private final HomePage homePage;

    public Homepage_steps(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("the customer opens Homepage")
    public void customerOpensHomePage() {
        homePage.navigateToHomePage();
    }
}
