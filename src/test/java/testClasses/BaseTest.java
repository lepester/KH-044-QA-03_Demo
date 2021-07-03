package testClasses;

import factoryEx.DriverManager;
import factoryEx.DriverManagerFactory;
import factoryEx.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(ListenerTest.class)
public class BaseTest {
    protected final String url = "https://rozetka.com.ua/";
    protected WebDriver driver;
    protected DriverManager driverManager;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverType type = DriverType.valueOf(System.getenv("browser").toUpperCase());
        driverManager = DriverManagerFactory.getDriver(type);
        driver = driverManager.getDriver();
    }

    @BeforeMethod(alwaysRun = true, dependsOnMethods = {"setUp"})
    public void openPage() {
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driverManager.quiteDriver();
    }
}