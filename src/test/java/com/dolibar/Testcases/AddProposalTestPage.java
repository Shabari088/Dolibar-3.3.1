package com.dolibar.Testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dolibar.base.TestBase;
import com.dolibar.pages.AddPointofContactPage;
import com.dolibar.pages.AddProposalPage;
import com.dolibar.pages.DolibarHomePage;
import com.dolibar.pages.LoginPage;
import com.dolibar.pages.ThirdPartiesPage;
import com.dolibar.utilities.TestUtil;
import org.testng.annotations.AfterMethod;

public class AddProposalTestPage extends TestBase{
	
	LoginPage loginpage;
	
	DolibarHomePage homepage;
	
	ThirdPartiesPage partiesPage;
	
	AddProposalPage proposalPage;
	
	AddPointofContactPage PocPage;
	
	String sheetName = "Proposal";

	public AddProposalTestPage() {
		
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
	
	@Test(priority = 1 ,dataProvider = "getPropsalTestData")
	public void ValidateCustomerProposalPage(String refCustomer,String contactId,String paymentType,String source,String availabilityDelay)
	{
		proposalPage.createNewCustomerProposal(refCustomer, contactId, paymentType, source, availabilityDelay);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
