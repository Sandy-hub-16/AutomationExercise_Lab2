package pageObjects;

public interface signupPageElements {
    
// Account Information
    // Title
    String mr = "//input[@id='id_gender1']";
    String ms = "//input[@id='id_gender2']";

    String txtPassword = "//input[@id='password']";

    // Date of Birth
    String slcDay = "//select[@id='days']";
    String slcMonth = "//select[@id='months']";
    String slcYear = "//select[@id='years']";

    String chkNewsLetter = "//input[@id='newsletter']";
    String chkSpecialOffer = "//input[@id='optin']";

// Address Information
    String txtFirstName = "//input[@id='first_name']";
    String txtLastName = "//input[@id='last_name']";
    String txtCompany = "//input[@id='company']";
    String txtAddress = "//input[@id='address1']";
    // String address2 = ""; --Optional
    String slcCountry = "//select[@id='country']";
    String txtState = "//input[@id='state']";
    String txtCity = "//input[@id='city']";
    String txtZipCode = "//input[@id='zipcode']";
    String txtMobileNo = "//input[@id='mobile_number']";

    String btnCreateAccount = "//button[normalize-space()='Create Account']";


}
