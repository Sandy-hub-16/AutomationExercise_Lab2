package pageEvents;
import java.util.Dictionary;

import base.BaseTest;
import pageObjects.loginPageElements;

public class loginPageEvents extends BaseTest{

    public void clickRegisterTab(){
        // logger.info("Click Register tab");
        // click(loginPageElements.tabRegister);

    }

    public void login(@SuppressWarnings("rawtypes") Dictionary registerDetails){
        //Fill Up Username and Password
        // logger.info("Fill up Username and password");
        // clear(loginPageElements.txtUsername);
        // sendKeys(loginPageElements.txtUsername, registerDetails.get("userName").toString());

        // clear(loginPageElements.txtPassword);
        // sendKeys(loginPageElements.txtPassword, registerDetails.get("password").toString());

        // //Click Submit button
        // click(loginPageElements.btnSubmit);

    }

    public void validateSuccessfullLogin(){
        // logger.info("Validate User successfully login");
        // assertElementIsDisplayed(loginPageElements.hdrLoginSuccessfully);

    }
    
}
