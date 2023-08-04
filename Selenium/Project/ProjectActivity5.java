package ProjectActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectActivity5 {
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
    public void getColor() throws InterruptedException {
        //Enter Login Credentials
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        Thread.sleep(1000);

        //Get the color of the navigation menu
        String navcolor = driver.findElement(By.xpath("//div[@id = 'toolbar']")).getCssValue("color");
        System.out.println("Color of the navigation menu: " + navcolor);

        //Check if the Color of the navigation menu matches
        Assert.assertEquals(navcolor, "rgb(83, 77, 100)");
    }

    @AfterMethod
    public void afterMethod() {
        //Close browser
        driver.quit();
    }

}

