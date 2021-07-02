package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaShopPage extends BasePage {

    @FindBy(css = "input.search-form__input")
    private WebElement searchFieldRozetka;
    @FindBy(css = "button.search-form__submit")
    private WebElement searchButtonSubmit;
    @FindBy(css = "button.menu__toggle")
    private WebElement catalog;
    @FindBy(xpath = "//a[@href='https://hard.rozetka.com.ua/monitors/c80089/']")
    private WebElement displaySection;
    @FindBy(css = ".main-auth__button")
    private WebElement authButton;

    public RozetkaShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Open Rozetka Shop")
    public RozetkaShopPage openPage(){
        driver.get("https://rozetka.com.ua/");
        return this;
    }

    @Step("Open Login Page")
    public LoginPage goToLoginPage(){
        clickableWaiter(authButton);
        authButton.click();
        return new LoginPage(driver);
    }
}