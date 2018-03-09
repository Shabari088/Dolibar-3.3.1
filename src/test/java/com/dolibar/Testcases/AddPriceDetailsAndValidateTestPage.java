package com.dolibar.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.dolibar.base.TestBase;
import com.dolibar.pages.AddPointofContactPage;
import com.dolibar.pages.AddPriceDetailsAndValidatePage;
import com.dolibar.pages.AddProposalPage;
import com.dolibar.pages.DolibarHomePage;
import com.dolibar.pages.LoginPage;
import com.dolibar.pages.ThirdPartiesPage;
import com.dolibar.utilities.TestUtil;

public class AddPriceDetailsAndValidateTestPage extends TestBase {

	LoginPage loginpage;

	DolibarHomePage homepage;

	ThirdPartiesPage partiesPage;

	AddProposalPage proposalPage;

	AddPointofContactPage PocPage;
	
	AddPriceDetailsAndValidatePage pricedetails;

	String sheetName = "ProposalValidate";
	
	public AddPriceDetailsAndValidateTestPage() {

		super();
	}
	
	@BeforeMethod
	public void startUp() throws InterruptedException
	{
		initialize();
		homepage = new DolibarHomePage();
		loginpage = new LoginPage();
		partiesPage = new ThirdPartiesPage();
		PocPage = new AddPointofContactPage();
		proposalPage =new AddProposalPage();
		pricedetails = new AddPriceDetailsAndValidatePage();
		homepage = loginpage.login(prop.getProperty("Username"), prop.getProperty("password"));
		partiesPage = homepage.clickOnthirdPartieslink();
		 PocPage.clickOnPointofConatctLink();
		 proposalPage.ClickonCustomerTab();
	}
	
	@DataProvider
	public Object[][] getPropsalTestData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getPropsalTestData")
	public void ValidateProsalPage(String selectType,String productName,String productPrice) throws InterruptedException
	{
		pricedetails.addPriceDetails(selectType, productName, productPrice);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
