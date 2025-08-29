package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import static support.Constants.*;

public class WishlistPage extends BasePage {

    public WishlistPage(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator wishlistTitle() {
        return getByLocator("[class='wishlist-name text-bold-700']");
    }

    private Locator addWishlistButton() {
        return getByText("Adaugă listă");
    }

    private Locator addWishlistFormInputField() {
        return getByTestId("exampleFormControlInput1");
    }

    private Locator addWishlistFormSaveBtn() {
        return getByLocator("[class='btn btn-primary btn-sm']");
    }

    private Locator wishlistProductCount() {
        return getByLocator("div.wishlist-header h2 small");
    }

    private Locator removeProductIcons() {
        return getByLocator("a.wishlist-item.remove-wishlist-item");
    }

    private Locator successToast() {
        return getByLocator("div.Toastify__toast--success");
    }

    public void waitForSuccessToast() {
        waitForLocatorByState(successToast(), STATE_VISIBLE);
        waitForLocatorByState(successToast(), STATE_DETACHED);
    }

    public int getWishlistProductCount() {
        String text = wishlistProductCount().innerText().trim();
        return Integer.parseInt(text.split(" ")[0]);
    }

    public void selectWishlistByName(String text) {
        wishlistTitle()
                .filter(new Locator.FilterOptions().setHasText(text))
                .first()
                .click();
    }

    public String getWishlistByName(String text) {
        return wishlistTitle().allInnerTexts()
                .stream()
                .filter(title -> title.equals(text))
                .toString();
    }

    public void createWishlist(String arg0) {
        addWishlistButton().click();
        addWishlistFormInputField().fill(arg0);
        addWishlistFormSaveBtn().click();
    }

    public boolean isAtUrl() {
        return super.isAtUrl(PATH_WISHLIST);
    }

    public void removeAllProductsFromWishlist() {
        while (removeProductIcons().count() > 0) {
            removeProductIcons().first().click();
            waitForSuccessToast();
        }
    }
}
