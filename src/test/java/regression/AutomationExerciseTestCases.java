package regression;

import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeoutException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.accountCreatedPageEvents;
import pageEvents.flightPageEvents;
import pageEvents.homePageEvents;
import pageEvents.signupOrLoginPageEvents;
import pageEvents.signupPageEvents;
import pageEvents.loginPageEvents;
import pageEvents.registerPageEvents;

public class AutomationExerciseTestCases extends BaseTest {
    String browser;
    Dictionary<String, String> signupDetails;
    homePageEvents homePage = new homePageEvents();
    signupOrLoginPageEvents signupOrLoginPage = new signupOrLoginPageEvents();
    signupPageEvents signupPage = new signupPageEvents();
    accountCreatedPageEvents accountCreatedPage = new accountCreatedPageEvents();

    registerPageEvents registerPage = new registerPageEvents();
    loginPageEvents loginPage = new loginPageEvents();
    flightPageEvents flightPage = new flightPageEvents();

    @BeforeTest(alwaysRun = true)
    @Parameters({ "browser" })
    public void prepareReport(@Optional("chrome") String browser) {
        this.browser = browser;
        beforeTestMethod(browser);
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(Method testMethod) throws TimeoutException {
        initializeBrowser(browser, testMethod);
    }

    @Test(priority = 1)
    public void tc_01_Register_User() {
        // 3. Verify that home page is visible successfully
        homePage.verifyHomePageVisibility();
        // 4. Click on 'Signup / Login' button
        homePage.navigateToSignUpOrLogin();
        // 5. Verify 'New User Signup!' is visible
        signupOrLoginPage.verifyNewUserSignupTextVisibility();

        // 6. Enter name and email address
        // 7. Click 'Signup' button
        signupDetails = new Hashtable<>();
        signupDetails.put("name", "John Doe");
        signupDetails.put("email", generateEmail());

        signupOrLoginPage.signup(signupDetails);

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        signupPage.verifyEnterAccountInfoTextVisibility();

        signupDetails.put("password", generatePassword());

        // 12. Fill details: First name, Last name, Company, Address,
        // Address2, Country, State, City, Zipcode, Mobile Number
        // 13. Click 'Create Account button'
        signupDetails.put("firstName", "John");
        signupDetails.put("lastName", "Doe");
        signupDetails.put("company", "Test Company");
        signupDetails.put("address", "123 Magnolia Avenue Los Angeles, CA 90001 United States");
        signupDetails.put("state", "California");
        signupDetails.put("city", "Los Angeles");
        signupDetails.put("zipCode", "90001");
        signupDetails.put("mobileNo", "09123456789");
        signupPage.enterAccountInformation(signupDetails);

        // 14. Verify that 'ACCOUNT CREATED!' is visible
        accountCreatedPage.verifyAccountCreatedTextVisibility();

        // Dismiss popup overlay if it appears before clicking Continue
        accountCreatedPage.dismissPopupIfPresent();

        // 15. Click 'Continue' button
        accountCreatedPage.clickContinueButton();

        // 16. Verify that 'Logged in as username' is visible
        // This is the real proof that Continue worked and the account was created
        // successfully.
        // The name used during signup is stored in signupDetails — "John Doe" maps to
        // the
        // navbar text "Logged in as John Doe" on the home page.
        homePage.verifyLoggedInAsUsernameTabVisibility();

        // registerDetails = new Hashtable<>();
        // registerDetails.put("firstName", "Ed");
        // registerDetails.put("lastName", "Dela Cruz");
        // registerDetails.put("phone", "09121234567");
        // registerDetails.put("email", "test@test.com");
        // registerDetails.put("address", "123 Test Way");
        // registerDetails.put("city", "Cavite");
        // registerDetails.put("state", "Metro Manila");
        // registerDetails.put("postalCode", "4114");
        // registerDetails.put("userName", "AutoTest" + generate4Digit());
        // registerDetails.put("password", "Password" + generate4Digit());
        // registerPage.register(registerDetails);
        // registerPage.validateUserRegister(registerDetails);

    }

    // @Test(priority = 2)
    // public void tc_02_Login() {
    // loginPage.login(registerDetails);

    // }

    // @Test(priority = 3)
    // public void tc_03_Reservation() {
    // flightPage.reserveFlight();

    // }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        afterMethod(result, browser);
    }

}