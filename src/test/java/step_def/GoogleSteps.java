package step_def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import utils.Driver;

import java.security.Key;

public class GoogleSteps {

    GooglePage googlePage = new GooglePage();
    @Given("I am at google home page")
    public void i_am_at_google_home_page() {
        Driver.getDriver().get("https://www.google.com");
    }
    @Then("I verify the title is Google")
    public void i_verify_the_title_is_google() {
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("I search for saucelabs")
    public void i_search_for_saucelabs() {
    googlePage.searchBar.sendKeys("saucelabs", Keys.ENTER);
    }

    @Then("I verify the title is Saucelabs")
    public void i_verify_the_title_is_saucelabs() {
        String expectedTile = "google";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTile));

    }

}
