package com.extent.report;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class Chapter3 {

	public static void main(String[] args) throws IOException {
		
		ExtentReports extentreport=new ExtentReports(); //It is the main engine of Extent report.compulsory need to write
		
		//we have different reporter in extentreport. Here we will use SparkReporter.
		//This will be used to configure report i.e. reporter gives outline/skeleton of report page.
		//In constructor pass the path where you want to save report with .html as extension
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter("D:\\Selenium workspace\\Eclipse Workspace1\\"
				+ "PracticeExtentReportMaven\\ExtentReport\\testReport.html");
		
		//To attach the reporter to main extentreport engine we will use as following
		extentreport.attachReporter(sparkReporter);
		
		//To write test case
		ExtentTest test1=extentreport.createTest("Test1");
		test1.pass("Test 1 pass");
		
		ExtentTest test2=extentreport.createTest("Test2");
		test2.log(Status.FAIL, "Test 2 fail");
		
		extentreport.createTest("Test 3").skip("Test 3 skipped");
		
		
		//when we done all the log and reporting, to push all things into report we will use flush method
		extentreport.flush();
		
		//To open report automatically
		Desktop.getDesktop().browse(new File("D:\\\\Selenium workspace\\\\Eclipse "
				+ "Workspace1\\\\PracticeExtentReportMaven\\\\ExtentReport\\\\testReport.html").toURI());
	}

}

