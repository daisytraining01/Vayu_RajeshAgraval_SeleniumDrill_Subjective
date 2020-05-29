package Registration;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class brokenLinks {

	public static WebDriver driver;
	public static String baseurl = "https://maveric-systems.com/";
	
	public static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void broken_links() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
        
        Iterator<WebElement> it = links.iterator();
        
        while(it.hasNext()){
            baseurl = it.next().getAttribute("href");
            System.out.println(baseurl);
            if(baseurl == null || baseurl.isEmpty()){
            	System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;            
                }
            //String homePage = null;
			//if(!baseurl.startsWith(homePage)){
            //    System.out.println("URL belongs to another domain, skipping it.");
            //    continue;
          //  }
         try {
                HttpURLConnection huc = (HttpURLConnection)(new URL(baseurl).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
            
                int respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(baseurl+" is a broken link");
                }
                else{
                    System.out.println(baseurl+" is a valid link");
                	}
               } catch (MalformedURLException e) {
                     e.printStackTrace();
                   } catch(IOException e) {
                	   e.printStackTrace();
                   }finally {
                	   System.out.println("baseurl is working");
                   }
        }
        driver.quit();
        
     }
        	
        public static void main(String[] args) throws Exception {
        	setup();
        	broken_links();
        }
      }
	


