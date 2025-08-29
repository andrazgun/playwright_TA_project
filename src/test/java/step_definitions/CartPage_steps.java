package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CartPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CartPage_steps {

    private final CartPage cartPage;

    public CartPage_steps(CartPage cartPage) {
        this.cartPage = cartPage;
    }

    @Then("CartPage is displayed")
    public void cartPageIsDisplayed() {
        assertThat(cartPage.isAtUrl()).as("Wrong URL").isTrue();
    }

    @And("I navigate to CartPage")
    public void iNavigateToCartPage() {
        cartPage.navigateToCartPage();
    }
}
