package rozetkaPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//a/span[contains(@class,'goods-tile__title')]")
    List<WebElement> goodsCatalog;
    @FindBy(xpath = "//span[contains(@class, 'goods-tile__price-value')]")
    List<WebElement> goodsPriceCatalog;
    @FindBy(xpath = "//aside//label[@for='Rozetka']")
    WebElement rozetkaFilter ;
    @FindBy(xpath = "//rz-sort[contains(@class, 'catalog-settings__sorting')]//select")
    WebElement sortSettings;
    @FindBy(xpath = "//select//option[contains(@value, 'cheap')]")
    WebElement ascSorting;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage filterResults() {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(goodsCatalog));
        rozetkaFilter.click();
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(goodsCatalog));
        return new SearchResultsPage(driver);
    }

    public SearchResultsPage sortPriceAsc() {
        sortSettings.click();
        ascSorting.click();
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(goodsCatalog));
        return new SearchResultsPage(driver);
    }

    public List<Double> getProductsPriceList() {
        List<Double> goodsPrice = goodsPriceCatalog.stream()
                .map(price -> Double.parseDouble(price.getText().replaceAll("\\s+", "")))
                .collect(Collectors.toList());
        return goodsPrice;
    }

    public ProductPage clickFirstProduct() {
        goodsCatalog.get(0).click();
        return new ProductPage(driver);
    }
}
