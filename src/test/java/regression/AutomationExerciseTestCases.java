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
import pageEvents.deleteAccountPageEvents;
import pageEvents.homePageEvents;
import pageEvents.signupOrLoginPageEvents;
import pageEvents.signupPageEvents;

public class AutomationExerciseTestCases extends BaseTest {
        String browser;
        Dictionary<String, String> signupDetails;
        Dictionary<String, String> incorrectLoginDetails;
        Dictionary<String, String> duplicateEmail;
        homePageEvents homePage = new homePageEvents();
        signupOrLoginPageEvents signupOrLoginPage = new signupOrLoginPageEvents();
        signupPageEvents signupPage = new signupPageEvents();
        accountCreatedPageEvents accountCreatedPage = new accountCreatedPageEvents();
        deleteAccountPageEvents deleteAccountPage = new deleteAccountPageEvents();

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
                verifyTextVisibility(
                                "3. Verify that home page is visible successfully",
                                "//body");
                // 4. Click on 'Signup / Login' button
                homePage.navigateToSignUpOrLogin();
                // 5. Verify 'New User Signup!' is visible
                verifyTextVisibility(
                                "5. Verify 'New User Signup!' is visible",
                                "//h2[normalize-space()='New User Signup!']");

                // 6. Enter name and email address
                // 7. Click 'Signup' button
                signupDetails = new Hashtable<>();
                signupDetails.put("name", "John Doe");
                signupDetails.put("email", generateEmail());

                signupOrLoginPage.signup(signupDetails);

                // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
                verifyTextVisibility(
                                "8. Verify that 'ENTER ACCOUNT INFORMATION' is visible",
                                "//b[normalize-space()='Enter Account Information']");

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
                verifyTextVisibility(
                                "14. Verify that 'ACCOUNT CREATED!' is visible",
                                "//b[normalize-space()='Account Created!']");

                // Dismiss popup overlay if it appears before clicking Continue
                accountCreatedPage.dismissPopupIfPresent();

                // 15. Click 'Continue' button
                accountCreatedPage.clickContinueButton();

                // 16. Verify that 'Logged in as username' is visible
                verifyTextVisibility(
                                "16. Verify that 'Logged in as username' is visible",
                                "//a[contains(normalize-space(), 'Logged in as')]");

                // COMMENT OUT STEP 17 AND 18 FOR TEST CASE #2
                // >> To be able to get an existing account; otherwise test case #2 will FAILED

                // 17. Click 'Delete Account' button
                // homePage.clickDeleteAccountTab("17");

                // // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
                // verifyTextVisibility(
                // "18. Verify that 'ACCOUNT DELETED!' is visible",
                // "//b[normalize-space()='Account Deleted!']"
                // );
                // deleteAccountPage.clickContinueButton();

        }

        @Test(priority = 2)
        public void tc_02_Login_User_w_Correct_Credentials() {
                // 3. Verify that home page is visible successfully
                verifyTextVisibility(
                                "3. Verify that home page is visible successfully",
                                "//body");
                // 4. Click on 'Signup / Login' button
                homePage.navigateToSignUpOrLogin();
                // 5. Verify 'Login to your account' is visible
                verifyTextVisibility(
                                "5. Verify 'Login to your account' is visible",
                                "//h2[normalize-space()='Login to your account']");

                // 6. Enter correct email address and password
                // 7. Click 'login' button
                signupOrLoginPage.login(signupDetails, "correct");

                // 8. Verify that 'Logged in as username' is visible
                verifyTextVisibility(
                                "8. Verify that 'Logged in as username' is visible",
                                "//a[contains(normalize-space(), 'Logged in as')]");

                // COMMENT OUT STEP 9 AND 10 FOR TEST CASE #4
                // >> To be able to get an existing account; otherwise test case #4 will FAILED

                // // 9. Click 'Delete Account' button
                // homePage.clickDeleteAccountTab("9");
                // // 10. Verify that 'ACCOUNT DELETED!' is visible
                // verifyTextVisibility(
                // "10. Verify that 'ACCOUNT DELETED!' is visible",
                // "//b[normalize-space()='Account Deleted!']");
        }

        @Test(priority = 3)
        public void tc_03_Login_User_w_Incorrect_Credentials() {
                // 3. Verify that home page is visible successfully
                verifyTextVisibility(
                                "3. Verify that home page is visible successfully",
                                "//body");
                // 4. Click on 'Signup / Login' button
                homePage.navigateToSignUpOrLogin();
                // 5. Verify 'Login to your account' is visible
                verifyTextVisibility(
                                "5. Verify 'Login to your account' is visible",
                                "//h2[normalize-space()='Login to your account']");

                // 6. Enter incorrect email address and password
                // 7. Click 'login' button
                incorrectLoginDetails = new Hashtable<>();
                incorrectLoginDetails.put("email", "wrongemail@test.com");
                incorrectLoginDetails.put("password", "WrongPassword123!");

                signupOrLoginPage.login(incorrectLoginDetails, "incorrect");

                // 8. Verify error 'Your email or password is incorrect!' is visible
                verifyTextVisibility(
                                "8. Verify error 'Your email or password is incorrect!' is visible",
                                "//p[normalize-space()='Your email or password is incorrect!']");

        }

        @Test(priority = 4)
        public void tc_04_Logout_User() {
                // 3. Verify that home page is visible successfully
                verifyTextVisibility(
                                "3. Verify that home page is visible successfully",
                                "//body");
                // 4. Click on 'Signup / Login' button
                homePage.navigateToSignUpOrLogin();
                // 5. Verify 'Login to your account' is visible
                verifyTextVisibility(
                                "5. Verify 'Login to your account' is visible",
                                "//h2[normalize-space()='Login to your account']");

                // 6. Enter correct email address and password
                // 7. Click 'login' button
                signupOrLoginPage.login(signupDetails, "correct");

                // 8. Verify that 'Logged in as username' is visible
                verifyTextVisibility(
                                "8. Verify that 'Logged in as username' is visible",
                                "//a[contains(normalize-space(), 'Logged in as')]");

                // 9. Click 'Logout' button
                homePage.clickLogoutTab("9");

                // 10. Verify that user is navigated to login page
                verifyTextVisibility(
                                "10. Verify that user is navigated to login page",
                                "//body");

        }

        @Test(priority = 5)
        public void tc_05_Register_User_w_Email() {
                // 3. Verify that home page is visible successfully
                verifyTextVisibility(
                                "3. Verify that home page is visible successfully",
                                "//body");
                // 4. Click on 'Signup / Login' button
                homePage.navigateToSignUpOrLogin();
                // 5. Verify 'New User Signup!' is visible
                verifyTextVisibility(
                                "5. Verify 'New User Signup!' is visible",
                                "//h2[normalize-space()='New User Signup!']");
                // 6. Enter name and already registered email address
                // 7. Click 'Signup' button
                duplicateEmail = new Hashtable<>();
                duplicateEmail.put("name", "John Doe");
                duplicateEmail.put("email", signupDetails.get("email").toString()); // reuse the same email in registration
                signupOrLoginPage.signup(duplicateEmail);
                
                // 8. Verify error 'Email Address already exist!' is visible
                verifyTextVisibility(
                                "8. Verify error 'Email Address already exist!' is visible",
                                "//p[normalize-space()='Email Address already exist!']");
        }

        @Test(priority = 6)
        public void tc_06_Contact_Us_Form() {

        }

        @AfterMethod(alwaysRun = true)
        public void afterMethod(ITestResult result) {
                afterMethod(result, browser);
        }

}