package Selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendReport {
	
	WebDriver driver;
	ExtentReports extentreport;
	ExtentSparkReporter reporter;
	ExtentTest testcase;
	
	@Test
	public void openGoogle() throws IOException {
		testcase = extentreport.createTest("Open Google");
		driver.get("http://www.google.co.in");
		String data1 = driver.getTitle();
		if(data1.equals("Google")) {
			testcase.log(Status.PASS, "Opened Google");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File Taken = screenshot.getScreenshotAs(OutputType.FILE);
			File converted = new File("google.png");
			FileHandler.copy(Taken, converted);
			testcase.addScreenCaptureFromPath("google.png");
		}
		else
		{
			testcase.log(Status.FAIL, "Not Opened Google");
		}
		
	}
	@Test
	public void openBing() throws IOException {
		testcase = extentreport.createTest("Open Bing");
		driver.get("http://www.bing.com");
		String data2 = driver.getTitle();
		if(data2.equals("bing")) {
			testcase.log(Status.PASS, "Opened Bing");
		}
		else
		{
			testcase.log(Status.FAIL, "Not Opened Bing");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File Taken1 = screenshot.getScreenshotAs(OutputType.FILE);
			File converted1 = new File("bing.png");
			FileHandler.copy(Taken1, converted1);
			testcase.addScreenCaptureFromPath("bing.png");
		}
		
	}
		
	@Test
	public void openWiki() throws IOException {
		testcase = extentreport.createTest("Open Wikipedia");
		driver.get("http://www.wikipedia.org");
		String data3 = driver.getTitle();
		if(data3.equals("Wikipedia")) {
			testcase.log(Status.PASS, "Opened Wikipedia");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File Taken2 = screenshot.getScreenshotAs(OutputType.FILE);
			File converted2 = new File("wiki.png");
			FileHandler.copy(Taken2, converted2);
			testcase.addScreenCaptureFromPath("wiki.png");
		}
		else
		{
			testcase.log(Status.FAIL, "Not Opened Wikipedia");
		}
		
	}
	
	@BeforeSuite
	public void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		extentreport =new ExtentReports();
		reporter = new ExtentSparkReporter("Extentreport");
		extentreport.attachReporter(reporter);

		
	}
	@AfterSuite
	public void end() {
		driver.quit();
		extentreport.flush();
		
	}
	

}
