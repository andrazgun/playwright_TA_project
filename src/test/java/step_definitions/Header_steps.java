package step_definitions;

import io.cucumber.java.en.And;
import pages.HeaderComponent;

public class Header_steps {

    private final HeaderComponent headerComponent;

    public Header_steps(HeaderComponent headerComponent) {
        this.headerComponent = headerComponent;
    }

    @And("I click cart on Header")
    public void iClickCartButton() {
        headerComponent.clickCart();
    }
}
