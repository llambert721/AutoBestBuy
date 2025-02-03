package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.BoundingBox;

public class Login {
    private Page page;
    private final String bestBuyUrl = "https://www.bestbuy.com";

    // Selectors
    private final String accountBtn = "//*[@id='account-menu-account-button']";
    private final String signInBtn = "//*[@id=\"shop-account-signin-create-88255691\"]/div/div/span[2]/a[1]";
    private final String emailInput = "//*[@id='fld-e']";
    private final String continueBtn = "/html/body/div[1]/div/section/main/div[2]/div/div/div[1]/div/div/div/div/div/form/div[3]/button";
    private final String usePasswordBtn = "//*[@id='password-radio']";
    private final String passwordInput = "//*[@id='fld-p1']";

    // Constructors
    public Login(Page aPage) {
        this.page = aPage;
    }

    // Methods
    public void login() {
        this.page.navigate(this.bestBuyUrl);
        page.waitForTimeout(1000);
        //this.page.click(accountBtn);
        //boolean isVisible = page.locator("//*[@id='shop-account-signin-create-88255691']/div/div/span[2]/a[1]").isVisible();
        //System.out.println("Is element visible? " + isVisible);
        //this.page.click(signInBtn);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Account")).click();
        page.getByTestId("signInButton").click();
        page.waitForTimeout(1000);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).click();
        page.waitForTimeout(1000);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).fill("");
        page.waitForTimeout(1000);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        page.waitForTimeout(1000);
        page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Use password")).check();
        page.waitForTimeout(1000);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
        page.waitForTimeout(1000);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("");
        page.waitForTimeout(1000);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
    }
}
