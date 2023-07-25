package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.ObjectRepository.LoginPage;

public class Baseclass {
	 FileLibrary f=new FileLibrary();
	public WebDriver driver;
	@BeforeSuite
	public void databaseConnection() {
		Reporter.log("database connected ",true);
	}
	
	@BeforeClass
	public void LaunchBrowser() throws IOException {
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		 String URL = f.readDataFromPropertyFile("url");
		 driver.get(URL);
		 Reporter.log("Browser is laumched successfully",true);
	
	}
	@BeforeMethod
	public void login() throws IOException {
		String un = f.readDataFromPropertyFile("username");
		LoginPage lp=new LoginPage(driver);
		lp.getUntbx().sendKeys(un);
		String pw = f.readDataFromPropertyFile("password");
		lp.getPwtbx().sendKeys(pw);
		lp.getLgbtn().click();
		Reporter.log("logged in successfully",true);
	}
	
	@AfterMethod
	public void logout() {
	driver.findElement(By.id("logoutLink")).click();
	Reporter.log("logged out successfully",true);
	}
	
	@AfterClass
	public void closeTheBrowser() {
		driver.close();
		Reporter.log("Browser closed successfully",true);
	
	}
	
	@AfterSuite
	public void dissconnectdatabase() {
	Reporter.log("database disconnected successfully",true);	
	}
	

}
