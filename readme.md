
# Selenium automation 

## The Tech Stack used is as below
1. Java
2. Selenium
3. Cucumber
4. JavaDoc

## Problem
Create a selenium script in java with test cases covering different values for Home Loan repayment and validate the total loan repayment and total interest repayment. You can access https://www.commbank.com.au and then click on "Home Loan repayment calculator" to identify the online calculator.

## What is Page Object Model (POM)?
Page Object Model is a design pattern which has become popular in test automation for enhancing test maintenance and reducing code duplication. A page object is an object-oriented class that serves as an interface to a page.
The tests then use the methods of this page object class whenever they need to interact with the UI of that page, the benefit is that if the UI changes for the page, the tests themselves don’t need to be changed, only the code within the page object needs to change.
Subsequently all changes to support that new UI are located in one place.
  
## How to execute the Test
  - Clone the repo on to the local machine
  - Setup MavenPath and Java Path
  - Go into the repo folder and execute the command 
  ```
  mvn clean install
  ```
  - Execute the RunCukesTest file
  - The browser instance should come up and execute the tests
