package com.airs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver lDriver;
	public LoginPage(WebDriver rDriver) {
		lDriver= rDriver;
		PageFactory.initElements(rDriver,this);
	}

	@FindBy(name="UserID")   @CacheLookup WebElement Xemail;
	@FindBy(name="password") @CacheLookup WebElement Xpass;
	@FindBy(name="loginBtn") @CacheLookup WebElement Xu_0_2;

	@FindBy(xpath = "//input[contains(@id,'email')]")
	@CacheLookup 
	WebElement email;
	
	@FindBy(xpath = "//input[contains(@id,'pass')]") 
	@CacheLookup
	WebElement pass;
	
	@FindBy(xpath = "//input[contains(@data-testid,'royal_login_button')]")
	@CacheLookup
	WebElement u_0_2;
	
	public void setUserID(String UID) {
		email.sendKeys(UID);
	}
	
	public void setPassword(String PWD) {
		pass.sendKeys(PWD);
	}
	
	public void loginSubmit() {
		u_0_2.click();
	}
}
