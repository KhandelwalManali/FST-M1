package Project;

import io.appium.java_client.AppiumBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import java.util.ArrayList;
import java.util.List;


public class Project1 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    @Test
    public void addTaskTest() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Create new task")));

        List<String> tasklist = new ArrayList<>();
        tasklist.add("Complete Activity with Google Tasks");
        tasklist.add("Complete Activity with Google Keep");
        tasklist.add("Complete the second Activity Google Keep");

        for(int i = 0; i<tasklist.size(); i++){
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Create new task")));
            driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text='New task']")));
            driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(tasklist.get(i));
            System.out.println(driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).getText());
            driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        }

        // Assertion of the above three tasks

        List<WebElement> tasks = driver.findElements(AppiumBy.id("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name']"));
        for (WebElement taskName : tasks) {
            System.out.println("Tasks Added - "+taskName.getText());
        }

       /* String result1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name']")).getText();
        System.out.println(result1);
        Assert.assertEquals(result1, "Complete the second Activity Google Keep");

        String result2 = driver.findElement(AppiumBy.AndroidUIAutomator("text(\"Complete Activity with Google Keep\")")).getText();
        System.out.println(result2);
        Assert.assertEquals(result2, "Complete Activity with Google Keep");

        String result3 = driver.findElement(AppiumBy.AndroidUIAutomator("text(\"Complete the second Activity Google Keep\")")).getText();
        System.out.println(result3);
        Assert.assertEquals(result3, "Complete the second Activity Google Keep");*/
    }



    @AfterClass
    public void tearDown() {
        //Close the app
        driver.quit();
    }
}
