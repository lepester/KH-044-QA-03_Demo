package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaMainPage extends BasePage {

    @FindBy(css = "button.header__button")
    private WebElement buttonSupport;
    @FindBy(css = "a.button.button--large.side-menu__button")
    private WebElement helpCenter;

    public RozetkaMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RozetkaDisplaysPage openHelper() {
        buttonSupport.click();
        helpCenter.click();
        return new RozetkaDisplaysPage(driver);
    }
}
