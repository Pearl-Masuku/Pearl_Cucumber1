package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApprovedAdminPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"login-email\"]")
    WebElement newAdminEmailFieldId;
    @FindBy(xpath = "//*[@id=\"login-password\"]")
    WebElement newAdminPasswordFieldId;
    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    WebElement newAdminloginButtonId;
    @FindBy(xpath = "//*[@id=\"app-main-content\"]/section/div[1]/h2")
    WebElement newAdminDashboardTitleXpath;
//    @FindBy(xpath = "//*[@id=\"overview-hero\"]/div")
//    WebElement mainHomePageTitleXpath;




    public ApprovedAdminPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterNewAdminEmail(String newAdminEmail)
    {
        newAdminEmailFieldId.clear();
        newAdminEmailFieldId.sendKeys(newAdminEmail);
    }

    public void enterNewAdminPassword(String newAdminPassword)
    {
        newAdminPasswordFieldId.clear();
        newAdminPasswordFieldId.sendKeys(newAdminPassword);
    }

    public void clickNewLoginButton()
    {
        newAdminloginButtonId.click();
    }

    public boolean isNewAdminDashboardDisplayed()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)) .until(ExpectedConditions.visibilityOf(newAdminDashboardTitleXpath));
        return newAdminDashboardTitleXpath.isDisplayed();
    }

    public void clickInstructorPanel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdownToggle = wait.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/div/button") ) );
        dropdownToggle.click();
        // 2. Now click a specific item inside the dropdown
        WebElement adminPanelBtn = wait.until( ExpectedConditions.elementToBeClickable( By.xpath("//button[@class='nav-dropdown-item']//span[text()='Instructor Panel']") ) );
        adminPanelBtn.click();
    }
//
//    public void clickAdminLogout() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement dropdownToggle = wait.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/div/button") ) );
//        dropdownToggle.click();
//        // 2. Now click a specific item inside the dropdown
//        WebElement adminPanelBtn = wait.until( ExpectedConditions.elementToBeClickable( By.xpath("//button[@class='nav-dropdown-item']//span[text()='Logout']") ) );
//        adminPanelBtn.click();
//    }
//
//    public void acceptLogoutAlert() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//        driver.switchTo().alert().accept();
//    }
//
//    public boolean isMainHomePageDisplayed()
//    {
//        new WebDriverWait(driver, Duration.ofSeconds(10)) .until(ExpectedConditions.visibilityOf(mainHomePageTitleXpath));
//        return mainHomePageTitleXpath.isDisplayed();
//    }


}
