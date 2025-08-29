package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.PlpPage;

import java.util.List;

import static support.StringUtils.replaceLineWithSpace;

public class PlpPage_steps {

    private final PlpPage plpPage;

    public PlpPage_steps(PlpPage plpPage) {
        this.plpPage = plpPage;
    }

    @Then("the first {long} products displayed should related to {string}")
    public void theSearchResultsShouldDisplayRelevantProducts(long productListLimit, String text) {
        List<String> productTitles = plpPage.getProductTitlesTextList(productListLimit);
        Assertions.assertThat(productTitles)
                .anyMatch(title -> title.toLowerCase().contains(text.toLowerCase()));
    }

    @Then("no search result list should be displayed")
    public void shouldNotSeeASearchResultList() {
        Assertions.assertThat(plpPage.getNoResultInfoText()).isNotEmpty();
    }

    @Then("info message containing {string} is displayed")
    public void noResultInfoMessageContainingIsDisplayed(String text) {
        Assertions.assertThat(plpPage.getNoResultInfoText()).containsIgnoringCase(text);
    }

    @When("the customer adds a product to wishlist named favorite")
    public void theCustomerAddsAProductToTheWishlist() {
        plpPage.clickHeartIconOnFirstProduct();
        plpPage.selectFavoriteListFromPopup();
    }

    @When("the customer clicks add to list on first product")
    public void theCustomerClicksAddToListOnFirstProduct() {
        plpPage.clickHeartIconOnFirstProduct();
    }

    @Then("success message is displayed on PlpPage")
    public void successMessageIsDisplayedOnPlpPage() {
        Assertions.assertThat(plpPage.successMessageIsDisplayed())
                .as("Success message not displayed")
                .isTrue();
    }

    @When("the customer adds first product to cart")
    public void theCustomerAddsFirstProductToCart() {
        plpPage.clickAddToFirstProduct();
    }

    @When("the customer select product category {string}")
    public void selectProductCategoryString(String categoryName) {
        plpPage.selectCategoryByName(categoryName);
    }

    @Then("Product category page {string} is displayed")
    public void productCategoryPageIsDisplayed(String arg0) {
        Assertions.assertThat(
                replaceLineWithSpace(plpPage.getUrl()))
                .as("Wrong url").containsIgnoringCase(arg0);
    }
}
