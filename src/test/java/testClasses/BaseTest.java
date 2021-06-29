package testClasses;

import factortyEx.DriverManager;
import factortyEx.DriverManagerFactory;
import factortyEx.DriverType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static com.sun.deploy.cache.Cache.copyFile;

public class BaseTest {
    WebDriver driver;
    DriverManager driverManager;
    String login;
    String password;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverType type = DriverType.valueOf(System.getenv("browser").toUpperCase());
        driverManager = DriverManagerFactory.getDriver(type);
        driver = driverManager.getDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void setLoginAndPasswordForLogIn() {
        login = String.valueOf(System.getenv("login"));
        password = String.valueOf(System.getenv("password"));
    }

    @AfterMethod(alwaysRun = true)
    public void takeScreenshot(ITestResult result) {
        if (!result.isSuccess())
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                copyFile(scrFile, new File(result.getName() + "[" + LocalDate.now() + "][" + System.currentTimeMillis() + "].png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @AfterMethod(alwaysRun = true, dependsOnMethods = {"takeScreenshot"})
    public void quitBrowser() {
        driverManager.quiteDriver();
    }
}
