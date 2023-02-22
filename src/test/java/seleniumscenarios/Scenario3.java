package seleniumscenarios;

import java.time.Duration;

import java.util.*;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import selenium.Utils;

@Test
public class Scenario3 {
	 public static void f(WebDriver webDriver,Properties prop,ExtentTest test) throws Exception {
		  System.out.println("Entered in Scenario 3");
		 
		  
		  
		  WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
		 

			
			 String parent = webDriver.getWindowHandle();
			 
			 // clicking resources  academic
			
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id=\"spSiteHeader\"]/div/div[2]/div/div[3]/div/div/div/span[4]/a"))).click();
				Thread.sleep(3500);
			
			// clicking on academic and registrations	
				
				wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='7b3083e7-1956-4f64-968b-920d938ba636']/div/div/div/div[1]/div[2]/div/div[1]/div/div/img"))).click();
			Thread.sleep(3500);
			 String s = webDriver.getTitle();
				System.out.println(s);
				Utils.takeScreenShot(webDriver, "Scenario3/1.started_Browsing");
			// clicking on course registration
				
		  webDriver.findElement(By.xpath(
				"//*[@id='7b3083e7-1956-4f64-968b-920d938ba636']/div/div/div/div[2]/div/div/div[1]/div/div[11]/div/div/a"))
					.click();
		
		
		  // switching tab driver to banner
		  
		  for(String winHandle : webDriver.getWindowHandles()){
			    webDriver.switchTo().window(winHandle);
			}
		  Thread.sleep(10000);
			String actual = webDriver.getTitle();
			System.out.println("Scenario3 -" + actual);
			String expected = "Banner";
			//Assert added to check for correct website
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
						    { "<b>Assert1</b>", "<b>Actual</b>", "<b>Expected<b/>","<b>Pass/Fail</b>" },
						    { "Check Title of website", actual,expected, "<b><font color=red>Fail</font><b>" }
						   
						};
						Markup m = MarkupHelper.createTable(data);
					
					test.log(Status.FAIL, m);
			    }
			//Assert.assertEquals(actual,expected,"Website title does not match");
			
			// clicking on browse classes
			Utils.takeScreenShot(webDriver, "Scenario3/2.banner_screen");
		  
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"classSearch-desc\"]/h3"))).click();
//		
			Thread.sleep(2000);
			
			  
			Utils.takeScreenShot(webDriver, "Scenario3/3.selecting_term");
			// sending term key and clicking on search  
			  
			  wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("s2id_txt_term")))).click();
				WebElement semSearch = webDriver.findElement(By.id("s2id_autogen1_search"));
				semSearch.sendKeys(prop.getProperty("Term"));
				Thread.sleep(2500);
				wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[contains(text(),'Spring 2023 Semester')]"))))
				.click();
				
				
				webDriver.findElement(By.id("term-go")).click();
				Thread.sleep(2000);
			
				// sending key for program and course word
				
				wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("s2id_txt_subject")))).click();
				WebElement subjectInput = webDriver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]"));
				
				//Searching classes for the Information Systems program sending keys to the search bar
				subjectInput.sendKeys(prop.getProperty("Program"));
				//Screenshot-4
				Utils.takeScreenShot( webDriver,"Scenario3/4.Select_Information_Systems");
				Thread.sleep(3000);
				
				// clicking search aand displaying courses 
				
				wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[@id=\"INFO\"]")))).click();
				webDriver.findElement(By.id("search-go")).click();

				
			
				s = webDriver.getTitle();
				System.out.print(s);
				Thread.sleep(20000);
			Utils.takeScreenShot(webDriver, "Scenario3/5.browsed_classes");

			webDriver.close();
			webDriver.switchTo().window(parent);

	  }
}