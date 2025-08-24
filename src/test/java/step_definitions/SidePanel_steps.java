package step_definitions;

import io.cucumber.java.en.And;
import pages.CartSide;

public class SidePanel_steps {

    private final CartSide cartSide;

    public SidePanel_steps(CartSide cartSide) {
        this.cartSide = cartSide;
    }

    @And("I click go to cart on SidePanel")
    public void iClickGoToCartOnSidePanel() {
        cartSide.goToCart();
    }
}
