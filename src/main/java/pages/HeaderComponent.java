package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import java.util.List;

public class HeaderComponent extends BasePage {
    public HeaderComponent(BrowserManager browserManager) {
        super(browserManager);
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

    private Locator wishlistIconCount() {
        return getByLocator("[id='wishlist-count-desktop']");
    }

    private Locator mainIcon() {
        return getByLocator("[title='Bebe Tei']").first();
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
    }

    public void searchFor(String text) {
        fillField(searchField(), text);
        searchBtn().click();
    }

    public List<String> getAutocompleteSuggestions() {
        waitForStateVisible(autocompleteSuggestionsResult().first());
        return autocompleteSuggestionsResult()
                .allInnerTexts()
                .stream()
                .map(String::trim)
                .toList();
    }

    public String getWishlistCount() {
        return getLocatorInnerText(wishlistIconCount());
    }

    public void clickMainIcon() {
        mainIcon().click();
    }
}
