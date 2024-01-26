package com.demoblaze.testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.demoblaze.PageObjects.LoginPage;
import com.demoblaze.PageObjects.PhoneSelection;

public class TC_PhoneSecTest_001 extends BaseClass {
	
	@Test
	public void PhoneTest() throws Exception {
		
		driver.get(BaseURL);
		logger.info("Broswer is Opened");
		driver.manage().window().maximize();
		logger.info("Window is Maximized");
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		lp.ClickLoginHome();
		
		lp.setUserName(Username);
		logger.info("Username is Entered");
		lp.setPassword(Password);
		logger.info("password is Entered");
		lp.clickLogin();
		logger.info("Login Button is Clicked");
		PhoneSelection ph = new PhoneSelection(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		Thread.sleep(3000);
		ph.clkphoneSec();
		logger.info("Phone Section is Selected");
		ph.clkNokiaPhoneSec();
		logger.info("Phone  is Selected");
		ph.clkAddcartbutton();
		logger.info("Phone Added in Cart");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		ph.clkLogoutlnk();
		logger.info("User Logged out Successfully");
	}

}
