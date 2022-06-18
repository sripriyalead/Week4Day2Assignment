package week4day2assignmen;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragActivity {

	public static void main(String[] args) {
				//Setup Chrome Driver
				WebDriverManager.chromedriver().setup();
				
				//Launch Browser
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//Navigate to URL
				driver.get("http://www.leafground.com/pages/drag.html");
				
				WebElement eledrag = driver.findElement(By.id("draggable"));
				
				Actions builder=new Actions(driver);
				
				for(int i = 1, j = 1; i <=5 && j <=5; i++, j++ )
				{
				builder.clickAndHold(eledrag).dragAndDropBy(eledrag,i,j).release(eledrag).perform();
				}
				System.out.println("Location" +eledrag.getLocation());
				driver.close();
	}

}
