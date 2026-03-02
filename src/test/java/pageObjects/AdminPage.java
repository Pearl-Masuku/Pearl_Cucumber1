package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {

    WebDriver driver;

    @FindBy(id = "login-heading")
    WebElement learningMaterialTitleId;
    @FindBy(id = "login-email")
    WebElement adminEmailFieldId;
    @FindBy(id = "login-password")
    WebElement adminPasswordFieldId;
    @FindBy(id = "login-submit")
    WebElement adminloginButtonId;
    @FindBy(xpath = "//*[@id=\"app-main-content\"]/section/div[1]/h2")
    WebElement adminDashboardTitleXpath;
    @FindBy(xpath = "//*[@id=\"overview-hero\"]/div")
    WebElement mainHomePageTitleXpath;




    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public String verifyAdminPageisDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(learningMaterialTitleId));
        return learningMaterialTitleId.getText();
    }

    public void enterAdminEmail(String adminEmail)
    {
        adminEmailFieldId.clear();
        adminEmailFieldId.sendKeys(adminEmail);
    }

    public void enterAdminPassword(String adminPassword)
    {
        adminPasswordFieldId.clear();
        adminPasswordFieldId.sendKeys(adminPassword);
    }

    public void clickLoginButton()
    {
        adminloginButtonId.click();
    }

    public boolean isAdminDashboardDisplayed()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)) .until(ExpectedConditions.visibilityOf(adminDashboardTitleXpath));
        return adminDashboardTitleXpath.isDisplayed();
    }

    public void clickAdminPanel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdownToggle = wait.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/div/button") ) );
        dropdownToggle.click();
        // 2. Now click a specific item inside the dropdown
        WebElement adminPanelBtn = wait.until( ExpectedConditions.elementToBeClickable( By.xpath("//button[@class='nav-dropdown-item']//span[text()='Admin Panel']") ) );
        adminPanelBtn.click();
    }

    public void clickAdminLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdownToggle = wait.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/div/button") ) );
        dropdownToggle.click();
        // 2. Now click a specific item inside the dropdown
        WebElement adminPanelBtn = wait.until( ExpectedConditions.elementToBeClickable( By.xpath("//button[@class='nav-dropdown-item']//span[text()='Logout']") ) );
        adminPanelBtn.click();
    }

    public void acceptLogoutAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public boolean isMainHomePageDisplayed()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)) .until(ExpectedConditions.visibilityOf(mainHomePageTitleXpath));
        return mainHomePageTitleXpath.isDisplayed();
    }


}
