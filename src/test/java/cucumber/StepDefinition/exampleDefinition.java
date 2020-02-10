package cucumber.StepDefinition;

import cucumber.Page.ExamplePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class exampleDefinition {
    private String URL_GOOGLE = "http://www.google.com";
    private WebDriver driver;
    ExamplePage examplePage;
    public exampleDefinition(){
        driver= Hooks.driver;
    }

    @Given("i am on google search page")
    public void i_am_on_google_search_page() {
        driver.get(URL_GOOGLE);
        examplePage = new ExamplePage(driver);
    }

    @When("i search for {string}")
    public void i_search_for(String string) {
        examplePage.setInputQ(string);
        examplePage.submitInputQ();
        Assert.assertTrue(false);
    }

    @Then("the tittle have to contain {string}")
    public void the_tittle_have_to_contain(String string) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(driver.getTitle().contains(string));
    }
}
