package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\Learn Selenium\\chromedriver91.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://ww.google.co.in");
		
	}

}
