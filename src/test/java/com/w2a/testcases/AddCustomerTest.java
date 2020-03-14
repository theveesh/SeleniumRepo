package com.w2a.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase{
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void addCustomerTest(String firstName, String lastName, String postCode, String alerttext) throws Exception {
		
		log.debug("Add Customer test execution started...");
		//driver.findElement(By.xpath(OR.getProperty("addCustBtn"))).click();
		click("addCustBtn_XPATH");
		log.debug("clicked on Add Customer button...");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(firstName);
		type("firstname_XPATH",firstName);
//		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(lastName);
		type("lastname_XPATH",lastName);
//		driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postCode);
		type("postcode_XPATH",postCode);
//		driver.findElement(By.xpath(OR.getProperty("addbtn"))).click();
		click("addbtn_XPATH");
		Thread.sleep(3000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		//Assert.assertTrue(alert.getText().contains(alerttext), "Alert text is not present!!!");
		alert.accept();
		Thread.sleep(3000);
		Assert.fail("Add customer failed");
		
	}
	
	
	

}
