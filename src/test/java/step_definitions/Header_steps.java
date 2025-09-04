package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.HeaderComponent;

import java.util.List;

public class Header_steps {

    private final HeaderComponent headerComponent;

    public Header_steps(HeaderComponent headerComponent) {
        this.headerComponent = headerComponent;
    }

    @And("the customer clicks cart on Header")
    public void clicksCartButton() {
        headerComponent.clickCartIcon();
    }

    @When("the customer searches for {string}")
    public void theCustomerSearchesFor(String text) {
        headerComponent.searchFor(text);
    }

    @When("the customer types {string} in the search bar")
    public void theCustomerTypesInTheSearchBar(String string) {
        headerComponent.typeInSearchField(string);
    }

    @When("the customer clicks main icon")
    public void customerClicksMainIcon() {
        headerComponent.clickMainIcon();
    }

    @When("the customer clicks the wishlist icon on Header")
    public void customerClicksWishlistIconOnHeader() {
        headerComponent.clickWishListIcon();
    }

    @When("the customer clicks Useful Info on Header")
    public void clicksUsefulInfoOnHeader() {
        headerComponent.clickUsefulInfoButton();
    }

    @And("the customer clicks {string} from Useful Info dropdown")
    public void theCustomerClicksFromUsefulInfo(String arg0) {
        headerComponent.clickDropdownOption(arg0);
    }

    @Then("the system should display autocomplete suggestions containing {string}")
    public void theSystemShouldDisplayAutocompleteSuggestions(String keyword) {
        List<String> suggestions = headerComponent.getAutocompleteSuggestions();

        Assertions.assertThat(suggestions)
                .isNotEmpty()
                .anyMatch(s -> s.toLowerCase().contains(keyword.toLowerCase()));
    }

    @And("product count {string} on wishlist icon is displayed on Header")
    public void productCountStringOnWishlistIconIsDisplayedOnHeader(String text) {
        Assertions.assertThat(headerComponent.getWishlistIconCount())
                .as("Count is wrong")
                .isEqualTo(text);
    }

    @And("product count {string} on cart icon is displayed on Header")
    public void productCountOnCartIconIsDisplayedOnHeader(String arg0) {
        String productCount = headerComponent.getCartIconCount();
        Assertions.assertThat(productCount)
                .as("Count is wrong")
                .isEqualTo(arg0);
    }

    @Then("Product with quantity {string} is displayed on Header")
    public void productWithQuantityIsDisplayedOnHeader(String arg0) {
        String productQuantity = headerComponent.getProductQuantity();
        Assertions.assertThat(productQuantity)
                .as("Quantity is wrong")
                .isEqualTo(arg0);
    }
}
