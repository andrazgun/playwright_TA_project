package step_definitions;

import io.cucumber.java.en.Given;
import pages.ShopPage;

public class ShopPage_steps {

    private final ShopPage shopPage;

    public ShopPage_steps(ShopPage shopPage) {
        this.shopPage = shopPage;
    }

    @Given("I navigate to ShopPage")
    public void iNavigateToShopPage() {
        shopPage.navigateToShopPage();
    }
}
