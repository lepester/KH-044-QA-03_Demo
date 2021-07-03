package testClasses;

import io.qameta.allure.Attachment;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();

        if (driver != null) {
            try {
                byte[] srcByte = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                saveScreenshot(srcByte);
                String path = result.getName() + "[" + LocalDate.now() + "][" + System.currentTimeMillis() + "].png";
                try(FileOutputStream stream = new FileOutputStream(path)) {
                    stream.write(srcByte);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}