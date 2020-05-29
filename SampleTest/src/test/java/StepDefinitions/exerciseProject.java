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

public class exerciseProject {
	
	WebDriver driver;
	public String baseurl = "http://demo.guru99.com/test/newtours/register.php";
	
	@Given("^user clicks on agile project link$")
	public void user_clicks_on_agile_project_link() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Agile Project')]")).click();
	}

	@When("^user enters the \"([^\"]*)\"$")
	public void user_enters_the(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(arg1);
		System.out.println(arg1);
		
	}
	
	@When("^user gives the \"([^\"]*)\"$")
	public void user_gives_the(String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(arg2);
		System.out.println(arg2);
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	@Then("^homepage is visible$")
	public void homepage_is_visible() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String verify = driver.findElement(By.xpath("//marquee[@class='heading3']")).getText();
		Assert.assertEquals(verify, "Welcome To Customer's Page of Guru99 Bank", "Error in loading!");
		try {
	    	 TakesScreenshot scr = ((TakesScreenshot)driver);
	    	 File srcFile = scr.getScreenshotAs(OutputType.FILE);
	    	 File destFile = new File("C:\\Users\\gyjkjehrhrhfhfhdgd\\Selenium Tutorial\\Screenshot\\test1.png");
	    	 FileUtils.copyFile(srcFile,destFile);
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }        
		    	 
		    	driver.quit();
	}
	

}
