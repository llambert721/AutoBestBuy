package main;


import browserAgent.BrowserAgent;
import com.microsoft.playwright.Page;
import pages.Login;

public class Main {
    public static void main(String[] args)
    {
        Page browser = BrowserAgent.initBrowser();
        Login loginPage = new Login(browser);
        loginPage.login();
    }
}
