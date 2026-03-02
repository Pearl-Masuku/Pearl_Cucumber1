package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserManagementPage {

    WebDriver driver;


    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[2]/nav/button[2]")
    WebElement userManagementBtnXpath;
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[3]/div/div[1]/div[1]/h1")
    WebElement userManagementTextXpath;
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[2]/div[2]/button")
    WebElement userManagementBackBtnXpath;



    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUsersButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(userManagementBtnXpath));
        userManagementBtnXpath.click();
    }

    public boolean verifyUserManagementIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(userManagementTextXpath));
        return userManagementTextXpath.isDisplayed();
    }

    public void searchApprovedUserByEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-root\"]/div/div[3]/div/div[1]/div[2]/input")));
        searchBar.clear();
        searchBar.sendKeys(email);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void selectUserRole() {
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"app-root\"]/div/div[3]/div/div[2]/table/tbody/tr/td[4]/select"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("\uD83D\uDC51 Admin");
    }

    public void handleMultipleAlerts(int count)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); for (int i = 1; i <= count; i++)
        {
            try
            {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                System.out.println("Are you sure you want to change this user's role to admin? " + i + " text: " + alert.getText());
                alert.accept(); // Click OK
            } catch (TimeoutException e) { System.out.println("No alert appeared for step " + i);
            }
        }
    }

    public void clickBackToWebsiteButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(userManagementBackBtnXpath));
        userManagementBackBtnXpath.click();
    }

}
