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

    @And("I click cart on Header")
    public void iClickCartButton() {
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

    @Then("the system should display autocomplete suggestions containing {string}")
    public void theSystemShouldDisplayAutocompleteSuggestions(String keyword) {
        List<String> suggestions = headerComponent.getAutocompleteSuggestions();

        Assertions.assertThat(suggestions)
                .isNotEmpty()
                .anyMatch(s -> s.toLowerCase().contains(keyword.toLowerCase()));
    }

    @And("product count {string} on wishlist icon is displayed on Header")
    public void productCountStringOnWishlistIconIsDisplayedOnHeader(String text) {
        Assertions.assertThat(headerComponent.getWishlistCount())
                .as("Count is wrong")
                .isEqualTo(text);
    }
}
