package com.dolibar.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dolibar.base.TestBase;
import com.dolibar.pages.DolibarHomePage;
import com.dolibar.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	DolibarHomePage homePage;
	
	 public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialize();
		loginPage = new LoginPage();	
	}	
	@Test(priority = 1)
	public void loginPageLogo()
	{
		boolean b = loginPage.validateDolibarImage();
		Assert.assertTrue(b);
	}
	
	@Test(priority = 2)
	public void LoginTest()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		homePage = loginPage.login(prop.getProperty("Username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
