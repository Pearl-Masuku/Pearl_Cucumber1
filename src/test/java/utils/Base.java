package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.*;

public class Base {

    private static WebDriver driver;
    private static BrowserFactory browserFactory = new BrowserFactory();

    // Singleton driver getter
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = browserFactory.startBrowser("chrome", "https://ndosisimplifiedautomation.vercel.app/");
        }
        return driver;
    }

    // Quit driver once after all scenarios
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // Page objects initialized with shared driver
    public RegisterPage registerPage = PageFactory.initElements(getDriver(), RegisterPage.class);
    public AdminPage adminPage = PageFactory.initElements(getDriver(), AdminPage.class);
    public AdminPanelPage adminPanelPage = PageFactory.initElements(getDriver(), AdminPanelPage.class);
    public UserManagementPage userManagementPage = PageFactory.initElements(getDriver(), UserManagementPage.class);
    public ApprovedAdminPage approvedAdminPage = PageFactory.initElements(getDriver(), ApprovedAdminPage.class);
}
