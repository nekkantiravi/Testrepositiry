package com.smava.test.automation.AssertVerification;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.smava.test.automation.pageObject.HomePage;
import com.smava.test.automation.pageObject.LoanPage;
import com.smava.test.automation.pageObject.LoginPage;
import com.smava.test.automation.testBase.TestBase;

public class AssertVerification {
	
	HomePage homePage=new HomePage(TestBase.driver);
	LoanPage loanPage=new LoanPage(TestBase.driver);
	LoginPage loginPage=new LoginPage(TestBase.driver);
	
	public void verifyLoanDetails() throws InterruptedException{
		assertThat(homePage.selectedLoanAmount,equalTo(loanPage.getLoanAmount()));
		assertThat(homePage.selectedLoanTendure,equalTo(loanPage.getLoanDuration()));
		assertThat(homePage.selectedLoanType,equalTo(loanPage.getLoanCategory()));
	}
	
	public void verifyLoginErrorMessage(){
		assertThat(loginPage.actualErrorMessage,equalTo(loginPage.loginErrorMessage.getText()));
	}

}
