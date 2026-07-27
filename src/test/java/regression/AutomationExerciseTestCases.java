package regression;

import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.concurrent.TimeoutException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.flightPageEvents;
import pageEvents.homePageEvents;
import pageEvents.loginPageEvents;
import pageEvents.registerPageEvents;

public class AutomationExerciseTestCases extends BaseTest {
    String browser;
    Dictionary<String, String> registerDetails;
    homePageEvents homePage = new homePageEvents();
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
    //     loginPage.login(registerDetails);

    // }

    // @Test(priority = 3)
    // public void tc_03_Reservation() {
    //     flightPage.reserveFlight();

    // }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        afterMethod(result, browser);
    }

}