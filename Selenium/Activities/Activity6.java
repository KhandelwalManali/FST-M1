package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity6 {

    public static void main(String[] args) {
        //Install Firefox
        WebDriverManager.firefoxdriver().setup();

        //Initialise firefox driver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);

        // Open the page
        driver.get("https://www.training-support.net/selenium/input-events");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Press the key
        builder.sendKeys("M").build().perform();
        // Press CTRL+A and CTRL+C
        builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        // Close the browser
        driver.close();
    }
}
