package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

public class AlertComponent extends BasePage {

    public AlertComponent(BrowserManager browserManager) {
        super(browserManager);
    }

    private Locator alertDialog() {
        return getByLocator("div[role='alertdialog']");
    }

    private Locator alertDialogTextDiv() {
        return getByLocator("div[role='alert'] .pnotify-text");
    }

    public boolean isAlertDialogDisplayed() {
        return alertDialog().isVisible();
    }

    public String getAlertText() {
        return getLocatorInnerText(alertDialogTextDiv());
    }

}

