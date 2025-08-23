package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

public class PdpPage extends BasePage {

    public PdpPage(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator productQuantity() {
        return getByLocator("form.cart div.quantity input.input-text.qty.text");
    }

    private Locator addToCartBtn() {
        return getByRole("button", "Adaugă în coș");
    }
    private Locator cartCount() { return getByLocator("header a[title='Cos de cumpărături'] span.wd-cart-number.wd-tools-count");}

    public void addToCart() {
        addToCartBtn().first().click();
    }

    public void changeQuantity(String quantity) {
        productQuantity().first().clear();
        productQuantity().first().fill(quantity);
    }

    public String getSecondCartCount() {
        return getLocatorText(cartCount().nth(1)).split(" ")[0];
    }
}
