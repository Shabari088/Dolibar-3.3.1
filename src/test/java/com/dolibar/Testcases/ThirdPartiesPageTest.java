package com.dolibar.Testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.dolibar.base.TestBase;
import com.dolibar.pages.DolibarHomePage;
import com.dolibar.pages.LoginPage;
import com.dolibar.pages.ThirdPartiesPage;
import com.dolibar.utilities.TestUtil;

public class ThirdPartiesPageTest extends TestBase{
	
	LoginPage loginpage;
	DolibarHomePage homepage;
	ThirdPartiesPage thirdpartiesPage;
	String sheetName = "ThirdParty";
	public ThirdPartiesPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void startup()
	{
		initialize();
		loginpage = new LoginPage();
		homepage = new DolibarHomePage();
		thirdpartiesPage = new ThirdPartiesPage();
		homepage = loginpage.login(prop.getProperty("Username"), prop.getProperty("password"));
		thirdpartiesPage = homepage.clickOnthirdPartieslink();
		thirdpartiesPage.ClickonNewCustomerLink();
	}
	
	@DataProvider
	public Object[][] getThirdPartiesTestData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(dataProvider = "getThirdPartiesTestData")
	public void ValidateCreateNewCustomer(String thirdpartyname,String prospectorCustomer,String customercode,String address,
			String Zipcode,String City,String country,String stateorprovince,String phonenumber,String faxnumber,String email,
			String website,String profid1,String profid2,String profid3,String profid4,String profid5,String vatnumber,String thirdpartytype)
	{
		try {
			thirdpartiesPage.CreateNewCustomer(thirdpartyname, prospectorCustomer, customercode, address, Zipcode, City,
					country, stateorprovince, phonenumber, faxnumber, email, website, profid1, profid2, profid3, profid4,
					profid5, vatnumber, thirdpartytype);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
