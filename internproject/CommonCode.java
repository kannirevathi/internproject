package internproject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;



public class CommonCode {

	    public ChromeDriver driver;
		public String excelFile;
		@BeforeMethod
		 public void launchBrowser()
		 {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			//To launch browser
		    driver=new ChromeDriver(option);
			driver.get("https://login.salesforce.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			//login with user name
			driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
			//login with password
			driver.findElement(By.id("password")).sendKeys("Leaf@123");
			//click login
			driver.findElement(By.id("Login")).click();
			
			//click app launcher
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		
		
		
	}
		 @AfterMethod
		 public void closeBrowser()
	 {
		 driver.close();
	 }
	
		 @DataProvider(name="fetchData")
	      public String[][] readData() throws IOException
	 {
	 	String[][] fetchdata = ExcelRead.getData(excelFile);
	 	return fetchdata;
	 	
	 }
	 }


