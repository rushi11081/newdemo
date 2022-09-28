package Myapplication.EcommercewithPlaywright;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Firsttest 
{
	
	Page page;
	@BeforeTest
	public void setup()
	{
		
		Playwright playwright = Playwright.create();
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      
	      BrowserContext context = browser.newContext();
	      
	       page=context.newPage();
		
		page.navigate("https://www.amazon.com");
	}
	
	@Test
	
	public void titlecheck()
	{	
		
	String txt= page.title();
		System.out.println(txt);
		
		String test="Amazon.com. Spend less. Smile more.";
	
		Assert.assertEquals(txt,test);
		

	}
			
	
	@Test
	public void checkurl()
	{
		
		page.url();
		Assert.assertEquals(page.url(),"https://www.amazon.com/");
	}
	
		
	@AfterTest
	public void end()
	{
		
		page.close();
		
	}
	
	
}
