package com.demoblaze.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoblaze.PageObjects.LoginPage;
import com.demoblaze.PageObjects.PhoneSelection;

public class TC_LoginDDT_002 extends BaseClass {
	@Test(dataProvider="CredentailsSupplier")
public void PhoneDDTTest(String user,String pwd) throws Exception {
		
		driver.get(BaseURL);
		logger.info("Broswer is Opened");
		driver.manage().window().maximize();
		logger.info("Window is Maximized");
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		lp.ClickLoginHome();
		
		lp.setUserName(user);
		logger.info("Username is Entered");
		lp.setPassword(pwd);
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
		logger.info("*******************************************");
	}
	@DataProvider(name="CredentailsSupplier")
	public Object[][] dataSupplier() throws IOException {
		
		File file = new File(System.getProperty("user.dir")+"/src/test/java/com/demoblaze/testData/TestData.xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet Sheet = wb.getSheet("Sheet1");
		
		int rowCount = Sheet.getLastRowNum();
		int colCount = Sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowCount][colCount];
		for(int r=0;r<rowCount;r++) {
			XSSFRow row = Sheet.getRow(r+1);
		for(int c=0;c<colCount;c++) {
			XSSFCell cell = row.getCell(c);
			
			CellType cellType = cell.getCellType();
			
			switch(cellType) {
			case STRING:
				data[r][c] = cell.getStringCellValue();
				break;
			case NUMERIC:
				data[r][c] = Integer.toString((int)cell.getNumericCellValue());
				break;
			case BOOLEAN:
				data[r][c] = cell.getBooleanCellValue();
			}
		}
		}
		return data;
	}

}
