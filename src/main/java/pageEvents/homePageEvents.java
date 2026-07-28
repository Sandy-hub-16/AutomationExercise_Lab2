package pageEvents;

import base.BaseTest;
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

}
