package testClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite(alwaysRun = true)
    public void setProps() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {

        driver.quit();
    }
}
