package com.dolibar.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dolibar.base.TestBase;
import com.dolibar.pages.AgendaPage;
import com.dolibar.pages.BankCashPage;
import com.dolibar.pages.CommercialPage;
import com.dolibar.pages.DocumentsPage;
import com.dolibar.pages.DolibarHomePage;
import com.dolibar.pages.FinancialPage;
import com.dolibar.pages.HolidaysPage;
import com.dolibar.pages.LoginPage;
import com.dolibar.pages.MembersPage;
import com.dolibar.pages.PointOfSalePage;
import com.dolibar.pages.ProductServicesPage;
import com.dolibar.pages.ProjectsPage;
import com.dolibar.pages.ThirdPartiesPage;

public class DolibarHomePageTest extends TestBase{
	
	LoginPage loginPage;
	
	DolibarHomePage homePage;
	
	ThirdPartiesPage thirdPartiesPage;
	
	CommercialPage commercialPage;
	
	DocumentsPage documentsPage;
	
	FinancialPage financialPage;
	
	AgendaPage agendapage;
	
	BankCashPage bankcashPage;
	
	HolidaysPage holidaysPage;
	
	MembersPage membersPage;
	
	PointOfSalePage pointofSalesPage;
	
	ProductServicesPage productServicePage;
	
	ProjectsPage projectsPage;
	
	public DolibarHomePageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void startup()
	{
		initialize();
		loginPage = new LoginPage();
		thirdPartiesPage =new ThirdPartiesPage();
		commercialPage = new CommercialPage();
		documentsPage = new DocumentsPage();
		financialPage = new FinancialPage();
		agendapage = new AgendaPage();
		bankcashPage = new BankCashPage();
		holidaysPage = new HolidaysPage();
		membersPage = new MembersPage();
		pointofSalesPage = new PointOfSalePage();
		productServicePage = new ProductServicesPage();
		projectsPage = new ProjectsPage();
		homePage = loginPage.login(prop.getProperty("Username"), prop.getProperty("password")); 
		
	}
	
	@Test(priority=1)
	public void homePageTitleTest()
	{
		String title = homePage.homepageTitle();
		
		Assert.assertEquals(title, "Dolibarr");
	}
	@Test(priority=2)
	public void homePagelinkTest()
	{
		boolean b = homePage.homelink();
		
		Assert.assertTrue(b);
		
	}
	
	@Test(priority=3)
	public void ThirdPartiesPageTest()
	{
		thirdPartiesPage = homePage.clickOnthirdPartieslink();
		
	}
	
	@Test(priority=4)
	public void CommercialPageTest()
	{
		commercialPage = homePage.clickOnCommerciallink();
		
	}
	
	@Test(priority=5)
	public void DocumentsPageTest()
	{
		documentsPage = homePage.clickOnDocumentslink();
		
	}
	
	@Test(priority=6)
	public void FinancialPageTest()
	{
		financialPage = homePage.clickOnFinanciallink();
		
	}
	
	@Test(priority=7)
	public void AgendaPageTest()
	{
		agendapage = homePage.clickOnAgendalink();
		
	}
	
	@Test(priority=8)
	public void BankCashPageTest()
	{
		bankcashPage = homePage.clickOnBankCashlink();		
	}
	
	@Test(priority=9)
	public void HolidaysPageTest()
	{
		holidaysPage = homePage.clickOnHolidayslink();
	}
	
	@Test(priority=10)
	public void MembersPageTest()
	{
		membersPage = homePage.clickOnMemberslink();
	}
	
	@Test(priority=11)
	public void PointOfSalePageTest()
	{
		pointofSalesPage = homePage.clickOnPointofSalelink();
	}
	
	@Test(priority=12)
	public void ProductServicesPageTest()
	{
		productServicePage = homePage.clickOnProductsServiceslink();
	}
	
	@Test(priority=13)
	public void ProjectsPageTest()
	{
		projectsPage = homePage.clickOnProjectslink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
