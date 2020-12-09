package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeLoanRepaymentCalculator {

    public WebDriver driver;
    By repaymentsCalculatorLink = By.linkText("Repayments calculator");
    By loanAmountField = By.id("amount");
    By loanTermField = By.id("term");
    By calculateButton = By.id("submit");

    public HomeLoanRepaymentCalculator(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Function to click on Repayment Calculator link
     */
    public void clickRepaymentsCalculatorLink() {
        driver.findElement(repaymentsCalculatorLink).click();
    }

    /**
     * Function to enter loan amount
     * @param loanAmount
     */
    public void userEntersLoanAmount(String loanAmount) {
        driver.findElement(loanAmountField).clear();
        driver.findElement(loanAmountField).sendKeys(loanAmount);
    }

    /**
     * Function to enter loan term
     * @param loanTerm
     */
    public void userEntersLoanTerm(String loanTerm) {
        driver.findElement(loanTermField).clear();
        driver.findElement(loanTermField).sendKeys(loanTerm);
    }

    /**
     * Function to select loan repayment type
     * @param repaymentType
     */
    public void userSelectsRepaymentType(String repaymentType) {
        Select dropDown = new Select(driver.findElement(By.id("interestOnly")));
        dropDown.selectByVisibleText(repaymentType);
    }

    /**
     * Function to enter interest rate
     * @param interestRate
     */
    public void userSelectsInterestRate(String interestRate) {
        Select dropDown = new Select(driver.findElement(By.id("productId")));
        dropDown.selectByVisibleText(interestRate);
    }

    /**
     * Function to select loan repayment frequency
     */
    public void userClicksCalculateButton() {
        driver.findElement(calculateButton).click();
    }

    /**
     * Function to get actual total loan repayments
     */
    public String getActualTotalLoanRepayments() {
        String actualTotalLoanRepayments = driver.findElement(By.xpath("//*[@data-tid=\"total-repayment\"]")).getText();
        return actualTotalLoanRepayments;
    }

    /**
     * Function to get actual total interest charged
     */
    public String getActualTotalInterestCharged() {
        String actualTotalInterestCharged = driver.findElement(By.xpath("//*[@data-tid=\"total-interest\"]")).getText();
        return actualTotalInterestCharged;
    }
}
