
package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/tables");

        System.out.println("The title of the Page is:" + driver.getTitle());

        //Interactions
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
        System.out.println("Number of rows:" + rows.size());
        System.out.println("Number of columns:" + cols.size());

        WebElement row2col2 = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row Second column: " + row2col2.getText());

        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]")).click();

        WebElement rowcol2 = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("After sorting Second row Second column: " + rowcol2.getText());

        List<WebElement> footer = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));

        System.out.println("Cell values of the footer: ");
        for (WebElement foot : footer) {
            System.out.println(foot.getText());
        }

        driver.quit();
    }
}

