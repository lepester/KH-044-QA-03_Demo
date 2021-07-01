package testClasses;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class Listener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();

        if(driver != null) {
            try {
                byte[] scrByte = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String path = result.getName() + "[" + LocalDate.now() + "][" + System.currentTimeMillis() + "].png";
                try (FileOutputStream stream = new FileOutputStream(path)) {
                    stream.write(scrByte);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
