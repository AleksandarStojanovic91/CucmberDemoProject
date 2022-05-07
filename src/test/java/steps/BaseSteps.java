package steps;

import org.openqa.selenium.WebDriver;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.util.concurrent.TimeUnit;

public class BaseSteps {

    WebDriver driver;
    DriverManager driverManager;

    public void baseSetup(String browser, String version, int wait){
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getWebDriver(version);
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
    }

    public void baseTearDown(){
        driverManager.quit();
    }

}
