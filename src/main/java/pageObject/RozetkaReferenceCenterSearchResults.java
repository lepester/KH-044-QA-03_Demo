package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class RozetkaReferenceCenterSearchResults extends BasePage{
    @FindBy(css = ".search-result-description em")
    List<WebElement> referenceResult;

    public RozetkaReferenceCenterSearchResults(WebDriver driver) {
        super(driver);
    }

    public boolean getReferenceSearchResult(String query) {
        boolean result = referenceResult.stream()
                .map(element -> element.getText())
                .anyMatch(query::equals);
        return result;
    }
}
