package regression;

import java.io.File;
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
import pageEvents.contactUsPageEvents;
import pageEvents.deleteAccountPageEvents;
import pageEvents.homePageEvents;
import pageObjects.homePageElements;
import pageEvents.productPageEvents;
import pageEvents.productReviewPageEvents;
import pageEvents.searchPageEvents;
import pageEvents.signupOrLoginPageEvents;
import pageEvents.signupPageEvents;

public class AutomationExerciseTestCases extends BaseTest {
        String browser;
        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                        + File.separator + "resources" + File.separator + "test-upload.txt";
        Dictionary<String, String> signupDetails;
        Dictionary<String, String> incorrectLoginDetails;
        Dictionary<String, String> duplicateEmail;
        Dictionary<String, String> contactDetails;
        homePageEvents homePage = new homePageEvents();
        signupOrLoginPageEvents signupOrLoginPage = new signupOrLoginPageEvents();
        signupPageEvents signupPage = new signupPageEvents();
        accountCreatedPageEvents accountCreatedPage = new accountCreatedPageEvents();
        deleteAccountPageEvents deleteAccountPage = new deleteAccountPageEvents();
        contactUsPageEvents contactUsPage = new contactUsPageEvents();
        productPageEvents productPage = new productPageEvents();
        productReviewPageEvents productReviewPage = new productReviewPageEvents();
        searchPageEvents searchPage = new searchPageEvents();

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
                duplicateEmail.put("email", signupDetails.get("email").toString()); // reuse the same email in
                                                                                    // registration
                signupOrLoginPage.signup(duplicateEmail);

