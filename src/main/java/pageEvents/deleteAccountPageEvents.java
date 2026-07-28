package pageEvents;

import base.BaseTest;
import pageObjects.deleteAccountPageElements;

public class deleteAccountPageEvents extends BaseTest {


    public void clickContinueButton() {
        dismissPopupIfPresent();
        click(deleteAccountPageElements.btnContinue);
    }
    
}
