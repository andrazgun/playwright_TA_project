package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import java.util.List;

import static support.Constants.STATE_HIDDEN;
import static support.Constants.STATE_VISIBLE;

public class HeaderComponent extends BasePage {

    private final AlertComponent alertComponent;

    public HeaderComponent(BrowserManager browserManager, AlertComponent alertComponent) {
        super(browserManager);
        this.alertComponent = alertComponent;
    }

    private Locator searchField() {
        return getByTestId("desktop-search");
    }

    private Locator autocompleteSuggestionsResult() {
        return getByLocator("ul#awesomplete_list_1 li[role='option']");
    }

    private Locator searchBtn() {
        return getByLocator("[class='btn btn-primary search-btn']");
    }

    private Locator wishlistIcon() {
        return getByLocator("[id='top-wishlist']");
    }

    private Locator cartIcon() {
        return getByLocator("[id='top-cart-btn']");
    }

    private Locator cartIconCount() {
        return getByLocator("[id='top-cart-btn-qty']");
    }

    private Locator productQuantity() {
        return getByLocator("[class='cart_product cart-item'] [class='product-quantity']");
    }

    private Locator wishlistIconCount() {
        return getByLocator("[id='wishlist-count-desktop']");
    }

    private Locator mainIcon() {
        return getByLocator("[title='Bebe Tei']").first();
    }

    private Locator cartPopup() {
        return getByLocator("[id='cart-popup']");
    }

    public void typeInSearchField(String text) {
        searchField().fill(text);
        searchField().press("Backspace");
        String lastChar = text.substring(text.length() - 1);
        searchField().press(lastChar);
    }

    public void clickSearchBtn() {
        searchBtn().click();
    }

    public void clickWishListIcon() {
        wishlistIcon().click();
    }

    public void clickCartIcon() {
        cartIcon().nth(0).click();
        waitForLocatorByState(cartPopup(), STATE_VISIBLE);
    }

    public void searchFor(String text) {
        fillField(searchField(), text);
        searchBtn().click();
    }

    public List<String> getAutocompleteSuggestions() {
        waitForLocatorByState(autocompleteSuggestionsResult().first(), STATE_VISIBLE);
        return autocompleteSuggestionsResult()
                .allInnerTexts()
                .stream()
                .map(String::trim)
                .toList();
    }

    public void clickMainIcon() {
        mainIcon().click();
    }

    public String getWishlistIconCount() {
        return getLocatorInnerText(wishlistIconCount());
    }

    public String getCartIconCount() {
        waitForLocatorByState(alertComponent.alertDialog(), STATE_HIDDEN);
        return  getLocatorInnerText(cartIconCount());
    }

    public String getProductQuantity() {
        return getLocatorInnerText(productQuantity());
    }

}
