package pageObjects;

public interface productReviewPageElements {

    String btnViewProduct = "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]";
    String linkWriteYourReview = "//a[normalize-space()='Write Your Review']";
    String txtReviewName = "//input[@id='name' and @placeholder='Your Name']";
    String txtReviewEmail = "//input[@id='email' and @placeholder='Email Address']";
    String txtReview = "//textarea[@id='review' and @placeholder='Add Review Here!']";
    String btnSubmitReview = "//button[@id='button-review' and normalize-space()='Submit']";
    String lblReviewSuccess = "//div[contains(normalize-space(.),'Thank you for your review')]";
}
