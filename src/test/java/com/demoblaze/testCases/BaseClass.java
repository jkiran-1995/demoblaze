package com.demoblaze.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.demoblaze.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String BaseURL = readConfig.getApplicationURL();
	public String Username = readConfig.getUserName();
	public String Password = readConfig.getPassword();
	public static WebDriver driver;
	public static ChromeOptions Options;
	public static Logger logger;
	
	
	@BeforeClass
	public void Setup() {
		logger = logger.getLogger("Demoblaze");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", readConfig.getchromepath());
		Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(Options);
		
	}
	@AfterClass
	public void teardown() {
		driver.close();
	}


}
