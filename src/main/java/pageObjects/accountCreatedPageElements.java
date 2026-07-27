package pageObjects;

public interface accountCreatedPageElements {

    String btnContinue = "//a[normalize-space()='Continue']";

    // Promotional popup close button (e.g. "Welcome to TaipeiPLAS 2026")
    // DOM: div#ad_position_box > div#card > div#dismiss-button (role="button", aria-label="close ad")
    String btnPopupClose = "//div[@id='dismiss-button']";

}
