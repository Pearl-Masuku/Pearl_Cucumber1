package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AdminPanelPage {

    WebDriver driver;


    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[3]/div/div[1]/h1")
    WebElement adminPanelDashboardTitleXpath;
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[2]/nav/button[3]")
    WebElement approvalBtnXpath;
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[3]/div/div[1]/h1")
    WebElement userApprovalTextXpath;
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[3]/div/div[3]/table/tbody/tr/td[6]/button[1]")
    WebElement userApprovalBtnXpath;
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[3]/div/div[2]")
    WebElement approvalConfirmationXpath;



    public AdminPanelPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyAdminPanelPageisDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(adminPanelDashboardTitleXpath));
        return adminPanelDashboardTitleXpath.isDisplayed();
    }

    public void clickApprovalButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(approvalBtnXpath));
        approvalBtnXpath.click();
    }

    public boolean verifyApprovalPanelPageisDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(userApprovalTextXpath));
        return userApprovalTextXpath.isDisplayed();
    }

    public void searchUserByEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-root\"]/div/div[3]/div/div[2]/div/div/input")));
        searchBar.clear();
        searchBar.sendKeys(email);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void clickUserApprovalButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(userApprovalBtnXpath));
        userApprovalBtnXpath.click();
    }

    public boolean verifyApprovalConfirmation()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmationMessage = wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath("//div[contains(text(),'User approved successfully!')]") ) );
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Expected confirmation message to be displayed after approval");
        return  confirmationMessage.isDisplayed();
    }
}
