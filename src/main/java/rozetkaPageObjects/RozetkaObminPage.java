package rozetkaPageObjects;

import com.google.common.base.CharMatcher;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RozetkaObminPage extends BasePage {
    Actions action;
    @FindBy(css = "div.rz-frame-wrap iframe")
    WebElement costSection;
    @FindBy(css = "span[data-select2-id='1'] span.select2-selection")
    WebElement deviceTypeSection;
    @FindBy(css = "input.select2-search__field")
    WebElement deviceSearchField;
    @FindBy(css = "span[data-select2-id='2'] span.select2-selection")
    WebElement deviceProducerSection;
    @FindBy(css = "span[data-select2-id='3'] span.select2-selection")
    WebElement deviceModelSection;
    @FindBy(css = "div.phone_cost p")
    WebElement deviceCost;
    @FindBy(xpath = "//div[contains(@class,'calc_question_power')]//label[contains(@class,'calc_question_label')][input[@value='1']]")
    WebElement deviceIsTurnedOnButton;
    @FindBy(xpath = "//div[contains(@class,'calc_question_screen')]//label[contains(@class,'calc_question_label')][input[@value='1']]")
    WebElement deviceScreenWorksButton;
    @FindBy(xpath = "//div[contains(@class,'alc_question_function')]//label[contains(@class,'calc_question_label')][input[@value='1']]")
    WebElement deviceAllFunctionsWorkButton;
    @FindBy(xpath = "//input[@name='screen_state' and @value='A']/../p")
    WebElement deviceWithScreenWithoutScratches;
    @FindBy(xpath = "//input[@name='cover_state' and @value='A']/../p")
    WebElement deviceWithCoverWithoutScratches;


    public RozetkaObminPage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }

    public void inputDeviceCharacteristic(String deviceType) {
        deviceSearchField.clear();
        deviceSearchField.sendKeys(deviceType);
        deviceSearchField.sendKeys(Keys.ENTER);
    }

    public RozetkaObminPage inputDeviceType(String deviceType) {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(costSection));
        driver.switchTo().frame(costSection);
        action.moveToElement(deviceTypeSection).build().perform();
        deviceTypeSection.click();
        inputDeviceCharacteristic(deviceType);
        return new RozetkaObminPage(driver);
    }

    public RozetkaObminPage inputDeviceProducer(String deviceProducer) {
        action.moveToElement(deviceProducerSection).build().perform();
        deviceProducerSection.click();
        inputDeviceCharacteristic(deviceProducer);
        return new RozetkaObminPage(driver);
    }

    public RozetkaObminPage inputDeviceModel(String deviceModel) {
        action.moveToElement(deviceModelSection).build().perform();
        deviceModelSection.click();
        inputDeviceCharacteristic(deviceModel);
        return new RozetkaObminPage(driver);
    }

    public RozetkaObminPage chooseTurnedOnDevice() {
        action.moveToElement(deviceIsTurnedOnButton).build().perform();
        deviceIsTurnedOnButton.click();
        return new RozetkaObminPage(driver);
    }

    public RozetkaObminPage chooseDeviceAllFunctionsWork() {
        action.moveToElement(deviceAllFunctionsWorkButton).build().perform();
        deviceAllFunctionsWorkButton.click();
        return new RozetkaObminPage(driver);
    }

    public RozetkaObminPage chooseDeviceScreenWorks() {
        action.moveToElement(deviceScreenWorksButton).build().perform();
        deviceScreenWorksButton.click();
        return new RozetkaObminPage(driver);
    }

    public RozetkaObminPage chooseDeviceWithScreenWithoutScratches() {
        deviceWithScreenWithoutScratches.click();
        return new RozetkaObminPage(driver);
    }

    public RozetkaObminPage chooseDeviceWithCoverWithoutScratches() {
        deviceWithCoverWithoutScratches.click();
        return new RozetkaObminPage(driver);
    }

    public int getDeviceCost() {
        action.moveToElement(deviceCost).build().perform();
        String costDevice = deviceCost.getText().replaceAll("\\s+", "");
        costDevice = CharMatcher.DIGIT.retainFrom(costDevice);
        int cost = Integer.parseInt(costDevice);
        return cost;
    }
}
