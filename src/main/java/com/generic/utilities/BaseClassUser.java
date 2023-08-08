package com.generic.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.object.repository.admin.LoginAdmin;
import com.object.repository.admin.LogoutAdmin;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains all basic configuration annotations of TestNG
 * 
 * @author Vivekanand M
 *
 */
public class BaseClassUser {

	public ExcelFileUtility eutil = new ExcelFileUtility();
	public PropertyFileUtility putil = new PropertyFileUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebDriverUtility wutil = new WebDriverUtility();

	public WebDriver d = null;
	public static WebDriver SDriver;

	@BeforeSuite(groups = { "SmokeSuit", "RegressionSuit" })
	public void BSConfig() {
		System.out.println("===== DB Connection Successful =====");
	}

	@BeforeClass(alwaysRun = true)
	public void BCConfig() throws IOException {
		String BROWSER = putil.readDatafromPropertyFileUser("browser");
		String URL = putil.readDatafromPropertyFileUser("url");
		
		// LAUNCH THE BROWSER
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
			System.out.println("===== " + BROWSER + " Browser Launch =====");
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver();
			System.out.println("===== " + BROWSER + " Browser Launch =====");
		} else {
			System.out.println("===== Invalid Browser Name =====");
		}

		// Updated driver reference
		SDriver = d;

		// Maximise the window.
		wutil.maximiseWindow(d);

		// Appling Implicit wait for syncronisation of Selenium or Web Page.
		wutil.waitForPageLoad(d);

		// Get the main URL of application.
		d.get(URL);

	}

	@BeforeMethod(groups = { "SmokeSuit", "RegressionSuit" })
	public void BMConfig() throws IOException {
		System.out.println("===== Login is Successful =====");
	}

	@AfterMethod(groups = { "SmokeSuit", "RegressionSuit" })
	public void AMConfig() {
		System.out.println("===== Logout is Successful =====");
	}

	@AfterClass(groups = { "SmokeSuit", "RegressionSuit" })
	public void ACConfig() throws IOException {
		d.quit();
		String BROWSER = putil.readDatafromPropertyFileUser("browser");
		System.out.println("===== " + BROWSER + " Browser Closed =====");
	}

	@AfterSuite(groups = { "SmokeSuit", "RegressionSuit" })
	public void ASConfig() {
		System.out.println("===== DB Connection Closed =====");
	}

}
