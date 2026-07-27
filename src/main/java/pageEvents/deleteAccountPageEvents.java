package pageEvents;

import base.BaseTest;
import pageObjects.deleteAccountPageElements;

public class deleteAccountPageEvents extends BaseTest {

    public void verifyAccountDeletedTextVisibility() {
        logger.info("18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
        String accountDeletedTextLocator = "//b[normalize-space()='Account Deleted!']";
        assertElementIsDisplayed(accountDeletedTextLocator);
    }

    public void clickContinueButton() {
        click(deleteAccountPageElements.btnContinue);
    }
    
}
