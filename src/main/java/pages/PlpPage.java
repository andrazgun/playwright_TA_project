package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;
import support.StringUtils;

import java.util.List;

import static support.Constants.STATE_VISIBLE;

public class PlpPage extends BasePage {

    private final LHNComponent lhnComponent;

    public PlpPage(BrowserManager browserManager, LHNComponent lhnComponent) {
        super(browserManager);
        this.lhnComponent = lhnComponent;
    }

    private Locator productTitle() {
        return getByLocator("[class='item-title text-center '] h4");
    }

    private Locator productPrice() {
        return getByLocator("[class='price-box'] [class='regular-price']");
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

    private Locator sortButton() {
        return getByRole("link", "Ordonează după:");
    }

    private Locator successMessage() {
        return getByLocator("span.brighttheme-icon-success");
    }

    public String getNoResultInfoText() {
        return getLocatorInnerText(noResultsInfo());
    }

    public List<String> getProductTitlesTextList(long listLimit) {
        waitForLocatorByState(addToCartButton().first(), STATE_VISIBLE);
        return productTitle().allInnerTexts()
                .stream()
                .limit(listLimit)
                .map(String::trim)
                .toList();
    }

    public List<Double> getProductPrices() {
        return productPrice()
                .allInnerTexts()
                .stream()
                .map(StringUtils::priceStringToDouble)
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

    public void selectCategoryByName(String name) {
        lhnComponent.clickProductCategoryByName(name);
    }

    public void sortProductByCategory(String category) {
        sortButton().click();
        getByRole("link", category).click();
    }
}
