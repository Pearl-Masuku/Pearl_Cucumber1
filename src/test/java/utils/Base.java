package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AdminPage;
import pageObjects.RegisterPage;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome", "https://ndosisimplifiedautomation.vercel.app/");
    public RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
    public AdminPage adminPage = PageFactory.initElements(driver, AdminPage.class);

}
