	package com.w2a.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase{
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		

		log.debug("Inside Login test");
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustBtn"))), "Login Not successful!!!");
		log.debug("Login successfully executed");
		Assert.fail("Login Not Successful");
		
	}
}
