package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class exerciseProject {
	
	WebDriver driver;
	@Given("^user clicks on agile project link$")
	public void user_clicks_on_agile_project_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
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
	}

}
