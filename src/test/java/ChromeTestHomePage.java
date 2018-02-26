import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class ChromeTestHomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage = new HomePage();

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
        driver.get(homePage.url);
        WebElement inputSearch = driver.findElement(homePage.inputSearch);
        inputSearch.sendKeys("dress");
        WebElement searchButton = driver.findElement(homePage.searchButton);
        searchButton.click();
        assert driver.findElements(By.cssSelector("span.discount")).size() == 7;

    }

}
