package com.online.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlTest;

import com.online.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	
	ReadConfig rc=new ReadConfig();
	
	String url=rc.getApplicationURL();
	String email=rc.getEmail();
	String pwd=rc.getPassword();
	
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br)
	{
		WebDriverManager.chromiumdriver().setup();
		WebDriverManager.iedriver().setup();
		WebDriverManager.firefoxdriver();
		if(br.equals("chrome"))
		{
		
		driver=new ChromeDriver();
		}
		else if (br.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (br.equalsIgnoreCase("ie")) {
            //WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}
	

	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
		
	}
}