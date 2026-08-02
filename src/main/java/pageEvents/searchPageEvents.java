package pageEvents;

import base.BaseTest;
import pageObjects.searchPageElements;

public class searchPageEvents extends BaseTest {

    public void enterSearchTerm(String stepName, String searchTerm) {
        logger.info(stepName);
        clear(searchPageElements.txtSearchProduct);
        sendKeys(searchPageElements.txtSearchProduct, searchTerm);
    }

    public void clickSearchButton(String stepName) {
        logger.info(stepName);
        click(searchPageElements.btnSearchProduct);
    }

    public void verifySearchedProductsVisible(String stepName) {
        logger.info(stepName);
        assertElementIsDisplayed(searchPageElements.lblSearchedProducts);
    }

    public void addFirstVisibleProductToCart(String stepName) {
        logger.info(stepName);
        click(searchPageElements.addToCartButtons);
    }

    public void clickCartLink(String stepName) {
        logger.info(stepName);
        click(searchPageElements.cartLink);
    }

    public void verifyCartPageVisible(String stepName) {
        logger.info(stepName);
        assertElementIsDisplayed(searchPageElements.cartPageHeader);
    }

    public void verifyCartItemsVisible(String stepName) {
        logger.info(stepName);
        assertElementIsDisplayed(searchPageElements.cartItemRow);
    }
}
