package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaReferenceCenterPage extends BasePage{
    String query = "доставка";
    @FindBy(css = "input#query")
    WebElement inputSupport;
    @FindBy(name = "commit")
    WebElement buttonSearchSupport;

    public RozetkaReferenceCenterPage(WebDriver driver) {
        super(driver);
    }

    public RozetkaHelperCenter searchForReference() {
        inputSupport.clear();
        inputSupport.sendKeys(query);
        buttonSearchSupport.click();
        return new RozetkaHelperCenter(driver);
    }
}
