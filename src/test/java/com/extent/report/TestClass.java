package com.extent.report;


import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestClass extends BaseTest{

	@Test(testName = "TestGoogle", groups = {"smoke"})
	public void TestGoogle() throws Exception {
		driver.get("https://www.google.com/");
		extentTest.info("Navigated to Url");
		driver.findElement(By.name("q")).sendKeys("HYR Tutorials", Keys.ENTER);
		extentTest.info("Entered text in search box");
		String expectedTitle = "HYR Tutorials - Google Search";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle, "Title is mismatched");
		extentTest.pass("Assertion is passed for webpage title");
	}

	@Test(testName = "TestFacebook", groups = {"smoke","regression"})
	public void TestFacebook() throws Exception {
		driver.get("https://www.facebook.com/");
		extentTest.info("Navigated to Url");
		driver.findElement(By.name("email")).sendKeys("HYR Tutorials", Keys.ENTER);
		
		SoftAssert softAssert = new SoftAssert();
		//Title Assertion
		String actualTitle = driver.getTitle();
		String expectedTitle = "Log in to Facebook";
		softAssert.assertEquals(actualTitle, expectedTitle, "Title is mismatched");
		
		//URL Assertion
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.facebook.com/";
		softAssert.assertEquals(actualUrl, expectedUrl, "URL is mismatched");
		
		//Text Assertion
		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		String expectedText = "";
		softAssert.assertEquals(actualText, expectedText, "Username text is mismatched");
		
		//Border Assertion
		String actualBorder = driver.findElement(By.name("email")).getCssValue("border");
		String expectedBorder = "1px solid rgb(240, 40, 73)";
		softAssert.assertEquals(actualBorder, expectedBorder, "Username border is mismatched");
		
		//ErrorMessage Assertion
		String actualErrorMessage = driver.findElement(By.xpath("(//div[@id='email_container']/div)[last()]")).getText();
		String expectedErrorMessage = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "Username error message is mismatched");
		
		softAssert.assertAll();
	}
	
	@Test(testName = "TestOrangeHRM", groups = {"sanity"})
	public void TestOrangeHRM() throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		extentTest.info("Navigated to Url");
		driver.findElement(By.cssSelector("input#username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
	}
}