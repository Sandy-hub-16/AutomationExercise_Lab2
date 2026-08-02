package pageObjects;

public interface homePageElements {

    // 'Signup / Login' button
    String btnSignUpOrLogin = "//a[normalize-space()='Signup / Login']";

    // Tabs
    String tabDeleteAccount = "//a[normalize-space()='Delete Account']";
    String tabLogout = "//a[normalize-space()='Logout']";
    String tabContactUs = "//a[normalize-space()='Contact us']";
    String tabTestCases = "//a[contains(text(),'Test Cases')]";
    String tabProducts = "//a[@href='/products']";

    // Category sidebar
    String sidebarCategories = "//div[contains(@class,'left-sidebar')]";
    String tabWomenCategory = "//a[normalize-space()='Women']";
    String linkWomenTops = "//a[normalize-space()='Tops' and contains(@href,'/category_products/2')]";
    String tabMenCategory = "//a[normalize-space()='Men']";
    String linkMenTshirts = "//a[normalize-space()='Tshirts' and contains(@href,'/category_products/3')]";

    // Brand sidebar
    String sidebarBrands = "//h2[normalize-space()='Brands']";
    String brandPolo = "//a[normalize-space()='Polo']";
    String brandHM = "//a[normalize-space()='H&M']";
    String brandPageHeader = "//h2[contains(normalize-space(), 'Brand -')]";
    String brandProductsList = "//div[contains(@class,'features_items')]";

    // Recommended items section
    String recommendedItemsHeader = "//div[@class='recommended_items']//h2[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'recommended items')]";
    String btnFirstRecommendedAddToCart = "(//div[@class='recommended_items']//a[normalize-space()='Add to cart'])[1]";

} 
