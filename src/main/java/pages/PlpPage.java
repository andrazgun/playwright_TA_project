package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import java.util.List;

import static support.Constants.STATE_VISIBLE;

public class PlpPage extends BasePage {

    public PlpPage(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator productTitle() {
        return getByLocator("[class='item-title text-center '] h4");
    }

    private Locator noResultsInfo() {
        return getByLocator("[class='no-results-info']");
    }

    private Locator heartIcon() {
        return getByLocator("[class='icon-favorite-btn']");
    }

    private Locator addToCartButton() {
        return getByLocator("[class='btn btn-primary cd-add-to-cart']");
    }

    private Locator favoriteWishlistFromPopup() {
        return getByLocator("div.move-to-wishlist-modal li[data-wishlist-name='Favorite']");
    }

    private Locator successMessage() {
        return getByLocator("span.brighttheme-icon-success");
    }

    public String getNoResultInfoText() {
        return getLocatorInnerText(noResultsInfo());
    }

    public List<String> getProductTitlesTextList() {
        waitForLocatorByState(addToCartButton().first(), STATE_VISIBLE);
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

    public void clickAddToFirstProduct() {
        addToCartButton().first().scrollIntoViewIfNeeded();
        addToCartButton().first().click();
    }

    public void selectFavoriteListFromPopup() {
        favoriteWishlistFromPopup().click();
    }

    public boolean successMessageIsDisplayed() {
        return successMessage().isVisible();
    }
}
