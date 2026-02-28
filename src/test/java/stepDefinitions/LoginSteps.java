package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import utils.Base;

public class LoginSteps extends Base {

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage.clickNavLoginButton();

    }

    @When("I enter valid username {}")
    public void i_enter_valid_username(String username) {
        loginPage.enterUsername(username);
    }

    @And("I enter valid password {}")
    public void i_enter_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        String actualValue = loginPage.getLoginSuccessMessage();
        System.out.println("Actual login success message: " + actualValue);
        String expectedValue = "Welcome back, tp! \uD83D\uDC4B";
        Assert.assertEquals(actualValue, expectedValue, "Expected message: " + expectedValue + ", but got: " + actualValue);
    }
}
