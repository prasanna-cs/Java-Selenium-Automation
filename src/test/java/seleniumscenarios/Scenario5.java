package seleniumscenarios;


import java.time.Duration;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import selenium.Utils;

@Test
public class Scenario5 {
	 public static void f(WebDriver webDriver,Properties prop,ExtentTest test) throws Exception {
		  System.out.println("Entered in Scenario 5");
		  	String parent = webDriver.getWindowHandle(); 
		  WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
			 
			 // resources --> academic --> course registration --> 
		  // clicking resources  academic
			
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"spSiteHeader\"]/div/div[2]/div/div[3]/div/div/div/span[4]/a"))).click();
		//	System.out.println("Entered 2");
			Thread.sleep(3500);
		
		// clicking on academic and registrations	
			
			wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='7b3083e7-1956-4f64-968b-920d938ba636']/div/div/div/div[1]/div[2]/div/div[1]/div/div/img"))).click();
		
		 
				 // clicking on course registration
		  Thread.sleep(2000);
		  Utils.takeScreenShot(webDriver, "Scenario5/1.started_browsing");
				webDriver.findElement(By.xpath(
				"//*[@id='7b3083e7-1956-4f64-968b-920d938ba636']/div/div/div/div[2]/div/div/div[1]/div/div[11]/div/div/a"))
					.click();
		
		
		  // switching tab driver to banner
		  
		  for(String winHandle : webDriver.getWindowHandles()){
			    webDriver.switchTo().window(winHandle);
			}
		  Thread.sleep(10000);

	
		  Utils.takeScreenShot(webDriver, "Scenario5/2.banner_screen");
			// clicking on plan classes
		  
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='worksheetPlanner-desc']/h3"))).click();
//		
			Thread.sleep(2000);
			
			  Utils.takeScreenShot(webDriver, "Scenario5/3.clickingOnPlan");

			  // selecting term spring 2023
				
				
			wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("s2id_txt_term")))).click();
				
			WebElement semSearch = webDriver.findElement(By.id("s2id_autogen1_search"));
				
				semSearch.sendKeys(prop.getProperty("Term"));
				Thread.sleep(3000);
				

			webDriver.findElement(By.xpath("//*[@id=\"202330\"]")).click();	
			Thread.sleep(2000);
				// clicking on  search
				
		webDriver.findElement(By.id("term-go")).click();
				// clicking on create plan
				Thread.sleep(5000);
				 
				  Utils.takeScreenShot(webDriver, "Scenario5/4.creating_plan");
				
				webDriver.findElement(By.xpath("//*[@id='createPlan']")).click();
				Thread.sleep(2000);
				
				 // selecting subject and course
				
				wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("s2id_txt_subject")))).click();
				WebElement subjectInput = webDriver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]"));
				
				//Searching classes for the Information Systems program sending keys to the search bar
				subjectInput.sendKeys(prop.getProperty("Program"));
				//Screenshot-4
				Thread.sleep(3000);
				
				// clicking search
				 Utils.takeScreenShot(webDriver, "Scenario5/5.fillling_course");
				wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[@id=\"INFO\"]")))).click();
				webDriver.findElement(By.id("search-go")).click();
				Thread.sleep(2000);
				
				// adding course
				
			
				 Utils.takeScreenShot(webDriver, "Scenario5/6.adding_course");
				wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//button[@aria-label='Introduction to Python for Information Systems INFO 5002 Add Course']")))).click();
			
				// saving plan
				
				wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[@id=\"saveButton\"]")))).click();
				
				
				//giving name to plan
				
				WebElement txt = webDriver.findElement(By.xpath("//*[@id=\"txt_planDesc\"]"));
				txt.sendKeys("selenium testing plan");
				
				// save button final
				Thread.sleep(1000);
				WebElement save = webDriver.findElement(By.xpath("//*[text()='Save']"));
				//Assert to verify if an object is visible :
				 try {
					 Assert.assertEquals(true, save.isDisplayed());
				        String[][] data = {
							    { "<b>Assert1</b>", "<b>Actual</b>", "<b>Expected</b>","<b>Pass/Fail</b>" },
							    { "Save button visibility","visible","visible", "<b><font color=green>Pass</font></b>" }
							   
							};
							Markup m = MarkupHelper.createTable(data);
						
						test.log(Status.PASS, m);
						
				    } catch (AssertionError e) {
				    	 System.out.println("catch block");
				        String[][] data = {
							    { "<b>Assert1</b>", "<b>Actual</b>", "<b>Expected</b>","<b>Pass/Fail<b/>" },
							    { "Save button visibility", "not-visible","visible", "<b><font color=red>Fail</font></b>" }
							   
							};
							Markup m = MarkupHelper.createTable(data);
						
						test.log(Status.FAIL, m);
				    }
				save.click();	
			Thread.sleep(2000);
	
			Utils.takeScreenShot(webDriver, "Scenario5/7.plan_saved");
			
			Thread.sleep(2000);
			webDriver.close();
			webDriver.switchTo().window(parent);


	  }
}