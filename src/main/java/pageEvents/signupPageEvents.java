package pageEvents;

import java.util.Dictionary;
import java.util.Random;

import base.BaseTest;
import pageObjects.signupPageElements;

public class signupPageEvents extends BaseTest {

    Random random = new Random();

    public void enterAccountInformation(@SuppressWarnings("rawtypes") Dictionary signupDetails) {
        // Select Title
        logger.info("9. Fill details: Title, Name,  Email, Password, Date of birth");
        int randomTitle = random.nextInt(2);

        switch (randomTitle) {
            case 0:
                click(signupPageElements.mr);
                break;
            case 1:
                click(signupPageElements.ms);
                break;
            default:
                click(signupPageElements.mr);
                break;
        }

        //Skip name and email address since it's automatically filled up
        // Enter Password
        clear(signupPageElements.txtPassword);
        sendKeys(signupPageElements.txtPassword, signupDetails.get("password").toString());

        //Date of Birth
        selectElementByVisibleText(signupPageElements.slcDay, "4");
        selectElementByVisibleText(signupPageElements.slcMonth, "August");
        selectElementByVisibleText(signupPageElements.slcYear, "1999");

        logger.info("10. Select checkbox 'Sign up for our newsletter!'");
        click(signupPageElements.chkNewsLetter);

        logger.info("11. Select checkbox 'Receive special offers from our partners!'");
        click(signupPageElements.chkSpecialOffer);

        logger.info("12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
        clear(signupPageElements.txtFirstName);
        sendKeys(signupPageElements.txtFirstName, signupDetails.get("firstName").toString());

        clear(signupPageElements.txtLastName);
        sendKeys(signupPageElements.txtLastName, signupDetails.get("lastName").toString());

        clear(signupPageElements.txtCompany);
        sendKeys(signupPageElements.txtCompany, signupDetails.get("company").toString());

        clear(signupPageElements.txtAddress);
        sendKeys(signupPageElements.txtAddress, signupDetails.get("address").toString());

        selectElementByVisibleText(signupPageElements.slcCountry, "United States");

        clear(signupPageElements.txtState);
        sendKeys(signupPageElements.txtState, signupDetails.get("state").toString());

        clear(signupPageElements.txtCity);
        sendKeys(signupPageElements.txtCity, signupDetails.get("city").toString());

        clear(signupPageElements.txtZipCode);
        sendKeys(signupPageElements.txtZipCode, signupDetails.get("zipCode").toString());

        clear(signupPageElements.txtMobileNo);
        sendKeys(signupPageElements.txtMobileNo, signupDetails.get("mobileNo").toString());

        // Click Create Account button
        logger.info("13. Click 'Create Account button'");
        click(signupPageElements.btnCreateAccount);

    }

    
}
