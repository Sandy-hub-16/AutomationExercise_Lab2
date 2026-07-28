package pageObjects;

public interface homePageElements {

    // 'Signup / Login' button
    String btnSignUpOrLogin = "//a[normalize-space()='Signup / Login']";

    // Tabs
    String tabDeleteAccount = "//a[normalize-space()='Delete Account']";
    String tabLogout = "//a[normalize-space()='Logout']";
    String tabContactUs = "//a[normalize-space()='Contact us']";
    String tabTestCases = "//a[contains(text(),'Test Cases')]";
    String tabProducts = "//a[@href='/products']";


} 
