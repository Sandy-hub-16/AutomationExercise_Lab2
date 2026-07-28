package pageEvents;

import base.BaseTest;
import pageObjects.productPageElements;

public class productPageEvents extends BaseTest {
    
    public void clickViewProductButton() {
        clickTab("7. Click on 'View Product' of first product", productPageElements.btnViewProduct);
    }

    public void verifyDetailVisibility() {
        String productNameLocator = "//h2[normalize-space()='Blue Top']";
        String categoryLocator = "//p[normalize-space()='Category: Women > Tops']";
        String priceLocator = "//span[normalize-space()='Rs. 500']";
        String availabilityLocator = "//b[normalize-space()='Availability:']";
        String conditionLocator = "//b[normalize-space()='Condition:']";
        String brandLocator = "//b[normalize-space()='Brand:']";
		logger.info("9. Verify that detail detail is visible: product name, category, price, availability, condition, brand");
		assertElementIsDisplayed(productNameLocator);
        assertElementIsDisplayed(categoryLocator);
        assertElementIsDisplayed(priceLocator);
        assertElementIsDisplayed(availabilityLocator);
        assertElementIsDisplayed(conditionLocator);
        assertElementIsDisplayed(brandLocator);
	}
}
