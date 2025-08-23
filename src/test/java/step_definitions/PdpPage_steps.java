package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.PdpPage;

public class PdpPage_steps {

    private final PdpPage pdpPage;

    public PdpPage_steps(PdpPage pdpPage) {
        this.pdpPage = pdpPage;
    }

    @When("I change the product quantity to {string}")
    public void iChangeTheProductQuantityTo(String quantity) {
        pdpPage.changeQuantity(quantity);
    }

    @When("I click add to cart button on PdpPage")
    public void iClickAddToCartButton() {
        pdpPage.addToCart();
    }

    @Then("Cart icon is displayed with quantity {string}")
    public void cartIconIsDisplayedWithQuantity(String expectedQuantity) {
        Assertions.assertThat(pdpPage.getSecondCartCount())
                .as("Value is wrong").isEqualTo(expectedQuantity);
    }
}
