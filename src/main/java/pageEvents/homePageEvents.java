package pageEvents;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import pageObjects.homePageElements;

public class homePageEvents extends BaseTest {


    public void navigateToSignUpOrLogin() {
        clickTab("4. Click on 'Signup / Login' button", homePageElements.btnSignUpOrLogin);
    }

    public void clickDeleteAccountTab(String number) {
        clickTab(number + ". Click 'Delete Account' button", homePageElements.tabDeleteAccount);
    }

    public void clickLogoutTab(String number) {
        clickTab(number + ". Click 'Logout' button", homePageElements.tabLogout);
    }

    public void clickContactUsTab(String number) {
        clickTab(number + ". Click on 'Contact Us' button", homePageElements.tabContactUs);
    }

    public void clickTestCasesTab(String number) {
        clickTab(number + ". Click on 'Test Cases' button", homePageElements.tabTestCases);
    }

    public void clickProductsTab(String number) {
        clickTab(number + ". Click on 'Products' button", homePageElements.tabProducts);
    }

    public void scrollToBottom(String stepName) {
        logger.info(stepName);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void verifyRecommendedItemsVisible() {
        logger.info("5. Verify that 'RECOMMENDED ITEMS' are visible");
        assertElementIsDisplayed(homePageElements.recommendedItemsHeader);
    }

    public void clickRecommendedItemAddToCart(String stepName) {
        click(stepName, homePageElements.btnFirstRecommendedAddToCart);
    }

    public void verifyCategoriesSidebar() {
        logger.info("3. Verify that categories are visible on left side bar");
        assertElementIsDisplayed(homePageElements.sidebarCategories);
    }

    public void verifyBrandsSidebar() {
        logger.info("4. Verify that Brands are visible on left side bar");
        assertElementIsDisplayed(homePageElements.sidebarBrands);
    }

    public void clickBrandPolo(String stepName) {
        click(stepName, homePageElements.brandPolo);
    }

    public void clickBrandHM(String stepName) {
        click(stepName, homePageElements.brandHM);
    }

    public void clickWomenCategory(String stepName) {
        click(stepName, homePageElements.tabWomenCategory);
    }

    public void clickWomenTopsSubCategory(String stepName) {
        click(stepName, homePageElements.linkWomenTops);
    }

    public void clickMenCategory(String stepName) {
        click(stepName, homePageElements.tabMenCategory);
    }

    public void clickMenTshirtsSubCategory(String stepName) {
        click(stepName, homePageElements.linkMenTshirts);
    }

    private void click(String stepName, String locator) {
        logger.info(stepName);
        click(locator);
    }

}
