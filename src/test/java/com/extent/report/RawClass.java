package com.extent.report;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;



public class RawClass {

	static WebDriver driver;
	//@Test
	public void rawMethodforGetProperty() {
		
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("java.version").substring(0, (System.getProperty("java.version").indexOf("."))));

	}
	
	@Test
	public void rawMethodForCapabilitiesBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.name("email")).sendKeys("Dinehs");
		
		
//		Capabilities capabilities=((RemoteWebDriver)driver).getCapabilities();
//		System.out.println(capabilities.getBrowserName());
//		System.out.println(capabilities.getBrowserVersion().substring(0, (capabilities.getBrowserVersion().indexOf("."))));
		
		
	}
	
	
}

