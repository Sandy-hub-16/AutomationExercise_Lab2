package pageObjects;

public interface signupOrLoginPageElements {
    
    //Sign Up
    String txtName = "//input[@placeholder='Name']";
    String txtEmail = "//input[@data-qa='signup-email']";

    String btnSignup = "//button[normalize-space()='Signup']";


    // Login
    String txtLoginEmail = "//input[@data-qa='login-email']";
    String txtPassword = "//input[@placeholder='Password']";
    
    String btnLogin = "//button[normalize-space()='Login']";
}
