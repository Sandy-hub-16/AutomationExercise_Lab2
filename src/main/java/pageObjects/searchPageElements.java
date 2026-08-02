package pageObjects;

public interface searchPageElements {

    String txtSearchProduct = "//input[@id='search_product' and @placeholder='Search Product']";
    String btnSearchProduct = "//button[@id='submit_search']";
    String lblSearchedProducts = "//h2[@class='title text-center' and contains(normalize-space(),'Searched Products')]";
    String addToCartButtons = "//a[contains(@class,'add-to-cart') and normalize-space()='Add to cart']";
    String cartLink = "//a[@href='/view_cart']";
    String cartItemRow = "//table[contains(@class,'table')]/tbody/tr";
    String cartPageHeader = "//b[normalize-space()='Shopping Cart']";
}
