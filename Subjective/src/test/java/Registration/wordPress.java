package Registration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

public class wordPress {
	
	private static WebDriver driver;
	private static String baseUrl;
	
	@BeforeClass
	public static void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		baseUrl = "https://wordpress.com/?aff=58022&cid=8348279";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	//private Date[] dataToWrite;
	
	//Get all the links
	@Test
	 public void linkCollection() throws Exception { 
		String filePath = "C:\\Users\\gyjkjehrhrhfhfhdgd\\Selenium Tutorial\\utilities";
		String fileName = "book1.xlsx";
		String sheetName = null; 
		int i = 0; 
		 List <WebElement> links = driver.findElements(By.tagName("a")); 
		 for(WebElement a : links) { 
			 String name = a.getText();
			 i++;
	   	    System.out.println("Link "+i +"- "+ name );   
		File file = new File(filePath+"\\"+fileName);
		FileInputStream input = new FileInputStream(file);
		Workbook sampleWB = null;
		@SuppressWarnings("null")
		Sheet sheet = sampleWB.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	    Row row = sheet.getRow(0);

	    //Create a new row and append it at last of sheet

	    Row newRow = sheet.createRow(rowCount+1);
	    for(int j = 0; j < row.getLastCellNum(); j++){
	        //Fill data in row
	        Cell cell = newRow.createCell(j);
	        cell.setCellValue(j);
	    }
	    //Close input stream
	    input.close();

	    //Create an object of FileOutputStream class to create write data in excel file
	    FileOutputStream outputStream = new FileOutputStream(file);

	    //write data in the excel file
	    sampleWB.write(outputStream);
	    //close output stream
	    outputStream.close();
		 }
	}
	
	@Test
	 public void imageCollection() throws Exception { 
		String name = driver.getTitle();
		System.out.println("Title of page is: " + name);
		 driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M47.57 10l')]")).click();
		 if(driver.getTitle().equals("WordPress.com: Create a Free Website or Blog")) {
			 System.out.println("We are back on WordPress site");
		 }else {
			 System.out.println("We are not on WordPress site");
		 }
	}
	 
	@AfterClass
	public static void window_close() {
		driver.quit();
	}

}
