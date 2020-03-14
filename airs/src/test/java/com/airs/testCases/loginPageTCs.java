package com.airs.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.airs.pageObjects.LoginPage;


public class loginPageTCs extends BaseClass{
	
	@Test
	public void loginTestCase1() {

        logger.info("loginTestCase1()"); 
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUserID(UID);
		logger.info("User Id Entered :" + UID );
		
		lp.setPassword(PWD);
		logger.info("Password Entered :" + PWD);
		lp.loginSubmit();
		logger.info("Submit button clicked");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String X = driver.getTitle();
		if (driver.getTitle().equals(X)) {
			Assert.assertTrue(true);
			logger.info("Login TC1 passed: :" +driver.getTitle());
		}	
		else {
			Assert.assertTrue(false);
			logger.info("Login TC1 failed :" +driver.getTitle());
		}
	}
	
}
