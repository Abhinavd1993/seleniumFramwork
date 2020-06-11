package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SearchResultPage;

public class SearchProductTest extends TestBase {
    HomePage homePage;
    SearchPage searchPage;
    SearchResultPage searchResultPage;
    ProductDetailsPage productDetailsPage;

    String product = "Apple MacBook Pro 13-inch";

    @Test
    public void UserCanSearchProduct() {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        searchResultPage = new SearchResultPage(driver);
        homePage.openHomePage();
        searchPage.searchProduct(product);
        searchResultPage.openProductPageDetails();
        Assert.assertTrue(productDetailsPage.currentProduct.getText().contains(product));
    }
}
