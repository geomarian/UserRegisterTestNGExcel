package com.Excel.list;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testUtil.testUtilities;



public class mainFile {
	  WebDriver driver;



	@BeforeMethod
	
	public void setUp() throws InterruptedException{
		//System.setProperty("webdriver.chrome.driver", "E:\\GEO\\Selenium Sample\\dataProviderTest\\chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "E:/GEO/Selenium Sample/dataProviderTest(COPY)/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fcell-phones");
		Thread.sleep(3000);
		System.out.println("Website is open");
		
		
	
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData = testUtilities.getDataFromExcel();
		return testData.iterator();
	}
	
	
	@Test(dataProvider="getTestData")
	public void regPage(String FirstName, String LastName, String Email, String Company){
		driver.findElement(By.id("FirstName")).clear();
		driver.findElement(By.id("FirstName")).sendKeys(FirstName);
		driver.findElement(By.id("LastName")).clear();
		driver.findElement(By.id("LastName")).sendKeys(LastName);
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(Email);
		driver.findElement(By.id("Company")).clear();
		driver.findElement(By.id("Company")).sendKeys(Company);
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}