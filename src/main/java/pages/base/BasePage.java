package pages.base;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.microsoft.playwright.options.WaitUntilState;
import org.slf4j.Logger;
import session.ScenarioSession;
import support.LogUtil;

import java.util.ArrayList;
import java.util.List;

import static support.Constants.BASE_URL;

public class BasePage {

    private final BrowserManager browserManager;
    public static ScenarioSession scenarioSession;
    protected final Logger logger = LogUtil.getLogger(this.getClass());

    public BasePage(BrowserManager browserManager) {
        this.browserManager = browserManager;
        scenarioSession = new ScenarioSession();
    }

    protected BrowserManager getBrowserManager() {
        return browserManager;
    }

    public boolean isAtUrl(String expectedUrl) {
        String currentUrl = getBrowserManager().getPage().url();
        logger.info("Current url {}", currentUrl);
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
        acceptAllCookies();
        logger.info("Navigate to {}", buildUrl(path));
    }

    public void waitForPageLoad() {
        browserManager.getPage().waitForLoadState(LoadState.LOAD);
        logger.info("Page loaded");
    }


    public void fillField(String placeholder, String text) {
        getBrowserManager().getPage().getByPlaceholder(placeholder).fill(text);
    }

    public void fillField(Locator locator, String text) {
        locator.clear();
        locator.fill(text);
    }

    protected List<String> getLocatorTexts(Locator locator) {
        int count = locator.count();
        List<String> texts = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            texts.add(locator.nth(i).innerText().trim());
        }
        return texts;
    }

    private void acceptAllCookies() {
        Locator consentButtonLocator = getByTestId("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");

        try {
            waitForStateVisible(consentButtonLocator);
            consentButtonLocator.click();
            logger.info("✅ Consent popup accepted.");

        } catch (TimeoutError e) {
            logger.info("ℹ️ Consent popup not displayed.");

        } catch (PlaywrightException e) {
            logger.warn("⚠️ Error interacting with consent popup: {}", e.getMessage());
        }
    }
}
