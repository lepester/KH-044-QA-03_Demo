package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchResultsPage extends BasePage {

    @FindBy(css = ".catalog-settings__sorting")
    private WebElement sort;
    @FindBy(css = ".goods-tile__picture.ng-star-inserted")
    private WebElement goods;
    @FindBy(xpath = "//select")
    private WebElement dropDownList;

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
}