Feature: Home Loan Repayments Calculator

  Scenario Outline: Navigate to the Repayment Calculator on the Commbank web site to enter different values for Home Loan repayment and validate the total loan repayment and total interest repayment.
    Given user navigates to <url>
    And user clicks on repayment calculator
    And user enters LoanAmount <LoanAmount>
    And user enters LoanTerm <LoanTerm>
    And user selects RepaymentType <RepaymentType>
    And user selects InterestRate <InterestRate>
    When user clicks Calculate button
    Then verify the TotalLoanRepayments <ExpectedTotalLoanRepayments>
    And verify the TotalInterestCharged <ExpectedTotalInterestCharged>
   
    Examples:
    | url | LoanAmount | LoanTerm | RepaymentType | InterestRate | ExpectedTotalLoanRepayments | ExpectedTotalInterestCharged |
    | https://www.commbank.com.au/ | 200000 | 25 | Principal and interest | 3.13% p.a. Extra Home Loan 10% deposit | $288,601 | $88,601 |
    | https://www.commbank.com.au/ | 150000 | 20 | Interest only 2 years | 3.68% p.a. Extra Investment Home Loan 30% deposit | $207,272 | $57,272 |
    | https://www.commbank.com.au/ | 300000 | 30 | Interest only 5 years | 2.89% p.a. 3 Year Fixed Rate Investment Home Loan | $550,831 | $250,831 |

