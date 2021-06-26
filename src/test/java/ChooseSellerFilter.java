import org.testng.annotations.Test;
import pageObject.SearchResultsProducts;

public class ChooseSellerFilter extends BaseTest{

    @Test
    public void sellerFilterTest(){
        String[] moreFilters = new String[]{"Rozetka", "Другие продавцы"};
        SearchResultsProducts searchResultsProducts = new SearchResultsProducts(driver);
        searchResultsProducts
                .openPage()
                .chooseSellerFilter(moreFilters);
    }
}
