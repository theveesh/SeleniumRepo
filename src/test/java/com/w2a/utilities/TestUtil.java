package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;


import com.w2a.base.TestBase;

public class TestUtil extends TestBase{
	
	public static String screenshotName;
	
	public static void captureScreenshot() throws IOException {
		
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Date d = new Date();
		screenshotName = d.toString().replace(":","_").replace(" ","_")+".jpg";
		File targetFile = new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotName);
		
		
		
		FileUtils.copyFile(srcFile, targetFile);
		
		
		
	}
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m){
		
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows - 1][cols];
		
		for(int rowNum = 2; rowNum <=rows; rowNum++) {
			
			for(int colNum = 0; colNum<cols; colNum++) {
				
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		
		return data;
	}

}
