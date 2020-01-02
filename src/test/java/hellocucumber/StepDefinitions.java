package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StepDefinitions {

    private static WebDriver driver = null;

    @Given("User open browser")
    public void openBrowser(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
    }

    @Given("the customer access the {string}")
    public void navigateToHomePage(String url) {
        driver.navigate().to(url);
    }

    @Then("I should see the search bar")
    public void shouldSeeSearchBar() {
        WebElement contentDiv = driver.findElement(By.id("search-input"));
        Assert.assertTrue("The search bar was expected to be displayed, but it was not."
                , contentDiv.isDisplayed());
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
