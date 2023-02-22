package seleniumscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import selenium.Utils;

public class Scenario1 {
	
	
	
  @Test
  
  public static void f(WebDriver webDriver,ExtentTest test) throws Exception {
	  
	  System.out.println("Entered in Scenario 1");
	
	  WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
		
		
	  	// clicking on resources
	  
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"spSiteHeader\"]/div/div[2]/div/div[3]/div/div/div/span[4]/a"))).click();
		System.out.println("Entered in Scenario 1-resources");
		Thread.sleep(3500);
		// clicking on academics and registration
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='7b3083e7-1956-4f64-968b-920d938ba636']/div/div/div/div[1]/div[2]/div/div[1]/div/div/img"))).click();

		Utils.takeScreenShot(webDriver, "Scenario1/1.Adding_Favourites");
		String actual = webDriver.getTitle();
		System.out.println("Scenario1" + actual);
		String expected = "Student Hub - Resources";
		//Assert added to check for correct website
		 try {
		        Assert.assertEquals(actual,expected);
		        
		        String[][] data = {
					    { "<b>Assert1</b>", "<b>Actual</b>", "<b>Expected</b>","<b>Pass/Fail</b>" },
					    { "Check Title of website", actual,expected, "<b><font color=green>Pass</font></b>" }
					   
					};
					Markup m = MarkupHelper.createTable(data);
				
				test.log(Status.PASS, m);
				 
		    } catch (AssertionError e) {
		    	 System.out.println("catch block");
		        String[][] data = {
					    { "<b>Assert1</b>", "<b>Actual</b>", "<b>Expected</b>","<b>Pass/Fail</b>" },
					    { "Check Title of website", actual,expected, "<b><font color=red>Fail</font></b>" }
					   
					};
					Markup m = MarkupHelper.createTable(data);
				
				test.log(Status.FAIL, m);
		    }
		//Assert.assertEquals(actual,expected,"Website title does not match");
		Thread.sleep(2500);
		//Adding two courses to fav
		//JavascriptExecutor js = (JavascriptExecutor) webDriver;
       // js.executeScript("window.scrollBy(0,350)", "");
        //js.executeScript("window.scrollTo(0,document.body.scr‌ollHeight)");
        //WebElement scroll = webDriver.findElement(By.xpath("//*[@id='7b3083e7-1956-4f64-968b-920d938ba636']/div/div/div/div[2]/div/div/div[1]/div/div[16]/div/i"));
        //scroll.sendKeys(Keys.PAGE_DOWN);
        
		webDriver.findElement(By.xpath(
				"//*[@id=\"7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div/div/div[2]/div/div/div[1]/div/div[11]/div/i"))
				.click();
		Thread.sleep(2500);
		webDriver.findElement(By.xpath(
				"//*[@id=\"7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div/div/div[2]/div/div/div[1]/div/div[14]/div/i"))
				.click();
		Thread.sleep(3000);
		Utils.takeScreenShot(webDriver, "Scenario1/2.Added_To_Favourites");
		webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
	



  }
}
