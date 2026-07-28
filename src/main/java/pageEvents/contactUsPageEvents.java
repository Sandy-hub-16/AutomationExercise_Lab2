package pageEvents;

import java.util.Dictionary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;
import pageObjects.contactUsPageElements;

public class contactUsPageEvents extends BaseTest {

    public void fillUpContactForm(@SuppressWarnings("rawtypes") Dictionary fillupDetails, String filePath) {
        logger.info("6. Enter name,  email, subject and message");
        // Enter Name
        clear(contactUsPageElements.txtName);
        sendKeys(contactUsPageElements.txtName, fillupDetails.get("name").toString());
        // Enter Email
        clear(contactUsPageElements.txtEmail);
        sendKeys(contactUsPageElements.txtEmail, fillupDetails.get("email").toString());
        // Enter Subject
        clear(contactUsPageElements.txtSubject);
        sendKeys(contactUsPageElements.txtSubject, fillupDetails.get("subject").toString());
        // Enter Message
        clear(contactUsPageElements.txaMessage);
        sendKeys(contactUsPageElements.txaMessage, fillupDetails.get("message").toString());

        // Upload File
        logger.info("7. Upload file");
        WebElement fileInput = driver.findElement(By.xpath(contactUsPageElements.filUpload));
        fileInput.sendKeys(filePath);

        // Click Submit button
        logger.info("8. Click 'Submit' button");
        click(contactUsPageElements.btnSubmit);

        // Accept the "Press OK to proceed!" confirmation alert
        logger.info("9. Click OK button");
        driver.switchTo().alert().accept();
    }

    public void clickHomeButton() {
        dismissPopupIfPresent();
        logger.info("11. Click 'Home' button and verify that landed to home page successfully");
        click(contactUsPageElements.btnHome);
        assertElementIsDisplayed("//body");
    }


}
