package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class agileProject1 {
	
	public WebDriver driver;
	
	public void agile_project() {
		driver.findElement(By.xpath("//a[contains(text(),'Agile Project')]")).click();
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("1303");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Guru99");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		String verify = driver.findElement(By.xpath("//marquee[@class='heading3']")).getText();
		Assert.assertEquals(verify, "Welcome To Customer's Page of Guru99 Bank", "Error in loading!");
	}
	
	

}
