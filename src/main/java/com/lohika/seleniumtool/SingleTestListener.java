package com.lohika.seleniumtool;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SingleTestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Object currentClass = result.getInstance();
		WebDriver driver = ((SingleDriverBaseTest) currentClass).driver; 
		
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		
		String outputDir = result.getTestContext().getOutputDirectory();
		
		//System.out.println(outputDir);
		outputDir = outputDir.substring(0, outputDir.lastIndexOf(File.separatorChar));
		//System.out.println(outputDir);
		outputDir = outputDir.substring(0, outputDir.lastIndexOf(File.separatorChar));
		//System.out.println(outputDir);
        outputDir += File.separatorChar + "report";
        //System.out.println(outputDir);
		File saved = new File(outputDir + File.separatorChar + "screenshot_" + result.getMethod().getMethodName() + (new Date().getTime()) + ".png");
		
        try {
            FileUtils.copyFile(f, saved);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
