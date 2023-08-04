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

public class ProjectActivity3 {
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
    public void getCopyrightText() {
        //Get the image WebElement
        WebElement copyrightText = driver.findElement(By.xpath("//a[contains(text(), 'Supercharged')]"));

        //Print the image URL to the console
        System.out.println("First copyright text in the footer: " + copyrightText.getText());

        //Check if the copyright text in the footer matches
        Assert.assertEquals(copyrightText.getText(), "© Supercharged by SuiteCRM");
    }

    @AfterMethod
    public void afterMethod() {
        //Close browser
        driver.quit();
    }

}
