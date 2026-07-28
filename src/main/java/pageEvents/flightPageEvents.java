package pageEvents;

import java.util.Random;

import base.BaseTest;
import pageObjects.flightPageElements;

public class flightPageEvents extends BaseTest{

    Random rnd = new Random();
    loginPageEvents loginPage = new  loginPageEvents();

    public void reserveFlight(){
        // loginPage.clickFlightButton();

        //Selection of Flight
        logger.info("Select a random Flight Type");
        int rndFlightType = rnd.nextInt(2);

        switch (rndFlightType) {
            case 0:
                click(flightPageElements.rdnRoundTrip);
                break;

            case 1:
                click(flightPageElements.rdnOneWay);
                break;
        
            default:
                click(flightPageElements.rdnRoundTrip);
                break;
        }

        //Selection of Passenger
        logger.info("Select numbers of passenger");
        selectElementByVisibleText(flightPageElements.slcPassenger, "4");

        //Click Continue button
        logger.info("Click Continue button");
        click(flightPageElements.btnContinue);

        logger.info("Validate Back to Home button is displayed");
        assertElementIsDisplayed(flightPageElements.btnBackToHome);

    }
    
}
