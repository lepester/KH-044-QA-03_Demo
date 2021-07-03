package testClasses;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObject.SearchResultsPage;

public class SellerFilterTest extends BaseTest{

    @Test
    @Description("Get to the section of products and check the seller`s filter")
    public void sellerFilterTest(){
        String[] moreFilters = new String[]{"Rozetka", "Другие продавцы"};
        driver.get(rozetkaProductsPageLink);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage
                .chooseSellerFilter(moreFilters);
    }
}