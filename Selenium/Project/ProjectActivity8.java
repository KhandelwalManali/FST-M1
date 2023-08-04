package ProjectActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class ProjectActivity8 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

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
        driver.findElement(By.xpath("//a[text() = 'Sales']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text() = 'Accounts']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Accounts')]")));
        String value;
        for(int i=1; i<11; i+=2){
            value = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[@field = 'name']")).getText();
            System.out.println(value);
        }
    }

    @AfterMethod
    public void afterMethod() {
        //Close browser
        driver.quit();
    }

}
