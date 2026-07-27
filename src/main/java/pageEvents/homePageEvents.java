package pageEvents;

import base.BaseTest;
import pageObjects.homePageElements;

public class homePageEvents extends BaseTest {

    public void navigateToSignUpOrLogin() {
        // 4. Click on 'Signup / Login' button
        logger.info("4. Click on 'Signup / Login' button");
        click(homePageElements.btnSignUpOrLogin);
    }



    public void verifyHomePageVisibility(){
        
        logger.info("3. Verify that home page is visible successfully");
        String homePageLocator = "//body";
        assertElementIsDisplayed(homePageLocator);
    }
}
