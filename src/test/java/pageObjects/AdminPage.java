package pageObjects;

import org.openqa.selenium.By;
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
    @FindBy(xpath = "//h2[contains(text(),'Welcome back, admin!')]")
    WebElement adminDashboardTitleXpath;


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
        WebElement adminPanelButton = driver.findElement(By.xpath("//button[@class='nav-dropdown-item']//span[text()='Admin Panel']"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(adminPanelButton));
        adminPanelButton.click();
    }

}
