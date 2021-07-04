package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import org.openqa.selenium.support.ui.Select;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//a/span[contains(@class,'goods-tile__title')]")
    List<WebElement> goodsCatalog;
    @FindBy(css = ".button.slider-filter__button")
    private WebElement buttonPriceOk;
    @FindBy(xpath = "//input[@formcontrolname = 'min']")
    private WebElement minPrice;
    @FindBy(xpath = "//input[@formcontrolname = 'max']")
    private WebElement maxPrice;

    @FindBy(css = ".catalog-settings__sorting")
    private WebElement sort;
    @FindBy(css = ".goods-tile__picture.ng-star-inserted")
    private WebElement goods;
    @FindBy(xpath = "//select")
    private WebElement dropDownList;
    @FindBy(css = "div.layout_with_sidebar")
    private WebElement resultsGrid;
    @FindBy(css = ".checkbox-filter__item.ng-star-inserted")
    private WebElement sellers;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Sort products by value")
    public void sortProductsByValue(String value){
        clickableWaiter(goods);
        sort.click();
        Select select = new Select(dropDownList);
        try {
            select.selectByValue(value);
        }
        catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
    }
    @Step("Click first product for switching to its page")
    public ProductPage clickFirstProduct() {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(goodsCatalog));
        goodsCatalog.get(0).click();
        return new ProductPage(driver);
    }

    @Step("Insert the min and max prices into fields")
    public void getPricesFields(String min, String max){
        visibilityWaiter(minPrice);
        minPrice.clear();
        minPrice.sendKeys(min);
        maxPrice.clear();
        maxPrice.sendKeys(max);
    }

    public boolean isButtonPriceOkEnabled(){
        return buttonPriceOk.isEnabled();
    }
    @Step("Choose seller in filter")
    public void chooseSellerInFilter(String seller) {
        clickableWaiter(sellers);
        List<WebElement> results = driver.findElements(By.cssSelector(".checkbox-filter__item.ng-star-inserted"));
        for (WebElement checkBox : results) {
            if (checkBox.getText().contains(seller)) {
                clickableWaiter(sellers);
                checkBox.click();
                break;
            }
        }
    }
}