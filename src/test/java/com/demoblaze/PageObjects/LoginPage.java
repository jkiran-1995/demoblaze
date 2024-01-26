package com.demoblaze.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="login2")
	WebElement LogInLink;
	
	@FindBy(id="loginusername")
	WebElement txtUsername;
	
	@FindBy(id= "loginpassword")
	WebElement txtPassword;
	
	@FindBy(xpath ="//button[contains(text(),'Log in')]")
	WebElement clkLogin;
	
	@FindBy(id = "//a[contains(text(),'Log out')]")
	WebElement clklogout;
	
	public void ClickLoginHome() {
		LogInLink.click();
	}
	public void setUserName(String uname) {
		txtUsername.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void clickLogin() {
		clkLogin.click();
	}
	public void clkLogoutlnk() {
		clklogout.click();
	}


}
