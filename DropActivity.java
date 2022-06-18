package week4day2assignmen;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropActivity {

	public static void main(String[] args) {
		//Setup Chrome Driver
		WebDriverManager.chromedriver().setup();
		
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Navigate to URL
		driver.get("http://www.leafground.com/pages/drop.html");
		
		WebElement eledrag = driver.findElement(By.id("draggable"));
		WebElement eledrop = driver.findElement(By.id("droppable"));
		
		Actions builder=new Actions(driver);
		
		builder.clickAndHold(eledrag).dragAndDrop(eledrag,eledrop).release(eledrag).perform();
		
		System.out.println("Location" +eledrag.getLocation());
		System.out.println("Location" +eledrop.getLocation());
		
		driver.close();
		
	}

}
