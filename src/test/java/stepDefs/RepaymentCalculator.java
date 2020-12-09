package stepDefs;

import pageObjects.HomeLoanRepaymentCalculator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class RepaymentCalculator {
    public static WebDriver driver;
    HomeLoanRepaymentCalculator rc;

    public RepaymentCalculator() {
        driver = Hooks.driver;
    }

    @Given("^user navigates to (.+?)$")
    public void userNavigatesTo(String url) {
        driver.get(url);
        Assert.assertTrue(driver.getTitle().contains("CommBank"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        rc = new HomeLoanRepaymentCalculator(driver);
    }

    @And("^user clicks on repayment calculator$")
    public void userClicksOn() throws Exception {
        rc.clickRepaymentsCalculatorLink();
    }

    @And("^user enters LoanAmount (.+?)$")
    public void userEntersLoanAmount(String loanAmount) {
        rc.userEntersLoanAmount(loanAmount);
    }

    @And("^user enters LoanTerm (.+?)$")
    public void userEntersLoanTerm(String loanTerm) {
        rc.userEntersLoanTerm(loanTerm);
    }

    @And("^user selects RepaymentType (.+?)$")
    public void userSelectsRepaymentType(String repaymentType) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        rc.userSelectsRepaymentType(repaymentType);
    }

    @And("^user selects InterestRate (.+?)$")
    public void userSelectsInterestRate(String interestRate) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        rc.userSelectsInterestRate(interestRate);
    }

    @When("^user clicks Calculate button$")
    public void userClicksCalculateButton() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        rc.userClicksCalculateButton();
    }

    @Then("^verify the TotalLoanRepayments (.+?)$")
    public void verifyActualTotalLoanRepayments(String expectedTotalLoanRepayments) throws Exception {
        String actualTotalLoanRepayments =rc.getActualTotalLoanRepayments();
        Assert.assertEquals(expectedTotalLoanRepayments, actualTotalLoanRepayments);
    }

    @And("^verify the TotalInterestCharged (.+?)$")
    public void verifyActualTotalInterestCharged(String expectedTotalInterestCharged) throws Exception {
        String actualTotalInterestCharged = rc.getActualTotalInterestCharged();
        Assert.assertEquals(expectedTotalInterestCharged, actualTotalInterestCharged);
    }
}