package com.dolibar.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dolibar.base.TestBase;
import com.dolibar.pages.AddPointofContactPage;
import com.dolibar.pages.DolibarHomePage;
import com.dolibar.pages.LoginPage;
import com.dolibar.pages.ThirdPartiesPage;
import com.dolibar.utilities.TestUtil;

public class PointofContactTestPage extends TestBase {
	
	LoginPage loginpage;
	DolibarHomePage  homepage;
	ThirdPartiesPage thirdpartiesPage;
	AddPointofContactPage pocpage;
	String sheetName = "PointOfContact";
	public PointofContactTestPage() {
		
		super();
	}
	
	@BeforeMethod
	public void startUp() throws InterruptedException
	{
		initialize();
		loginpage = new LoginPage();
		homepage = new DolibarHomePage();
		thirdpartiesPage = new ThirdPartiesPage();
		pocpage = new AddPointofContactPage();
		homepage = loginpage.login(prop.getProperty("Username"), prop.getProperty("password"));
		thirdpartiesPage = homepage.clickOnthirdPartieslink();
		pocpage.clickOnPointofConatctLink();
	}
	
	@DataProvider
	public Object[][] getPocTestData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getPocTestData")
	public void validateCreateNewPointOfcontact(String LastName,String FirstName,String Title,String postorfunction,String professionalPhone, 
			String personalPhone,String mobilephone,String fax,String Instantmessaging,String birthday) throws InterruptedException
	{
		pocpage.createNewPointofContact(LastName, FirstName, Title, postorfunction, professionalPhone, 
				personalPhone, mobilephone, fax, Instantmessaging, birthday);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
