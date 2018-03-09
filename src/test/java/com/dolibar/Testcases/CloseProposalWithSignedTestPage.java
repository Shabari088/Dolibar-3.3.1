package com.dolibar.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dolibar.base.TestBase;
import com.dolibar.pages.AddPointofContactPage;
import com.dolibar.pages.AddProposalPage;
import com.dolibar.pages.CloseProposalWithSignedPage;
import com.dolibar.pages.DolibarHomePage;
import com.dolibar.pages.LoginPage;
import com.dolibar.pages.ThirdPartiesPage;

public class CloseProposalWithSignedTestPage extends TestBase{
	
	LoginPage loginpage;

	DolibarHomePage homepage;

	ThirdPartiesPage partiesPage;

	AddProposalPage proposalPage;

	AddPointofContactPage PocPage;
	
	CloseProposalWithSignedPage signedPage;
	
	public CloseProposalWithSignedTestPage() {
		
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
		signedPage = new CloseProposalWithSignedPage();
		homepage = loginpage.login(prop.getProperty("Username"), prop.getProperty("password"));
		partiesPage = homepage.clickOnthirdPartieslink();
		 PocPage.clickOnPointofConatctLink();
		 proposalPage.ClickonCustomerTab();
	}
	
	@Test
	public void CloseWithSignedStatus()
	{
		signedPage.closeWithSignedStatus();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
