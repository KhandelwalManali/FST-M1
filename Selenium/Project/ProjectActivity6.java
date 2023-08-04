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

import java.util.List;

public class ProjectActivity6 {
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
    public void menuCheck() throws InterruptedException {
        //Enter Login Credentials
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        Thread.sleep(1000);
        driver.findElements(By.id("toolbar"));
        String activitiesLink = driver.findElement(By.xpath("//a[text() = 'Activities']")).getText();
        System.out.println("Activity Link is: " + activitiesLink);

        Assert.assertEquals("ACTIVITIES",activitiesLink );
        System.out.println("Activities menu item exists.");
    }

    @AfterMethod
    public void afterMethod() {
        //Close browser
        driver.quit();
    }

}

