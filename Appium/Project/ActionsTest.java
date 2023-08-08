package examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static examples.ActionsBase.doSwipe;

public class ActionsTest {

    AppiumDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open Selenium page
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void webAppTest() {
        // Get dimensions of screen
        Dimension dims = driver.manage().window().getSize();

        //scroll to end of the pagex
        // Wait for the page to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));

        // Set start and end points
        Point start = new Point((int) (dims.width * 0.5), (int) (dims.height * 0.9));
        Point end = new Point((int) (dims.width * 0.5), (int) (dims.height * 0.6));
        // Perform swipe on slider
        doSwipe(driver, start, end, 100);

        //Find and click To-Do list
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[contains(@text,'To-Do List')]"))).click();

        //wait for the page to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));

        WebElement addTask = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));
        WebElement taskInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));

        taskInput.sendKeys("Add tasks to list");
        addTask.click();
        taskInput.sendKeys("Get number of tasks");
        addTask.click();
        taskInput.sendKeys("Clear the list");
        addTask.click();


        List<WebElement> tasks = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']//android.widget.TextView"));

        Assert.assertEquals(tasks.size(), 4);
        for (WebElement task : tasks) {
            task.click();
        }
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']")).click();

        tasks = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']//android.widget.TextView"));
        Assert.assertEquals(tasks.size(), 0);
    }

    @AfterClass
    public void afterClass() {
        // Close the browser
        driver.quit();
    }
}