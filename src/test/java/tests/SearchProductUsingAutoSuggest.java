package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase {
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    String product = "Apple MacBook Pro 13-inch";
    @Test
    public void UserCanSearchProductUsingAutoSuggest() {
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        searchPage.searchProductByAutoSuggest(product);
        Assert.assertTrue(productDetailsPage.currentProduct
                .getText().contains("Apple MacBook Pro 13-inch"));
    }
}
