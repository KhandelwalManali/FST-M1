package ProjectActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectActivity2 {
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
    public void headerImageURL() {
        //Get the image WebElement
        WebElement image = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));

        //Print the image URL to the console
        System.out.println("URL of the header Image: "+image.getAttribute("src"));

        //Check if the Header image URL matches
        Assert.assertEquals(image.getAttribute("src"), "https://alchemy.hguy.co/crm/themes/default/images/company_logo.png?v=cK7kLsY0ftg72ZVHTYUT_g");
    }

    @AfterMethod
    public void afterMethod() {
        //Close browser
        driver.quit();
    }

}

