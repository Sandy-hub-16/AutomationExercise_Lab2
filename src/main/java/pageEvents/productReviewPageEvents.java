package pageEvents;

import base.BaseTest;
import pageObjects.productReviewPageElements;

public class productReviewPageEvents extends BaseTest {

    public void clickViewProductButton() {
        clickTab("5. Click on 'View Product' button", productReviewPageElements.btnViewProduct);
    }

    public void verifyWriteYourReviewVisible() {
        logger.info("6. Verify 'Write Your Review' is visible");
        assertElementIsDisplayed(productReviewPageElements.linkWriteYourReview);
    }

    public void enterReviewDetails(String name, String email, String reviewText) {
        logger.info("7. Enter name, email and review");
        clear(productReviewPageElements.txtReviewName);
        sendKeys(productReviewPageElements.txtReviewName, name);
        clear(productReviewPageElements.txtReviewEmail);
        sendKeys(productReviewPageElements.txtReviewEmail, email);
        clear(productReviewPageElements.txtReview);
        sendKeys(productReviewPageElements.txtReview, reviewText);
    }

    public void clickSubmitReview() {
        logger.info("8. Click 'Submit' button");
        click(productReviewPageElements.btnSubmitReview);
    }

    public void verifyReviewSuccessVisible() {
        logger.info("9. Verify success message 'Thank you for your review' is visible");
        assertElementIsDisplayed(productReviewPageElements.lblReviewSuccess);
    }
}
