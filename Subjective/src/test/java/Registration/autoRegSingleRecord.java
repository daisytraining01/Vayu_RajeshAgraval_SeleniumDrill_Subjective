package Registration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import io.github.bonigarcia.wdm.WebDriverManager;


public class autoRegSingleRecord {
	
	public static WebDriver driver;
	public static String url = "http://demo.guru99.com/test/newtours/register.php";
	public static String path = "C:\\Users\\gyjkjehrhrhfhfhdgd\\Selenium Tutorial\\Screenshot\\test1.png";
	
	
	/**
	 * Read the URL and open the page
	 */
	public static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * Handle the iframe
	 */
	
	public static void guru_iframe() {
		try {
			Thread.sleep(5000);
			driver.switchTo().frame("flow_close_btn_iframe");
			driver.findElement(By.id("closeBtn")).click();
			driver.switchTo().defaultContent();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Insert the details for registration
	 */
	public static void guru_registration(){
		try {
		driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Rajesh1");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Agrawal");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8999558236");
		driver.findElement(By.id("userName")).sendKeys("rajesh.agrawal@hotmail.com");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Wakad");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Pune");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("MH");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("411057");
		
		/**
		 * Print the values from drop down
		 */
		
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		List<WebElement> e= dropdown.getOptions();
		int count = e.size();
		for(int i=0; i<count; i++) {
			System.out.println(e.get(i).getText());
		}
		dropdown.selectByVisibleText("INDIA");
		
		driver.findElement(By.id("email")).sendKeys("rajesh.agrawal@hotmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("AbcAbc@13");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("AbcAbc@13");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		takeSnapShot(driver, path);
		driver.quit();
	}
	
	/**
	 * Reading multiple entries using FILLO
	 */
	
	public static void read_data_Excel() {
		try {
		Fillo fillo=new Fillo();
        Connection connection =fillo.getConnection("C:\\Users\\gyjkjehrhrhfhfhdgd\\Selenium Tutorial\\utilities\\ExcelData.xlsx");
        String strQuery="Select * from Example where  RunStatus='Yes'";
        Recordset recordset=connection.executeQuery(strQuery);
        
        while(recordset.next()) {
            ArrayList<String> arrList = recordset.getFieldNames();
            
            for(String fieldName:arrList) {
               System.out.println(fieldName); 
            }
            
            String FirstName = recordset.getField("firstName");
            String LastName = recordset.getField("lastName");
            String Phone = recordset.getField("phone");
            String Email = recordset.getField("email");
            String Address = recordset.getField("address");
            String City = recordset.getField("city");
            String State = recordset.getField("state");
            String PostalCode = recordset.getField("postalcode");
            String UserName = recordset.getField("username");
            String Password = recordset.getField("password");
            String ConfirmPassword = recordset.getField("confirmPassword");
            
            driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
    		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(FirstName);
    		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(LastName);
    		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(Phone);
    		driver.findElement(By.id("userName")).sendKeys(Email);
    		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(Address);
    		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(City);
    		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(State);
    		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(PostalCode);
    		driver.findElement(By.id("email")).sendKeys(UserName);
    		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
    		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(ConfirmPassword);
    		driver.findElement(By.xpath("//input[@name='submit']")).click();
    		takeSnapShot(driver, path);
    		driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).click();
    		driver.quit();
        }
        
        recordset.close();
        connection.close();
       
   }catch(Exception e) {
       System.out.println(e.getLocalizedMessage());
   }
		
  }
	
	/**
	 * Take screenshot
	 * @param driver
	 * @param filePath
	 */
	
     public static void takeSnapShot(WebDriver driver, String filePath){
        try {
    	 TakesScreenshot scr = ((TakesScreenshot)driver);
    	 File srcFile = scr.getScreenshotAs(OutputType.FILE);
    	 File destFile = new File(filePath);
    	 FileUtils.copyFile(srcFile,destFile);
        }catch(Exception e) {
        	e.printStackTrace();
        }
    	 
    	//driver.quit();
    }
     
     /**
      * Main Method
      * @param args
      */
	
	public static void main(String[] args) {
		setup();
		guru_iframe();
		//guru_registration();
		//setup();
		//guru_iframe();
		read_data_Excel();
		
	}

}
