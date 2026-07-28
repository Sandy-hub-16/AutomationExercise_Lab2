package pageEvents;

import base.BaseTest;
import pageObjects.homePageElements;

public class homePageEvents extends BaseTest {

    public void navigateToSignUpOrLogin() {
        // 4. Click on 'Signup / Login' button
        logger.info("4. Click on 'Signup / Login' button");
        click(homePageElements.btnSignUpOrLogin);
    }


    public void clickDeleteAccountTab(String number){
        logger.info(number+". Click 'Delete Account' button");
        click(homePageElements.tabDeleteAccount);
    }

    public void clickLogoutTab(String number){
        logger.info(number+". Click 'Logout' button");
        click(homePageElements.tabLogout);
    }

}
