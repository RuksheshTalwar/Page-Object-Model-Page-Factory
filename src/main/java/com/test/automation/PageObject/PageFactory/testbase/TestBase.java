package com.test.automation.PageObject.PageFactory.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	protected static WebDriver driver;
	
	String url = "https://tartecosmetics.com/";
	String browser = "chrome";

	@BeforeSuite
	public void init() {
		selectBrowser(browser);
		getUrl(url);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

	public void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			log.info("Launching browser" + browser);
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "/drivers/chromedriver.exe");
			log.info("Launching browser" + browser);
			driver = new ChromeDriver();
		}
	}

	public void getUrl(String url) {
		log.info("Navigating to URL : " + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	

}
