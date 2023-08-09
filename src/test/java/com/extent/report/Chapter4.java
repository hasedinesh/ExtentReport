package com.extent.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter4 {

	public static void main(String[] args) {
		
	
	ExtentReports extentReport= new ExtentReports();
	
	//to make path of report dynamic, we can use following way
	String reportpath= System.getProperty("user.dir")+"\\ExtentReport\\testReport2.html";
	
	ExtentSparkReporter sparkReporter= new ExtentSparkReporter(reportpath);
	
	extentReport.attachReporter(sparkReporter);
	
	ExtentTest test1=extentReport.createTest("Test 1");
	
	test1.log(Status.PASS, "test pass")
	.log(Status.FAIL, "<b>test fail</b>")
	.log(Status.SKIP, "<i>Test case skip </i>")  
	.log(Status.INFO,"<b><i>Test case info </b></i>") //for bold and italic we can use html syntax.
 	.log(Status.WARNING,"Warning TC");
	
	
	extentReport.flush();
	}
}
