package step_definitions;

import io.cucumber.java.en.Then;
import pages.HowToOrderPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HowToOrder_steps {
    private final HowToOrderPage howToOrderPage;

    public HowToOrder_steps(HowToOrderPage howToOrderPage) {
        this.howToOrderPage = howToOrderPage;
    }

    @Then("HowToOrder page is displayed")
    public void howtoOrderPageIsDisplayed() {
        assertThat(howToOrderPage.isAtUrl()).as("Wrong URL").isTrue();
    }
}
