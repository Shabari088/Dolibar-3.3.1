package com.dolibar.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.dolibar.utilities.TestUtil;
import com.dolibar.utilities.WebEventListener;


public class TestBase {

	public static WebDriver driver;
	
	public static Properties prop;
	
	public static EventFiringWebDriver e_driver;
	
	public static WebEventListener eventListener;

	public TestBase() {
		
		try {
			
			prop = new Properties();
			
			FileInputStream input = new FileInputStream("E:\\Revise_selenium\\Dolibar\\src\\main\\java\\com\\dolibar\\configuration\\config.properties");
			
			prop.load(input);
			
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialize()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\software\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.out.println("Sorry!-------------Browser could not be reached");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("Url"));
		
		driver.findElement(By.xpath("//a[contains(text(),'dolibarr-3.3.1')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'htdocs/')]")).click();
	}

}

