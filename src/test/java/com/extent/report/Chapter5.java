package com.extent.report;

import java.util.ArrayList;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter5 {
	public static void main(String[] args) {
		ExtentReports extentReport = new ExtentReports();
		String reportPath = System.getProperty("user.dir") + "\\ExtentReport\\testReport3.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		extentReport.attachReporter(sparkReporter);
		// To print XML and JSON data
		String xmlData = "<menu id=\"file\" value=\"File\">\r\n" + "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n" + "  </popup>\r\n" + "</menu>";

		String jsonData="{\"menu\": {\r\n"
				+ "  \"id\": \"file\",\r\n"
				+ "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n"
				+ "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"vjsonDataalue\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}}";
		
		extentReport.createTest("xml based test")
		.log(Status.PASS, MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
		
		extentReport.createTest("jason based test").info(MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
		
		//To represent Collection Data in Extent Report
		//1) List data
		List<String> listData= new ArrayList<String>();
		listData.add("Dinesh");
		listData.add("Shlok");
		listData.add("Pramila");
		
		extentReport.createTest("List Data Test").log(Status.PASS, MarkupHelper.createOrderedList(listData))
												  .log(Status.PASS, MarkupHelper.createUnorderedList(listData));
		
		extentReport.createTest("Highlight Test").pass(MarkupHelper.createLabel("<b>This is Highlighted pass log</b>", ExtentColor.GREEN))
												.fail(MarkupHelper.createLabel("<i>This is highlighted fail Log</i>", ExtentColor.RED))
												.info("This is not highlighted color");
		
		
		extentReport.flush();
	}
}
