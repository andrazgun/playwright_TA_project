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

public class BasePage {

    private static final String CONSENT_BUTTON_SELECTOR = "button.fc-cta-consent";
    public static ScenarioSession scenarioSession;
    private final BrowserManager browserManager;

    public BasePage(BrowserManager browserManager) {
        this.browserManager = browserManager;
        scenarioSession = new ScenarioSession();
    }

    protected BrowserManager getBrowserManager() {
        return browserManager;
    }

    public boolean isDisplayed(String expectedUrl) {
        String currentUrl = getBrowserManager().getPage().url();
        return currentUrl.equalsIgnoreCase(expectedUrl);
//        return currentUrl.contains(expectedUrl);
    }

    protected Locator getByLocator(String locator) {
        return getBrowserManager().getPage().locator(locator);
    }

    protected Locator getByTestId(String testId) {
        return getBrowserManager().getPage().getByTestId(testId);
    }

    protected void fillIfNotNull(String value, Locator locator) {
        if (value != null) {
            locator.fill(value);
        }
    }

    public void waitAndClickByRole(String role, String name) {
        Locator element = browserManager.getPage().getByRole(AriaRole.valueOf(role.toUpperCase()), new Page.GetByRoleOptions().setName(name));
        element.click();
    }

    public void waitAndClickBySelector(String selector) {
        browserManager.getPage().waitForSelector(selector, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        browserManager.getPage().click(selector);
    }

    public void waitAndClick(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        locator.click();
    }

    public void navigate(String url) {
//        browserManager.getPage().navigate(url);
        browserManager.getPage().navigate(url, new Page.NavigateOptions()
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
            Locator consentButtonLocator = getByLocator(CONSENT_BUTTON_SELECTOR);
            if (consentButtonLocator.isVisible()) {
                consentButtonLocator.click();
                System.out.println("✅ Consent popup accepted.");
            }
        } catch (TimeoutError e) {
            System.out.println("ℹ️ Consent popup not displayed.");
        }
    }
}
