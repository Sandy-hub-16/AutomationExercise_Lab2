package pageEvents;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageObjects.accountCreatedPageElements;

public class accountCreatedPageEvents extends BaseTest {


    public void clickContinueButton() {
        logger.info("15. Click 'Continue' button");

        int maxAttempts = 3;
        boolean navigated = false;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            dismissPopupIfPresent();
            click(accountCreatedPageElements.btnContinue);

            try {
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(d -> !d.getCurrentUrl().contains("account_created"));
                navigated = true;
                // logger.info("Continue navigation succeeded on attempt " + attempt);
                break;
            } catch (Exception e) {
                // logger.info("Attempt " + attempt + " did not navigate away from account_created, retrying");
            }
        }

        if (!navigated) {
            throw new AssertionError("Continue button click failed to navigate away from account_created after "
                    + maxAttempts + " attempts");
        }
    }
}
