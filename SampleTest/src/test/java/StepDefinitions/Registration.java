package StepDefinitions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
//import pageObject.agileProject1;

public class Registration {
	public WebDriver driver;
	public String baseurl = "http://demo.guru99.com/test/newtours/register.php";
	//agileProject1 obj = new agileProject1();
	
	@Given("^User opens the application with the URL$")
	public void user_opens_the_application_with_the_URL() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("^User clicks on SignOn link$")
	public void user_clicks_on_SignOn_link() {
	    driver.findElement(By.xpath("//a[contains(text(),'SIGN-ON')]")).click();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("^User inputs the valid user credentials$")
	public void user_inputs_the_valid_user_credentials() {
	   driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("rajesh.agrawal@hotmail.com");
	   driver.findElement(By.xpath("//input[@name='password']")).sendKeys("AbcAbc@13");
	}

	@When("^User clicks Submit button$")
	public void user_clicks_Submit_button() {
	   driver.findElement(By.xpath("//input[@name='submit']")).click();
	}

	@Then("^Able to successfully load the page$")
	public void able_to_successfully_load_the_page() {
		try {
	    String login = driver.findElement(By.xpath("//h3[contains(text(),'Login Successfully')]")).getText();
	    Assert.assertEquals(login, "Login Successfully", "Error in loading!");
	   // obj.agile_project();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
	    	 TakesScreenshot scr = ((TakesScreenshot)driver);
	    	 File srcFile = scr.getScreenshotAs(OutputType.FILE);
	    	 File destFile = new File("C:\\Users\\gyjkjehrhrhfhfhdgd\\Selenium Tutorial\\Screenshot\\test.png");
	    	 FileUtils.copyFile(srcFile,destFile);
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }        
		    	 
		    	driver.quit();
		 }
		    
	}


