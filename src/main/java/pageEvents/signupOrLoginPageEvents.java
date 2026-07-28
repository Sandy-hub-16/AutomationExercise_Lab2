package pageEvents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Dictionary;

import base.BaseTest;
import pageObjects.signupOrLoginPageElements;

public class signupOrLoginPageEvents extends BaseTest {

    public void signup(@SuppressWarnings("rawtypes") Dictionary signupDetails) {

        // Fill up name and email address
        logger.info("6. Enter name and email address");
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(signupOrLoginPageElements.txtName)));

        clear(signupOrLoginPageElements.txtName);
        sendKeys(signupOrLoginPageElements.txtName, signupDetails.get("name").toString());

        clear(signupOrLoginPageElements.txtEmail);
        sendKeys(signupOrLoginPageElements.txtEmail, signupDetails.get("email").toString());

        // Click Sign up button
        logger.info("7. Click 'Signup' button");
        click(signupOrLoginPageElements.btnSignup);
    }

    public void login(@SuppressWarnings("rawtypes") Dictionary signupDetails, String correctOrIncorrect) {

        // Fill up name and email address
        logger.info("6.  Enter " +correctOrIncorrect+ " email address and password");
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(signupOrLoginPageElements.txtLoginEmail)));

        clear(signupOrLoginPageElements.txtLoginEmail);
        sendKeys(signupOrLoginPageElements.txtLoginEmail, signupDetails.get("email").toString());

        clear(signupOrLoginPageElements.txtPassword);
        sendKeys(signupOrLoginPageElements.txtPassword, signupDetails.get("password").toString());

        // Click Sign up button
        logger.info("7. Click 'login' button");
        click(signupOrLoginPageElements.btnLogin);
    }

    
}
