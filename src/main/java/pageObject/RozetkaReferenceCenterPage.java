package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RozetkaReferenceCenterPage extends BasePage{
    @FindBy(css = "input#query")
    WebElement inputSupport;
    @FindBy(name = "commit")
    WebElement buttonSearchSupport;

    public RozetkaReferenceCenterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Search for reference to get help")
    public RozetkaReferenceCenterSearchResults searchForReference(String query) {
        inputSupport.clear();
        inputSupport.sendKeys(query);
        buttonSearchSupport.click();
        return new RozetkaReferenceCenterSearchResults(driver);
    }
}
