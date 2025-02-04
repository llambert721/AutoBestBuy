package pages;

import com.microsoft.playwright.Page;

public class DetectionPage {
    private Page page;
    private final String URL = "https://www.browserscan.net/bot-detection";

    public DetectionPage(Page aPage) {
        this.page = aPage;
    }

    public void Detect() {
        this.page.navigate(URL);
    }
}
