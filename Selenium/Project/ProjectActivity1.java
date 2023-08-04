package ProjectActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProjectActivity1 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void titleCheck() {
        System.out.println("The title of the Website is:" + driver.getTitle());

        //Check if the title matches
        Assert.assertEquals(driver.getTitle(), "SuiteCRM");
    }

    @AfterMethod
    public void afterMethod(){
        //close the browser
        driver.quit();
    }

}
