package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceAssign {

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
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.findElement(By.xpath("(//input[@class='form-control'])[4]")).sendKeys("Hala Madrid");
		
		 //get incident number
		WebElement findElement2 = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		String string = findElement2.getAttribute("value");
		System.out.println(string);
		
		//click submit
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(0);
        WebElement ele=driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
        ele.sendKeys(string);
        ele.sendKeys(Keys.ENTER);

		
		//verify instance created or not
        WebElement findElement3 = driver.findElement(By.xpath("//td[@class='vt']//a"));
        String text = findElement3.getText();
        System.out.println(text);
        driver.switchTo().defaultContent();
		if(string.equals(text)) {
			System.out.println("instance created");
		}
		else {
			System.out.println("instance not created");
		}
		
		
		
		

	}

}
