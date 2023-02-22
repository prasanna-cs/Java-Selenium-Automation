package seleniumscenarios;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import selenium.Utils;

public class Sceanrio2 {
	 @Test
	  

	public static void f(WebDriver webDriver,ExtentTest test) throws Exception {
		  System.out.println("Entered in scenario 2");
		  
		  WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
			
			
			String s = webDriver.getTitle();
			System.out.print(s);
			Thread.sleep(2500);
			
			// clicking on resources
			  
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"spSiteHeader\"]/div/div[2]/div/div[3]/div/div/div/span[4]/a"))).click();
			Thread.sleep(3500);
			
			
			// clicking on academics and registration
			
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='7b3083e7-1956-4f64-968b-920d938ba636']/div/div/div/div[1]/div[2]/div/div[1]/div/div/img"))).click();

		
			//Screenshot-2

			JavascriptExecutor js = (JavascriptExecutor) webDriver;
	        js.executeScript("window.scrollBy(0,250)", "");
			// removing two courses which we added
			Utils.takeScreenShot(webDriver, "Scenario2/1.removing_Favourites");
			
			webDriver.findElement(By.xpath(
					"//*[@id=\"7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/i"))
					.click();
			Thread.sleep(2500);
			webDriver.findElement(By.xpath(
					"//*[@id=\"7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/i"))
					.click();
			Thread.sleep(2500);
			Utils.takeScreenShot(webDriver, "Scenario2/2.removed_Favourites");
			
			webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			


	  }
}
