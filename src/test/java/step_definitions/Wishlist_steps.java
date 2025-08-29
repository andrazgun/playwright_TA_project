package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.WishlistPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Wishlist_steps {

    private final WishlistPage wishlistPage;

    public Wishlist_steps(WishlistPage wishlistPage) {
        this.wishlistPage = wishlistPage;
    }

    @When("the customer creates a wishlist named {string}")
    public void theCustomerCreatesAWishlistNamed(String arg0) {
        wishlistPage.createWishlist(arg0);
    }

    @Then("the wishlist should contain at least {int} products")
    public void theWishlistShouldContainAtLeastProducts(int expectedCount) {
        int actualCount = wishlistPage.getWishlistProductCount();
        Assertions.assertThat(actualCount).isGreaterThanOrEqualTo(expectedCount);
    }


    @Then("wishlist named {string} is displayed")
    public void wishlistNamedIsDisplayed(String arg0) {
        Assertions.assertThat(wishlistPage.getWishlistByName(arg0)).isNotEmpty();
    }

    @Then("WishlistPage is displayed")
    public void wishlistPageIsDisplayed() {
        assertThat(wishlistPage.isAtUrl()).as("Wrong URL").isTrue();
    }

    @And("the customer selects wishlist {string}")
    public void theCustomerSelectsWishlist(String arg0) {
        wishlistPage.selectWishlistByName(arg0);
    }

    @When("the customer removes all the products from the wishlist")
    public void theCustomerRemovesAllTheProductsFromTheWishlist() {
        wishlistPage.removeAllProductsFromWishlist();
    }

    @Then("the wishlist should be empty")
    public void theWishlistShouldBeEmpty() {
        Assertions.assertThat(wishlistPage.getWishlistProductCount()).isEqualTo(0);
    }
}
