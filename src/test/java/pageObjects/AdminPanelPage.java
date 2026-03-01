package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPanelPage {

    WebDriver driver;


    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[3]/div/div[1]/h1")
    WebElement adminPanelDashboardTitleXpath;
    @FindBy(id = "login-heading")
    WebElement learningMaterialTitleId;
    @FindBy(id = "login-email")
    WebElement adminEmailFieldId;
    @FindBy(id = "login-password")
    WebElement adminPasswordFieldId;
    @FindBy(id = "login-submit")
    WebElement adminloginButtonId;


    public AdminPanelPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyAdminPanelPageisDisplayed()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)) .until(ExpectedConditions.visibilityOf(adminPanelDashboardTitleXpath));
        return adminPanelDashboardTitleXpath.isDisplayed();
    }


    public void clickAdminPanel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdownToggle = wait.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/div/button") ) );
        dropdownToggle.click();
        // 2. Now click a specific item inside the dropdown
        WebElement adminPanelBtn = wait.until( ExpectedConditions.elementToBeClickable( By.xpath("//button[@class='nav-dropdown-item']//span[text()='Admin Panel']") ) );
        adminPanelBtn.click();

    }

}
