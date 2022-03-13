package week5.day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateInstance {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev74561.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("@Balaji3108");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		WebElement findElement = driver.findElement(By.id("filter"));
		findElement.sendKeys("incident");
		Thread.sleep(3000);
		findElement.sendKeys(Keys.ENTER);
		
		//Search for the existing incident and click on the incident
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		 WebElement findElement2 = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		 findElement2.sendKeys("INC0010005");
		 findElement2.sendKeys(Keys.ENTER);
		 driver.switchTo().defaultContent();
		 driver.switchTo().frame(0);
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[text()='INC0010005']")).click();
		 driver.switchTo().defaultContent();
		 
		 //Update the incidents with Urgency as High and State as In Progress
		 driver.switchTo().frame(0);
		 WebElement findElement3 = driver.findElement(By.xpath("//select [@id='incident.urgency']"));
		 Select se = new Select(findElement3);
		 se.selectByIndex(0);
		 driver.switchTo().defaultContent();
		 
		 driver.switchTo().frame(0);
		 WebElement findElement4 = driver.findElement(By.xpath("//select[@id='incident.state']"));
		 Select se2 = new Select(findElement4);
		 se2.selectByIndex(1);
		 driver.switchTo().defaultContent();
		 
		 driver.switchTo().frame(0);
		 driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();
		 driver.switchTo().defaultContent();
		 
		 //Verify the priority and state 
		 driver.switchTo().frame(0);
		 driver.findElement(By.xpath("//a[text()='INC0010005']")).click();
		 driver.switchTo().defaultContent();
		 
		 driver.switchTo().frame(0);
		 WebElement findElement5 = driver.findElement(By.xpath("//option[text()='1 - High']"));
		 String attribute = findElement5.getAttribute("value");
		 System.out.println(attribute);
		 driver.switchTo().defaultContent();
		
		 if(attribute.equals("1")) {
			 System.out.println("priority verified");
		 }
		 else {
			 System.out.println("not verified");
		 }
		
		 
		 driver.switchTo().frame(0);
		 WebElement findElement6 = driver.findElement(By.xpath("//option[text()='In Progress']"));
		 String text = findElement6.getText();
		 System.out.println(text);
		 driver.switchTo().defaultContent();
		
		 if(text.equals("In Progress")) {
			 System.out.println("state verified");
		 }
		 else {
			 System.out.println("not verified");
		 }
		
		 
	}

}
