package seleniumscenarios;

//import java.io.ObjectInputFilter.Status;
import java.time.Duration;
import java.util.Properties;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import selenium.Utils;

public class Scenario4 {

	@Test
	public static void runScenario(WebDriver driver, Properties prop,ExtentTest test) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));	
		Thread.sleep(3000);
		
		
		// logged in to book store
		
		//search  product
		
		WebElement calculator = driver.findElement(By.id("bned_site_search"));
		calculator.sendKeys(prop.getProperty("Product"));
		Utils.takeScreenShot(driver, "Scenario4/1.Search_an_Item");
		Thread.sleep(5000);
		calculator.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		// visiting product
		
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/main/div[3]/div[5]/div[1]/div[2]/div/div/div/ul/div[1]/a/img"))).click();
		
		
	
		Thread.sleep(2000);
		Utils.takeScreenShot(driver, "Scenario4/2.visiting_product");
		
		// clicking on add to cart and sending form
		Actions action = new Actions(driver);
		WebElement addTocart=driver.findElement(By.xpath("//*[@id=\"addToCartForm\"]"));
		//Assert to verify if an object is visible :
		 try {
			 Assert.assertEquals(true, addTocart.isDisplayed());
		        String[][] data = {
					    { "<b>Assert2</b>", "<b>Actual<b/>", "<b>Expected</b>","<b>Pass/Fail</b>" },
					    { "Add_to_cart button visibility","visible","visible", "<b><font color=green>Pass</font></b>" }
					   
					};
					Markup m = MarkupHelper.createTable(data);
				
				test.log(Status.PASS, m);
				
		    } catch (AssertionError e) {
		    	 System.out.println("catch block");
		        String[][] data = {
					    { "<b>Assert2</b>", "<b>Actual</b>", "<b>Expected</b>","<b>Pass/Fail</b>" },
					    { "Add_to_cart button visibility", "not-visible","visible", "<b><font color =red>Fail</font></b>" }
					   
					};
					Markup m = MarkupHelper.createTable(data);
				
				test.log(Status.FAIL, m);
		    }
		
		
		
	    
	    System.out.println("addTocart assert is passed");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
		action.moveToElement(addTocart);
		Thread.sleep(2000);
		Utils.takeScreenShot(driver, "Scenario4/3.adding_to_cart");
		
		addTocart.submit();

		// clicking on cart
		
		Thread.sleep(5000);
		
		
		WebElement cart = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id='headerDesktopView']/div[5]/div/ul/li[3]/div/div/button")));
				
		
		Thread.sleep(2000);
	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();",cart);
		Thread.sleep(2000);

		Thread.sleep(2000);
		

		
		Utils.takeScreenShot(driver, "Scenario4/4.View_Cart");
		Thread.sleep(3000);
		
	}
	
}
