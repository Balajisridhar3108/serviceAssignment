package week5.day5;

import java.awt.Window;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignTheIncident {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Launching ServiceNow application
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://dev74561.service-now.com");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				//Login
				driver.switchTo().frame(0);
				driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
				driver.findElement(By.id("user_password")).sendKeys("@Balaji3108");
				driver.findElement(By.xpath("//button[text()='Log in']")).click();
				driver.switchTo().defaultContent();
				
				// Enter Incident in filter navigator 
				Thread.sleep(3000);
				WebElement findElement = driver.findElement(By.id("filter"));
				findElement.sendKeys("incident");
				Thread.sleep(3000);
				findElement.sendKeys(Keys.ENTER);
				
				
				//click on open and Search for the existing incident and click on  the incident
				
				//Thread.sleep(4000);
				driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();
				driver.switchTo().frame(0);
				WebElement findElement2 = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
				findElement2.sendKeys("INC0010015");
				findElement2.sendKeys(Keys.ENTER);
				
				//Assign the incident to  Software group
				driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).click();
				driver.findElement(By.xpath("//a[text()='INC0000015']")).click();
				
				WebElement dropdown = driver.findElement(By.xpath("//select[@id='incident.category']"));
				Select se = new Select(dropdown);
				se.selectByIndex(2);
				driver.switchTo().defaultContent();
				
				
				
				driver.switchTo().frame(0);
				driver.findElement(By.xpath("(//span[@class='input-group-btn']//button[@class='btn btn-default'])[5]")).click();
				driver.switchTo().defaultContent();
				String windowHandle = driver.getWindowHandle();
				Set<String>windowHandles = driver.getWindowHandles();
				List<String> list = new ArrayList<String>(windowHandles);
				driver.switchTo().window(list.get(1));
				
				
				WebElement findElement3 = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
				findElement3.sendKeys("software");
				findElement3.sendKeys(Keys.ENTER);
				
				WebElement findElement4 = driver.findElement(By.xpath("//a[text()='Software']"));
				String text = findElement4.getText();
				System.out.println(text);
				findElement4.click();
				
				driver.switchTo().window(windowHandle);
				driver.switchTo().frame(0);
				WebElement findElement5 = driver.findElement(By.xpath("//button[@id='lookup.incident.assigned_to']"));
				findElement5.click();
				driver.switchTo().defaultContent();
				String windowHandle2 = driver.getWindowHandle();
				 Set<String> windowHandles2 = driver.getWindowHandles();
				 List<String> list2 = new ArrayList<String>(windowHandles2);
				 driver.switchTo().window(list2.get(1));
				 WebElement findElement6 = driver.findElement(By.xpath("//a[text()='Don Goodliffe']"));
				 String text2 = findElement6.getText();
				 System.out.println(text2);
				 findElement6.click();
				 driver.switchTo().window(windowHandle2);
				 
				 //Update the incident with Work Notes
				 driver.switchTo().frame(0);
				 driver.findElement(By.xpath("(//span[@class='sn-stream-input-decorator']/following-sibling::textarea)[3]")).sendKeys("HALA MADRID");
				 driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
				 driver.switchTo().defaultContent();
				 
				 //Verify the Assignment group and Assigned for the incident
				 Thread.sleep(3000);
				 driver.switchTo().frame(0);
				     String text3 = driver.findElement(By.linkText("Software")).getText();
				    
				  
				   String text4 = driver.findElement(By.xpath("(//td[@class='vt']//a[text()='Don Goodliffe'])[1]")).getText();
				   
				   if(text.equals(text3)) {
					   System.out.println("Assign group is changed to"+text);
					   
				   }
				   else {
					   System.out.println("not created");
					  
				   }
				 if(text2.equals(text4)) {
					 System.out.println("Incidents is assignd to"+text4);
				 }
				 else {
					 System.out.println("not created");
				 }
	driver.switchTo().defaultContent();
	driver.close();
				

	}

}
