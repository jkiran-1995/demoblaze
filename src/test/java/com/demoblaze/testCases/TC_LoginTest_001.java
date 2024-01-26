package com.demoblaze.testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.demoblaze.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() {
		driver.get(BaseURL);
		logger.info("Broswer is Opened for Login Funcationality");
		driver.manage().window().maximize();
		logger.info("Window is Maximized");
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		lp.ClickLoginHome();
		
		lp.setUserName(Username);
		logger.info("Username is Entered");
		lp.setPassword(Password);
		logger.info("password is Entered");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		lp.clickLogin();
		logger.info("LogIn link is clicked");
		
	}

}
