package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import java.util.List;

public class PlpPage extends BasePage {

    public PlpPage(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator productTitle() {
        return getByLocator("[class='item-title text-center ']");
    }

    private Locator noResultsInfo() {
        return getByLocator("[class='no-results-info']");
    }

    private Locator heartIcon() {
        return getByLocator("a.icon-favorite-btn.js-favorite");
    }

    private Locator favoriteWishlistFromPopup() {
        return getByLocator("div.move-to-wishlist-modal li[data-wishlist-name='Favorite']");
    }

    private Locator successMessage() {
        return getByLocator("span.brighttheme-icon-success");
    }

    public String getNoResultInfoText() {
        return getLocatorText(noResultsInfo());
    }

    public List<String> getProductTitlesTextList() {
        return productTitle().allInnerTexts()
                .stream()
                .limit(4)
                .map(String::trim)
                .toList();
    }

    public void clickHeartIconOnFirstProduct() {
        heartIcon().first().scrollIntoViewIfNeeded();
        heartIcon().first().click();
    }

    public void selectFavoriteListFromPopup() {
        favoriteWishlistFromPopup().click();
    }

    public boolean successMessageIsDisplayed() {
        return successMessage().isVisible();
    }
}
