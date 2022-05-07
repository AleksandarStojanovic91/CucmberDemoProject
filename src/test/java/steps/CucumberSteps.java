package steps;

import excel_core.GetExcelData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.IOException;
import java.util.Map;

public class CucumberSteps extends BaseSteps{

    final String BROWSER = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER");
    final String BROWSER_VERSION = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER_VERSION");
    final String WAIT = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WAIT");

    Map<String, String> data;

    @Before
    public void cucumberBefore(){
        baseSetup(BROWSER,BROWSER_VERSION,Integer.parseInt(WAIT));
    }

    @After
    public void cucumberAfter(){
        baseTearDown();
    }

    @Given("a user is on google web page")
    public void aUserIsOnGoogleWebPage() {
        driver.get("http://www.google.com");
    }

    @When("a user types in hello in search filed")
    public void aUserTypesInHelloInSearchFiled() {
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("hello");
    }

    @And("presses search button")
    public void pressesSearchButton() {
        driver.findElement(By.cssSelector("[name='btnK']")).click();
    }

    @Then("search result page should be shown")
    public void searchResultPageShouldBeShown() {
        Assert.assertTrue(driver.getCurrentUrl().contains("search?q=hello"));
    }

    @When("a user types in {string} in search filed")
    public void aUserTypesInInSearchFiled(String searchItem) {
        driver.findElement(By.cssSelector("[name='q']")).sendKeys(searchItem);
    }

    @Then("search result page should be shown {string}")
    public void searchResultPageShouldBeShown(String result) {
        Assert.assertTrue(driver.getCurrentUrl().contains("search?q="+result));
    }

    @Given("I read test data from {string} {string} {string}")
    public void iReadTestDataFrom(String file, String sheet, String id) throws IOException {
        data = new GetExcelData().getRowDataByID(file,sheet,id, "1",false);
    }

    @Given("I add {string} to {string}")
    public void iAddTo(String value, String key) {
        if(data.containsKey(key)) {
            data.replace(key, value);
        }else {
            data.put(key,value);
        }
    }
}