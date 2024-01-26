package com.demoblaze.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhoneSelection {
	
	WebDriver ldriver;
	public  PhoneSelection(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath = "//a[contains(text(),'Phones')]")
	WebElement clkphone;
	
	@FindBy(xpath = "//a[contains(text(),'Nokia lumia 1520')]")
	WebElement clkNokiaPhone;
	
	@FindBy(xpath = "//a[contains(text(),'Add to cart')]")
	WebElement clkAddCart;
	
	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	WebElement clklogout;
	
	public void clkphoneSec() {
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		clkphone.click();
		
	}
	public void clkNokiaPhoneSec() {
		clkNokiaPhone.click();
	}
	public void clkAddcartbutton() {
		clkAddCart.click();
	}
	public void clkLogoutlnk() {
		clklogout.click();
	}

}
