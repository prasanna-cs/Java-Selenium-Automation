package selenium;
import static org.testng.AssertJUnit.assertEquals;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumscenarios.Sceanrio2;
import seleniumscenarios.Scenario1;

import seleniumscenarios.Scenario3;
import seleniumscenarios.Scenario4;
import seleniumscenarios.Scenario5;




//import seleniumScenarios.Screenshot;

public class App {
//
	static ExtentTest test;
	static ExtentReports report;
	static ExtentSparkReporter htmlReporter;

	public static void main(String[] args) throws Exception {
		
		report = new ExtentReports();
		htmlReporter = new ExtentSparkReporter("target/Spark.html");
	//	report = new ExtentReports();
		report.attachReporter(htmlReporter);

		try {
			InputStream input = new FileInputStream("./config.properties");
			long scriptStartTime = System.currentTimeMillis();
			Properties prop = new Properties();
			prop.load(input);
			WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")+"/chromedriver");
		
			Thread.sleep(5000);
			// Scenario 1
			try {
				System.out.print("1 start");
				test =  report.createTest("Scenario1");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
			    performLogin(driver, prop, test);
				Scenario1.f(driver,test);
				Thread.sleep(5000);
				driver.close();
				String[][] data = {
					    { "<b>Scenario Name[Test-Result]</b>", "<b>Actual</b>", "<b>Expected</b>","<b>Pass/Fail</b>" },
					    { "Add options in “My Favorites”", "Favorites added","Favorites added", "<b><font color=green>Pass</font></b>" }
					   
					};
					Markup m = MarkupHelper.createTable(data);
				test.log(Status.PASS,m);
				System.out.println();
				   String pp= System.getProperty("user.dir")+"/screenshot/Scenario1/";
			        

				test.info("<b><font color=red>"+"Screenshot 1: before adding favourites"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"1.Adding_Favourites_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 2: after adding favourites"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"2.Added_To_Favourites_screenshot.png").build());
				
			
			} catch (Exception e) {
				String[][] data = {
					    { "<b>Scenario Name[Test-Result]", "<b>Actual", "<b>Expected","<b>Pass/Fail" },
					    { "Add options in “My Favorites”", "Unable to add Favorites","Favorites added", "<b>Fail" }
					   
					};
					Markup m = MarkupHelper.createTable(data);	
				test.log(Status.FAIL, m);
			}
//		// Scenario 2
			try {
				System.out.print("2 start");
				test = report.createTest("Scenario2");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
		    performLogin(driver, prop, test);
			Sceanrio2.f(driver,test);
			Thread.sleep(5000);
			driver.close();

				String[][] data = {
					    { "<b>Scenario Name[Test-Result]</b>", "<b>Actual</b>", "<b>Expected</b>","<b>Pass/Fail</b>" },
					    { "Delete the option from “My Favorites”", "Favorites removed","Favorites removed", "<b><font color=green>Pass</font></b>" }
					   
					};
					Markup m = MarkupHelper.createTable(data);	
				test.log(Status.PASS, m);
				String pp= System.getProperty("user.dir")+"/screenshot/Scenario2/";
				test.info("<b><font color=red>"+"Screenshot 1: before removing favourites"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"1.removing_Favourites_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 2: after removing favourites"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"2.removed_Favourites_screenshot.png").build());
				
			} catch (Exception e) {
				String[][] data = {
					    { "<b>Scenario Name[Test-Result]</b>", "<b>Actual</b>", "<b>Expected</b>","<b>Pass/Fail</b>" },
					    { "Delete the option from “My Favorites”", "Unable to remove Favorites","Favorites removed", "<b><font color=red>Fail</font></b>" }
					   
					};
					Markup m = MarkupHelper.createTable(data);
				test.log(Status.FAIL, m);
			}
//			// Scenario 3
			try {
				System.out.print("3 start");
				test = report.createTest("Scenario3");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				performLogin(driver, prop, test);
				Scenario3.f(driver,prop,test);
				Thread.sleep(5000);
				driver.close();
				String[][] data = {
					    { "<b>Scenario Name[Test-Result]</b>", "<b>Actual</b>", "<b>Expected</b>","<b>Pass/Fail</b>" },
					    { "Browse classes for the Spring 2023 Semester", "Browsed classes","Browsed classes", "<b><font color=green>Pass</font></b>" }
					   
					};
					Markup m = MarkupHelper.createTable(data);
				test.log(Status.PASS, m);
				String pp= System.getProperty("user.dir")+"/screenshot/Scenario3/";
				test.info("<b><font color=red>"+"Screenshot 1: started browsing"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"1.started_Browsing_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 2: nu banner screen"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"2.banner_screen_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 3: selecting term"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"3.selecting_term_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 4: selecting major"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"4.Select_Information_Systems_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 5: courses browsed"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"5.browsed_classes_screenshot.png").build());
			
			} catch (Exception e) {
				String[][] data = {
					    { "<b>Scenario Name[Test-Result]</b>", "<b>Actual</b>", "<b>Expected</b>","<b>Pass/Fail</b>" },
					    { "Browse classes for the Spring 2023 Semester", "Unable to Browse","Browsed classes", "<b><font color=red>Fail</font><b>" }
					   
					};
				Markup m = MarkupHelper.createTable(data);	
				test.log(Status.FAIL, m);
			}
		//	 Scenario 4
			try {
				System.out.print("4 start");
				test = report.createTest("Scenario4");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				performLoginWebStore(driver, prop);
				Scenario4.runScenario(driver, prop,test);
				Thread.sleep(5000);
				driver.close();
				
				String[][] data = {
					    { "<b>Scenario Name[Test-Result]</b>", "<b>Actual</b>", "<b>Expected</b>","<b>Pass/Fail</b>" },
					    { "Adding Item to cart", "added to cart","added to cart", "<b><font color=green>"+"Pass"+"</font></b>" }
					   
					};
					Markup m = MarkupHelper.createTable(data);
				
				test.log(Status.PASS, m);	
				String pp= System.getProperty("user.dir")+"/screenshot/Scenario4/";
				test.info("<b><font color=red>"+"Screenshot 1: before login"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"bookstore_wo_login_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 2: after login"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"1.Search_an_Item_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 3: searching product"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"2.visiting_product_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 4: adding to cart"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"3.adding_to_cart_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 5: cart"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"4.View_Cart_screenshot.png").build());
				
				
			} catch (Exception e) {
				String[][] data = {
					    { "<b>Scenario Name[Test-Result]</b>", "<b>Actual</b>", "<b>Expected</b>","<b>Pass/Fail</b>" },
					    { "Adding Item to cart", "unable to add","added to cart", "<b><font color=red>Fail</font></b>" }
					   
					};
					Markup m = MarkupHelper.createTable(data);
				
				test.log(Status.FAIL, m);
			}
			
			// Scenario 5
			try {
				System.out.print("5 start");
				test = report.createTest("Scenario5");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				performLogin(driver, prop, test);
				Scenario5.f(driver, prop,test);
				Thread.sleep(5000);
				driver.close();
				String[][] data = {
					    { "<b>Scenario Name[Test-Result]</b>", "<b>Actual</b>", "<b>Expected</b>","<b>Pass/Fail</b>" },
					    { "Creating Plan", "Plan Created","Plan Created", "<b><font color=green>Pass</font></b>" }
					   
					};
					Markup m = MarkupHelper.createTable(data);
				test.log(Status.PASS, m);
				String pp= System.getProperty("user.dir")+"/screenshot/Scenario5/";
				test.info("<b><font color=red>"+"Screenshot 1: started browsing"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"1.started_browsing_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 2: nu banner"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"2.banner_screen_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 3: plan ahead"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"3.clickingOnPlan_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 4: creating plan"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"4.creating_plan_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 5: filling coures"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"5.fillling_course_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 6: adding course to plan"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"6.adding_course_screenshot.png").build());
				test.info("<b><font color=red>"+"Screenshot 7: plan saved"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(pp+"7.plan_saved_screenshot.png").build());
			} catch (Exception e) {
				String[][] data = {
					    { "<b>Scenario Name[Test-Result]</b>", "<b>Actual</b>", "<b>Expected</b>","<b>Pass/Fail</b>" },
					    { "Creating Plan", "Unable to Create a Plan","Plan Created", "<b><font color=red>Fail</font></b>" }
					   
					};
					Markup m = MarkupHelper.createTable(data);
				test.log(Status.FAIL, m);
			
			}
