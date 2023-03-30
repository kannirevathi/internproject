/*Test case : 001 (Chrome)

1. Launch https://login.salesforce.com/ 
2. Login to Salesforce with your username and password
3. Click on the App Launcher (dots)
4. Click View All
5. Type Content on the Search box
6. Click Content Link
7. Click on Chatter Tab
8. Verify Chatter title on the page
9. Click Question tab
10. Type Question with data (coming from excel)
11. Type Details with data (coming from excel)
12. Click Ask
13. Confirm the question appears
14. Close the browser
*/
package internproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesForceApplication extends CommonCode{

	/*@BeforeTest
	public void setup()
	{
	excelFile="salesforcedata";
	}*/
    @Test(dataProvider="fetchData")
    
	public void runSalesForce(String question) throws InterruptedException
		
	{	
		//click view all
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();	
		
		//click content
		driver.findElement(By.xpath("//p[text()='Content']")).click();
		
		
		
		
		//click chatter
		WebElement chatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click();", chatter);
		Thread.sleep(2000);
		
		//verify title
		String result = driver.getTitle();
		System.out.println(result);
		
		//click question tab
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		//
		driver.findElement(By.xpath("//textarea[@placeholder='What would you like to know?']")).sendKeys(question);
		
		String resultpage = driver.findElement(By.xpath("//textarea[@placeholder='What would you like to know?']")).getText();
		System.out.println(resultpage);
		
		
		
	
	}

}
