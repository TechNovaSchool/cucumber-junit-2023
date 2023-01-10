package step_def;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginSBPage;
import pages.WebOrdersSBPage;
import utils.Config;
import utils.Driver;

public class SmartBearSteps {

    LoginSBPage loginSBPage = new LoginSBPage();
    WebOrdersSBPage webOrdersSBPage = new WebOrdersSBPage();
    Faker faker = new Faker();

    @When("User is on SmartBear login page")
    public void user_is_on_smart_bear_login_page() {
        Driver.getDriver().get(Config.getProperty("urlSmartBear"));
    }
    @When("User enters correct  username2")
    public void user_enters_correct_username2() {
    loginSBPage.usernameInput.sendKeys(Config.getProperty("username"));
    }
    @When("User enters correct password")
    public void user_enters_correct_password() {
    loginSBPage.passwordInput.sendKeys(Config.getProperty("pass"));
    }
    @When("User clicks to login button")
    public void user_clicks_to_login_button() {
    loginSBPage.loginBtn.click();
    }
    @Then("User should be logged in and be able to verify Welcome text is displayed")
    public void user_should_be_logged_in_and_be_able_to_verify_welcome_text_is_displayed() {
        Assert.assertTrue(webOrdersSBPage.getWelcomeMsg.isDisplayed());
    }

    @When("User enters incorrect password")
    public void user_enters_incorrect_password() {
    loginSBPage.passwordInput.sendKeys(faker.internet().password());
    }

    @Then("User should see the error message displayed on the page")
    public void user_should_see_the_error_message_displayed_on_the_page() {
        Assert.assertTrue(loginSBPage.getErrorMessage.isDisplayed());
    }

}