//			// dummy
			try {
				
				test = report.createTest("dummy");
				

				
				test.log(Status.PASS, "dummy");
			} catch (Exception e) {
				test.log(Status.FAIL, e);
			}
						
			report.removeTest(test);
		
			report.flush();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// @Before
	public static void performLogin(WebDriver driver, Properties prop, ExtentTest test) throws Exception {


		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		//driver.get(prop.getProperty("Launch"));
		driver.get(prop.getProperty("MYNEU_LINK"));
		Thread.sleep(5000);
		

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bySelection\"]/div[2]/div/span")))
				.click();
		Thread.sleep(5000);
		WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		username.sendKeys(prop.getProperty("NEU_USERNAME"));
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(prop.getProperty("NEU_PASSWORD"));
		Thread.sleep(5000);
		// Screenshot-1
		Utils.takeScreenShot(driver, "1.myneu_login_page_credentials");
		driver.findElement(By.xpath("/html/body/section/div/div[1]/div/form/div[3]/button")).click();
		driver.switchTo().frame("duo_iframe");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"auth_methods\"]/fieldset[1]/div[1]/button"))).click();
		// Screenshot-2
		Utils.takeScreenShot(driver, "2.Login_duo");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='idSIButton9']"))).click();
//		

		
		//Finding element to be added in the favorites
		Thread.sleep(10000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//i[@data-icon-name='Cancel']"))).click();
		Thread.sleep(5000);
		
		Utils.takeScreenShot(driver, "3.Logged_in");

	}

	@BeforeTest
	public static void performLoginWebStore(WebDriver webDriver, Properties prop) throws Exception {

		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
		
		Actions actions = new Actions(webDriver);
		
		
		Thread.sleep(2000);
		webDriver.get(prop.getProperty("Bookstore_link"));
		Thread.sleep(2000);
		Utils.takeScreenShot(webDriver,"Scenario4/bookstore_wo_login");
		
		
		String actual = webDriver.getTitle();
		System.out.println(actual);
		String expected = "Apparel, Gifts & Textbooks | Northeastern University Official Bookstore";
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
		        String[][] data = {
					    { "Assert1", "Actual", "Expected","Pass/Fail" },
					    { "Check Title of website", actual,expected, "FAIL" }
					   
					};
					Markup m = MarkupHelper.createTable(data);
				
				test.log(Status.FAIL, m);
		    }
		
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"bnedLoginButton\"]"))).click();
		
		
		Thread.sleep(2000);
	
		WebElement iframe = webDriver.findElement(By.xpath("//*[@id='loginHeaderIframe1']"));
		
		webDriver.switchTo().frame(iframe);  
		
		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
		email.sendKeys(prop.getProperty("email"));
		
		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
		password.sendKeys(prop.getProperty("password"));
		
		Thread.sleep(2000);
		webDriver.switchTo().defaultContent();	
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"submitLoginHeaderForm\"]")).click();
		Thread.sleep(2000);
		Utils.takeScreenShot(webDriver,"Scenario4/bookstore_loggedin");
		
		
	}
}
