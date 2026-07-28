package pageObjects;

public interface contactUsPageElements {
    
    String txtName = "//input[@placeholder='Name']";
    String txtEmail = "//input[@placeholder='Email']";
    String txtSubject = "//input[@placeholder='Subject']";
    String txaMessage = "//textarea[@id='message']";
    String filUpload = "//input[@name='upload_file']";

    String btnSubmit = "//input[@name='submit']";

    //Submit Successfully
    String txtSuccess = "";
    String btnHome = "//a[@class='btn btn-success']";
}
