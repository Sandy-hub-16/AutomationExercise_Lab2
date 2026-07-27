package pageEvents;

import java.util.Dictionary;

import base.BaseTest;


public class registerPageEvents extends BaseTest{

    loginPageEvents loginPage = new loginPageEvents();


    public void register(@SuppressWarnings("rawtypes") Dictionary registerDetails){


       
        // loginPage.clickRegisterTab();
        
        // //Fill Up Contact Information
        // logger.info("Fill Up Contact Information");
        // clear(registerPageElements.txtFirstName);
        // sendKeys(registerPageElements.txtFirstName, registerDetails.get("firstName").toString());

        // clear(registerPageElements.txtLastName);
        // sendKeys(registerPageElements.txtLastName, registerDetails.get("lastName").toString());

        // clear(registerPageElements.txtPhone);
        // sendKeys(registerPageElements.txtPhone, registerDetails.get("phone").toString());

        // clear(registerPageElements.txtEmail);
        // sendKeys(registerPageElements.txtEmail, registerDetails.get("email").toString());

        // //Mailing Information
        // logger.info("Fill Up Mailing Information");
        // clear(registerPageElements.txtAddress);
        // sendKeys(registerPageElements.txtAddress, registerDetails.get("address").toString());

        // clear(registerPageElements.txtCity);
        // sendKeys(registerPageElements.txtCity, registerDetails.get("city").toString());

        // clear(registerPageElements.txtStateProvince);
        // sendKeys(registerPageElements.txtStateProvince, registerDetails.get("state").toString());

        // clear(registerPageElements.txtPostalCode);
        // sendKeys(registerPageElements.txtPostalCode, registerDetails.get("postalCode").toString());

        // //User Information
        // logger.info("Fill Up User Information");
        // clear(registerPageElements.txtUsername);
        // sendKeys(registerPageElements.txtUsername, registerDetails.get("userName").toString());

        // clear(registerPageElements.txtPassword);
        // sendKeys(registerPageElements.txtPassword, registerDetails.get("password").toString());

        // clear(registerPageElements.txtConfirmPassword);
        // sendKeys(registerPageElements.txtConfirmPassword, registerDetails.get("password").toString());

        // //Click Submit
        // logger.info("Click Submit button");
        // click(registerPageElements.btnSubmit);

    }

    public void validateUserRegister(@SuppressWarnings("rawtypes") Dictionary registerDetails){
        
        String userNameLocator = "//b[normalize-space()='Note: Your user name is "+registerDetails.get("userName")+".']";
        assertElementIsDisplayed(userNameLocator);
    }
    

    
}
