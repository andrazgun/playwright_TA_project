package pages.base;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.microsoft.playwright.options.WaitUntilState;
import session.ScenarioSession;

import java.util.ArrayList;
import java.util.List;

import static support.Constants.BASE_URL;

public class BasePage {

    private final BrowserManager browserManager;
    public static ScenarioSession scenarioSession;

    public BasePage(BrowserManager browserManager) {
        this.browserManager = browserManager;
        scenarioSession = new ScenarioSession();
    }

    protected BrowserManager getBrowserManager() {
        return browserManager;
    }

    public boolean isAtUrl(String expectedUrl) {
        String currentUrl = getBrowserManager().getPage().url();
        return currentUrl.contains(expectedUrl);
    }

    protected Locator getByRole(String role) {
        return browserManager.getPage().getByRole(AriaRole.valueOf(role.toUpperCase()));
    }

    protected Locator getByRole(String role, String name) {
        return browserManager.getPage().getByRole(AriaRole.valueOf(role.toUpperCase()),
                new Page.GetByRoleOptions().setName(name));
    }

    protected Locator getByLocator(String locator) {
        return getBrowserManager().getPage().locator(locator);
    }

    protected Locator getByTestId(String testId) {
        return getBrowserManager().getPage().getByTestId(testId);
    }

    protected Locator getByText(String text) {
        return getBrowserManager().getPage().getByText(text);
    }

    protected String getLocatorText(Locator locator) {
        return locator.innerText().trim();
    }

    protected void fillIfNotNull(String value, Locator locator) {
        if (value != null) {
            locator.fill(value);
        }
    }

    public void clickAndWaitByRole(String role, String name) {
        getBrowserManager().setPage(getBrowserManager().getContext().waitForPage(() ->
                        getByRole(role, name).click()));
    }

    public void waitAndClickBySelector(String selector) {
        browserManager.getPage().waitForSelector(selector, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        browserManager.getPage().click(selector);
    }

    public void waitForStateVisible(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    }

    public void waitForStateDetached(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.DETACHED));
    }

    public static String buildUrl(String path) {
        return BASE_URL + path;
    }

    public void navigate(String path) {
        browserManager.getPage().navigate(buildUrl(path), new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
        acceptConsentPopup();
    }

    public void fillField(String placeholder, String text) {
        getBrowserManager().getPage().getByPlaceholder(placeholder).fill(text);
    }

    protected List<String> getLocatorTexts(Locator locator) {
        int count = locator.count();
        List<String> texts = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            texts.add(locator.nth(i).innerText().trim());
        }
        return texts;
    }

    private void acceptConsentPopup() {
        try {
            Locator consentButtonLocator = getByRole("button","Închide dialogul");

            if (consentButtonLocator.isVisible()) {
                consentButtonLocator.click();
                System.out.println("✅ Consent popup accepted.");
            }
        } catch (TimeoutError e) {
            System.out.println("ℹ️ Consent popup not displayed.");
        } catch (Exception e) {
            System.out.println("⚠️ Error interacting with consent popup: " + e.getMessage());
        }
    }
}
