package Registration;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {
	private static WebDriver driver;
	private static String baseUrl;

	@BeforeClass
	public static void beforeClass() {
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		baseUrl = "https://www.gmail.com";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test
	public void fileUpload() throws AWTException, InterruptedException {
		driver.findElement(By.id("identifierId")).sendKeys("rajesh.agrawal131083@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.id("password")).sendKeys("Priraj@12345"); // Enter your password
		driver.findElement(By.id("passwordNext")).click();
		
		//driver.findElement(By.id("signIn")).click();
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		driver.findElement(By.xpath("//textarea[@id=':pv']")).sendKeys("rajesh.agrawal131083@gmail.com");
		driver.findElement(By.xpath("//input[@id=':pd']")).sendKeys("Test File Upload");
		WebElement fileInput = driver.findElement(By.xpath("//div[@id=':qv']"));
		fileInput.click();

		String filePath = "C:\\Users\\gyjkjehrhrhfhfhdgd\\Selenium Tutorial\\utilities\\ExcelData.xlsx";
		StringSelection stringSelection= new StringSelection(filePath);
		//Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Robot robot = new Robot();
		// Cmd + Tab
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(2000);
		// Goto Window
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_G);
		// Paste the clipboard value
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_V);
		// Hit Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@id=':p3']")).click();
	}

	@AfterClass
	public static void afterClass() {
	}

}
