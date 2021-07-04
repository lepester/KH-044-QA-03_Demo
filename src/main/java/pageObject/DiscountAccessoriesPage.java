package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiscountAccessoriesPage extends BasePage {
    @FindBy(css = "h1.catalog-heading")
    WebElement titleOfPage;

    protected DiscountAccessoriesPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {

        String title = titleOfPage.getText();
        return title;
    }
}
