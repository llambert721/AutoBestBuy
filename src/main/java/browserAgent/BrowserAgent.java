/*
* Written by: Logan Lambert
* 2/2/25
*
* BrowserAgent handles initialization
* and closing of browser
* */

package browserAgent;

import com.microsoft.playwright.*;
import com.sun.tools.javac.util.List;

public class BrowserAgent {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext browserContext;
    private static Page page;

    public static Page initBrowser() {
        if (playwright == null) {
            playwright = Playwright.create();
        }

        if (browser == null) {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setArgs(List.of("--disable-blink-features=AutomationControlled"))); // Stealth Mode
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        return page;
    }

    public static void closePlaywright() {
        if (page != null) {
            page.close();
        }
        if (browserContext != null) {
            browserContext.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
