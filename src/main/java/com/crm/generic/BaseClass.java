package com.crm.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.TaskListPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * this class contains all the configuration methods like open the browser
 * close the browser login and logout
 * @author BTM-FACULTY
 *
 */
public class BaseClass {
	protected WebDriver driver;
	protected static WebDriver sdriver;
	/**
	 * this method is used to close the browser
	 */
	//@AfterClass(groups = { "smokeTest","regressionTest"})
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		//
		driver.quit();
	}
	/**
	 * this method is used to open the browser
	 */
	//@BeforeClass(groups = { "smokeTest","regressionTest"})
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void openBrowser(String browser) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			sdriver=driver;
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			sdriver=driver;
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			sdriver=driver;
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	}
	/**
	 * this method is used to login to the application
	 * @throws IOException 
	 */
	//@BeforeMethod(groups = { "smokeTest","regressionTest"})
	@BeforeMethod(alwaysRun = true)
	public void login() throws IOException {
		FileLib filelib=new FileLib();
		String url = filelib.getPropertyData("url");
		String username = filelib.getPropertyData("un");
		String password = filelib.getPropertyData("pwd");
		driver.get(url);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
	}
	/**
	 * this method is used to logout the application
	 */
	//@AfterMethod(groups = { "smokeTest","regressionTest"})
	@AfterMethod(alwaysRun = true)
	public void logout() {
		//
		//
		TaskListPage listPage=new TaskListPage(driver);
		listPage.clickOnLogout();
	}

}
