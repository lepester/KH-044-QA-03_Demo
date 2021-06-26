package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchResultsProducts extends BasePage{

    @FindBy(css = ".catalog-settings__sorting")
    private WebElement sort;
    @FindBy(css = ".promo-label_type_novelty")
    private WebElement novelty;
    @FindBy(css = ".promo-label_type_popularity")
    private WebElement popularity;
    @FindBy(css = ".promo-label_type_action")
    private WebElement action;
    @FindBy(xpath = "//span[@class='goods-tile__price-value']")
    private List<WebElement> pricesList;
    @FindBy(xpath = "//input[@formcontrolname = 'min']")
    private WebElement minPrice;
    @FindBy(xpath = "//input[@formcontrolname = 'max']")
    private WebElement maxPrice;
    @FindBy(css = ".button.slider-filter__button")
    private WebElement buttonPriceOk;
    @FindBy(css = "div.layout_with_sidebar")
    private WebElement resultsGrid;

    public SearchResultsProducts(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchResultsProducts openPage(){
        driver.get("http://surl.li/xyto");
        return this;
    }

    public void settingsSort(String value){
        sort.click();
        WebElement listBox = driver.findElement(By.xpath("//select"));
        Select select = new Select(listBox);
        try {
            select.selectByValue(value);
        }
        catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
    }
    public int[] getPrices() {
        redrawnWaiter(pricesList.get(0));
        String[] str = new String[10];
        int size = str.length;
        for(int i = 0;i<size;i++){
            str[i] = pricesList.get(i).getText().replace(" ", "");
        }
        int[] pricesArr = new int [size];
        for(int i =0; i<size; i++){
            pricesArr[i] = Integer.parseInt(str[i]);
        }
        return pricesArr;
    }
    public void inputFields(String min, String max){
        minPrice.clear();
        minPrice.sendKeys(min);
        maxPrice.clear();
        maxPrice.sendKeys(max);
    }
    public WebElement getNovelty(){
        return novelty;
    }

    public WebElement getPopularity(){
        return popularity;
    }

    public WebElement getAction(){
        return action;
    }

    public WebElement getButtonPriceOk(){
        return buttonPriceOk;
    }
    public SearchResultsProducts chooseSellerFilter(String []filtersArray) {
        try {
            for (String moreFilter : filtersArray) {
                WebElement checkBox = driver.findElement(By.xpath("//label[@for='" + moreFilter + "']"));
                clickableWaiter(checkBox);
                checkBox.click();
                resultsGrid.isDisplayed();
            }
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
        return this;
    }
}