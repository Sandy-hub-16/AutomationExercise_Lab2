package pageEvents;

import base.BaseTest;
import pageObjects.homePageElements;

public class homePageEvents extends BaseTest {

    public void navigateToSignUpOrLogin() {
        // 4. Click on 'Signup / Login' button
        logger.info("4. Click on 'Signup / Login' button");
        click(homePageElements.btnSignUpOrLogin);
    }

    public void verifyHomePageVisibility() {

        logger.info("3. Verify that home page is visible successfully");
        String homePageLocator = "//body";
        assertElementIsDisplayed(homePageLocator);
    }

    public void verifyLoggedInAsUsernameTabVisibility() {
        logger.info("16. Verify that logged in as username is visible");
        String locator = "//a[contains(normalize-space(), 'Logged in as')]";
        assertElementIsDisplayed(locator);
    }

    public void clickDeleteAccountTab(){
        logger.info("17. Click 'Delete Account' button");
        click(homePageElements.tabDeleteAccount);

    }

}
