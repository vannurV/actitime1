package com.crm.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
/**
 * this class contains all the implemented methods of ITestListener
 * interface and it is used to monitor the test script during the runtime
 * @author user
 *
 */
public class ListenerImplementation implements ITestListener {

	public void onTestStart(ITestResult result) {
		Reporter.log("onTestStart",true);
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("onTestSuccess",true);
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getName();
		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+methodName+".png");
		
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("onTestSkipped",true);
	}

	public void onStart(ITestContext context) {
		Reporter.log("onStart",true);
	}

	public void onFinish(ITestContext context) {
		Reporter.log("onFinish",true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
