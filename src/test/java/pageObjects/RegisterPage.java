package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Base;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver = Base.getDriver();

    @FindBy(xpath = "//div[@class='nav-user-section']")
    WebElement LoginButtonXpath;
    @FindBy(id = "signup-toggle")
    WebElement signupToggleId;
    @FindBy(id = "register-firstName")
    WebElement firstNameFieldId;
    @FindBy(id = "register-lastName")
    WebElement lastNameFieldId;
    @FindBy(id = "register-email")
    WebElement emailFieldId;
    @FindBy(id = "register-password")
    WebElement passwordFieldId;
    @FindBy(id = "register-confirmPassword")
    WebElement confirmPasswordID;
    @FindBy(id = "register-group")
    WebElement groupId;
    @FindBy(id = "register-submit")
    WebElement registerButtonId;


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(LoginButtonXpath));
        LoginButtonXpath.click();
    }

    public void clickSignupToggle() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(signupToggleId));
        signupToggleId.click();
    }

    public void enterFirstName(String firstName)    {
        firstNameFieldId.sendKeys(firstName);
    }

    public void enterLastName(String lastName)    {
        lastNameFieldId.sendKeys(lastName);
    }

    public void enterEmail(String newlyRegisteredEmail)    {
        emailFieldId.sendKeys(newlyRegisteredEmail);
    }

    public void enterPassword(String newlyRegisteredPassword)    {
        passwordFieldId.sendKeys(newlyRegisteredPassword);
    }

    public void enterConfirmPassword(String confirmPassword)    {
        confirmPasswordID.sendKeys(confirmPassword);
    }

    public void dropDownMenuGroup() {
        WebElement dropdown = driver.findElement(By.id("register-group"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Group T (2026)");
    }

    public void clickCreateAccountBTN() {
        registerButtonId.click();
    }

    public void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

}
