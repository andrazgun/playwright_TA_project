package step_definitions;

import io.cucumber.java.en.And;
import pages.CartSide;

public class SidePanel {

    private final CartSide cartSide;

    public SidePanel(CartSide cartSide) {
        this.cartSide = cartSide;
    }


    @And("I click go to cart on SidePanel")
    public void iClickGoToCartOnSidePanel() {
        cartSide.goToCart();
    }
}
