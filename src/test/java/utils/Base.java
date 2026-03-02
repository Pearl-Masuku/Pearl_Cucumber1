package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AdminPage;
import pageObjects.AdminPanelPage;
import pageObjects.RegisterPage;
import pageObjects.UserManagementPage;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome", "https://ndosisimplifiedautomation.vercel.app/");
    public RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
    public AdminPage adminPage = PageFactory.initElements(driver, AdminPage.class);
    public AdminPanelPage adminPanelPage = PageFactory.initElements(driver, AdminPanelPage.class);
    public UserManagementPage userManagementPage = PageFactory.initElements(driver, UserManagementPage.class);

}
