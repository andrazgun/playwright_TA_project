package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OrdersPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrdersPage_steps {

    private final OrdersPage ordersPage;

    public OrdersPage_steps(OrdersPage ordersPage) {
        this.ordersPage = ordersPage;
    }

    @When("I click the first product")
    public void iClickTheFirstProduct() {
        ordersPage.clickFirstProduct();
    }

    @Then("OrdersPage is displayed")
    public void ordersPageIsDisplayed() {
        assertThat(ordersPage.isAtUrl()).as("Wrong URL").isTrue();
    }
}
