package com.w2a.testcases;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class OpenAccountTest extends TestBase{
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void openAccountTest(Hashtable<String, String> data) throws Exception {
		
		if(!TestUtil.isTestRunnable("OpenAccountTest", excel)) {
			throw new SkipException("Skipping the test : OpenAccountTest as the runmode is NO");
		}
		
		click("openAcctBtn_XPATH");
		select("custName_XPATH",data.get("customer"));
		select("currency_XPATH",data.get("currency"));
		click("processBtn_XPATH");
		Thread.sleep(3000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());	
		alert.accept();
		Thread.sleep(3000);
	}
	
	
	

}
