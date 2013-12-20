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

public class DoubleTestListener implements ITestListener{

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
		WebDriver driver = ((DoubleDriverBaseTest) currentClass).driver;
		WebDriver driver2 = ((DoubleDriverBaseTest) currentClass).driver2; 
		
		File f1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File f2 = ((TakesScreenshot) driver2).getScreenshotAs(OutputType.FILE);
		
		String outputDir = result.getTestContext().getOutputDirectory();
		
		outputDir = outputDir.substring(0, outputDir.lastIndexOf(File.separatorChar));
		outputDir = outputDir.substring(0, outputDir.lastIndexOf(File.separatorChar));
		
        outputDir += File.separatorChar + "report";
		File saved1 = new File(outputDir + "." + File.separatorChar + "screenshot_driver1_" + result.getMethod().getMethodName() + (new Date().getTime()) + ".png");
		File saved2 = new File(outputDir + "." + File.separatorChar + "screenshot_driver2_" + result.getMethod().getMethodName() + (new Date().getTime()) + ".png");
		
        try {
            FileUtils.copyFile(f1, saved1);
            FileUtils.copyFile(f2, saved2);
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
