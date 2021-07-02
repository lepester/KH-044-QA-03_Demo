package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RozetkaHelperCenter extends BasePage{

    public RozetkaHelperCenter(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
