package Project;

        import io.appium.java_client.AppiumBy;

        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.android.options.UiAutomator2Options;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

        import java.net.MalformedURLException;
        import java.net.URL;
        import java.time.Duration;


public class Project2 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    @Test
    public void addTaskTest() {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("New text note")));
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/edit_note_text")));
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Desc");

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/editable_title")));
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Tit");

        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();

       /* WebElement addTask = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']"));
        WebElement saveTask = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Save']"));

        addTask.sendKeys("Complete Activity with Google Tasks");
        saveTask.click();
        addTask.sendKeys("Complete Activity with Google Keep");
        saveTask.click();
        addTask.sendKeys("Complete the second Activity Google Keep");
        saveTask.click();*/

        //Assert.assertEquals(result, "10");
    }



   /* @AfterClass
    public void tearDown() {
        //Close the app
        driver.quit();
    }*/
}