                // 8. Verify error 'Email Address already exist!' is visible
                verifyTextVisibility(
                                "8. Verify error 'Email Address already exist!' is visible",
                                "//p[normalize-space()='Email Address already exist!']");
        }

        @Test(priority = 6)
        public void tc_06_Contact_Us_Form() {
                // 3. Verify that home page is visible successfully
                verifyTextVisibility(
                                "3. Verify that home page is visible successfully",
                                "//body");
                // 4. Click on 'Contact Us' button
                homePage.clickContactUsTab("4");
                // 5. Verify 'GET IN TOUCH' is visible
                verifyTextVisibility(
                                "5. Verify 'GET IN TOUCH' is visible",
                                "//h2[normalize-space()='Get In Touch']");
                // 6. Enter name, email, subject and message
                // 7. Upload file
                // 8. Click 'Submit' button
                // 9. Click OK button
                contactDetails = new Hashtable<>();
                contactDetails.put("name", "John Doe");
                contactDetails.put("email", generateEmail());
                contactDetails.put("subject", "Automation Testing Inquiry");
                contactDetails.put("message",
                                "Hello, I am testing the Contact Us form using Selenium automation. " +
                                                "This is a sample message for QA purposes.");

                contactUsPage.fillUpContactForm(contactDetails, filePath);
                // 10. Verify success message 'Success! Your details have been submitted
                // successfully.' is visible
                verifyTextVisibility(
                                "10. Verify success message 'Success! Your details have been submitted successfully.' is visible",
                                "//div[@class='status alert alert-success']");
                // 11. Click 'Home' button and verify that landed to home page successfully
                contactUsPage.clickHomeButton();
        }

        @Test(priority = 7)
        public void tc_07_Verify_Test_Cases_Page() {
                // 3. Verify that home page is visible successfully
                verifyTextVisibility(
                                "3. Verify that home page is visible successfully",
                                "//body");
                // 4. Click on 'Test Cases' button
                homePage.clickTestCasesTab("4");
                // 5. Verify user is navigated to test cases page successfully
                verifyTextVisibility(
                                "5. Verify user is navigated to test cases page successfully",
                                "//b[normalize-space()='Test Cases']");

        }

        @Test(priority = 8)
        public void tc_08_Verify_Products_Page() {
                // 3. Verify that home page is visible successfully
                verifyTextVisibility(
                                "3. Verify that home page is visible successfully",
                                "//body");
                // 4. Click on 'Products' button
                homePage.clickProductsTab("4");
                // 5. Verify user is navigated to ALL PRODUCTS page successfully
                verifyTextVisibility(
                                "5. Verify user is navigated to ALL PRODUCTS page successfully",
                                "//h2[normalize-space()='All Products']");
                // 6. The products list is visible
                verifyTextVisibility(
                                "6. The products list is visible",
                                "//div[@class='col-sm-9 padding-right']");
                // 7. Click on 'View Product' of first product
                productPage.clickViewProductButton();
                // 8. User is landed to product detail page
                verifyTextVisibility(
                                "8. User is landed to product detail page",
                                "//section//div[@class='row']");
                // 9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
                productPage.verifyDetailVisibility();
        }

        @Test(priority = 9)
        public void tc_09_View_Category_Products() {
                // 3. Click on 'Products' button
                homePage.clickProductsTab("3");
                // 4. Verify that categories are visible on left side bar
                homePage.verifyCategoriesSidebar();
                // 5. Click on 'Women' category
                homePage.clickWomenCategory("4. Click on 'Women' category");
                // 6. Click on 'Tops' under Women's category
                homePage.clickWomenTopsSubCategory("5. Click on 'Tops' category under 'Women' category");
                // 7. Verify category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
                verifyTextVisibility(
                                "6. Verify category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'",
                                "//h2[normalize-space()='WOMEN - TOPS PRODUCTS']");
                // 8. On left side bar, click on any sub-category link of 'Men' category
                homePage.clickMenCategory("7. Click on 'Men' category");
                homePage.clickMenTshirtsSubCategory("7. Click on 'Tshirts' category under 'Men' category");
                // 9. Verify that user is navigated to that category page
                verifyTextVisibility(
                                "8. Verify that user is navigated to that category page",
                                "//h2[contains(translate(normalize-space(.),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'MEN - TSHIRTS PRODUCTS')]");
        }

        @Test(priority = 10)
        public void tc_10_View_Cart_Brand_Products() {
                // 3. Click on 'Products' button
                homePage.clickProductsTab("3");
                // 4. Verify that Brands are visible on left side bar
                homePage.verifyBrandsSidebar();
                // 5. Click on any brand name
                homePage.clickBrandPolo("5. Click on 'Polo' brand");
                // 6. Verify that user is navigated to brand page and brand products are displayed
                verifyTextVisibility(
                                "6. Verify that user is navigated to brand page and brand products are displayed",
                                homePageElements.brandPageHeader);
                verifyTextVisibility(
                                "6. Verify that brand products are displayed",
                                homePageElements.brandProductsList);
                // 7. On left side bar, click on any other brand link
                homePage.clickBrandHM("7. Click on 'H&M' brand");
                // 8. Verify that user is navigated to that brand page and can see products
                verifyTextVisibility(
                                "8. Verify that user is navigated to that brand page and can see products",
                                homePageElements.brandPageHeader);
                verifyTextVisibility(
                                "8. Verify that brand products are displayed",
                                homePageElements.brandProductsList);
        }

        @Test(priority = 11)
        public void tc_11_Search_Products_And_Verify_Cart_After_Login() {
                // 3. Click on 'Products' button
                homePage.clickProductsTab("3");
                // 4. Verify user is navigated to ALL PRODUCTS page successfully
                verifyTextVisibility(
                                "4. Verify user is navigated to ALL PRODUCTS page successfully",
                                "//h2[normalize-space()='All Products']");
                // 5. Enter product name in search input and click search button
                searchPage.enterSearchTerm("5. Enter product name in search input", "top");
                searchPage.clickSearchButton("5. Click search button");
                // 6. Verify 'SEARCHED PRODUCTS' is visible
                verifyTextVisibility(
                                "6. Verify 'SEARCHED PRODUCTS' is visible",
                                "//h2[contains(normalize-space(),'Searched Products')]");
                // 7. Verify all the products related to search are visible
                verifyTextVisibility(
                                "7. Verify all the products related to search are visible",
                                "//div[contains(@class,'features_items')]");
                // 8. Add those products to cart
                searchPage.addFirstVisibleProductToCart("8. Add first visible product to cart");
                // 9. Click 'Cart' button and verify that products are visible in cart
                searchPage.clickCartLink("9. Click 'Cart' button");
                verifyTextVisibility(
                                "9. Verify that products are visible in cart",
                                "//b[normalize-space()='Shopping Cart']");
                // 10. Click 'Signup / Login' button and submit login details
                homePage.navigateToSignUpOrLogin();
                verifyTextVisibility(
                                "10. Verify 'Login to your account' is visible",
                                "//h2[normalize-space()='Login to your account']");
                signupOrLoginPage.login(signupDetails, "correct");
                // 11. Again, go to Cart page
                searchPage.clickCartLink("11. Go to Cart page again");
                // 12. Verify that those products are visible in cart after login as well
                verifyTextVisibility(
                                "12. Verify that those products are visible in cart after login as well",
                                "//b[normalize-space()='Shopping Cart']");
        }

        @Test(priority = 12)
        public void tc_12_Add_Review_On_Product() {
                // 3. Click on 'Products' button
                homePage.clickProductsTab("3");
                // 4. Verify user is navigated to ALL PRODUCTS page successfully
                verifyTextVisibility(
                                "4. Verify user is navigated to ALL PRODUCTS page successfully",
                                "//h2[normalize-space()='All Products']");
                // 5. Click on 'View Product' button
                productReviewPage.clickViewProductButton();
                // 6. Verify 'Write Your Review' is visible
                productReviewPage.verifyWriteYourReviewVisible();
                // 7. Generate dynamic review details
                String reviewName = "ReviewUser" + generate4Digit();
                String reviewEmail = "review" + generate4Digit() + "@test.com";
                String reviewText = "This is an automated review created at " + System.currentTimeMillis();
                productReviewPage.enterReviewDetails(reviewName, reviewEmail, reviewText);
                // 8. Click 'Submit' button
                productReviewPage.clickSubmitReview();
                // 9. Verify success message 'Thank you for your review' is visible
                productReviewPage.verifyReviewSuccessVisible();
        }

        @Test(priority = 13)
        public void tc_13_Add_To_Cart_From_Recommended_Items() {
                // 3. Verify that home page is visible successfully
                verifyTextVisibility(
                                "3. Verify that home page is visible successfully",
                                "//body");
                // 4. Scroll to bottom of page
                homePage.scrollToBottom("4. Scroll to bottom of page");
                // 5. Verify 'RECOMMENDED ITEMS' are visible
                homePage.verifyRecommendedItemsVisible();
                // 6. Click on 'Add To Cart' on Recommended product
                homePage.clickRecommendedItemAddToCart("6. Click on 'Add To Cart' on Recommended product");
                // 7. Click on 'View Cart' button
                searchPage.clickCartLink("7. Click on 'View Cart' button");
                // 8. Verify that product is displayed in cart page
                searchPage.verifyCartItemsVisible("8. Verify that product is displayed in cart page");
        }

        @AfterMethod(alwaysRun = true)
        public void afterMethod(ITestResult result) {
                afterMethod(result, browser);
        }

}