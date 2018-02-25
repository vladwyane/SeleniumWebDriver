import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class ChromeTest {

    private WebDriver driver;
    private WebDriverWait wait;



    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 3);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://automationpractice.com");
        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.name("submit_search")).click();
        assert driver.findElements(By.cssSelector("li.ajax_block_product")).size() == 7;

    }

}
