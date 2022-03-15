package week5.day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteTheIncident {

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
		
		//Search for the existing incident and navigate into the incident
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		 WebElement findElement2 = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		 findElement2.sendKeys("INC0010012");
		 findElement2.sendKeys(Keys.ENTER);
		 driver.switchTo().defaultContent();
		 driver.switchTo().frame(0);
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//a[text()='INC0010012']")).click();
		 driver.switchTo().defaultContent();
		 
		 //Delete the incident
		 driver.switchTo().frame(0);
		 driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
		 driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		 driver.switchTo().defaultContent();
		 
		 //Verify the deleted incident
		 driver.switchTo().frame(0);
		 Thread.sleep(4000);
		 String text = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		 System.out.println(text);
		 if(text.equals("No records to display")) {
			 System.out.println("the incident is deleted perfectly");
		 }
		 else {
			 System.out.println("the incident is not deleted");
		 }

	}

}
