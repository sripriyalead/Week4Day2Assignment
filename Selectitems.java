package week4day2assignmen;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectitems {

	public static void main(String[] args) {
		//Setup Chrome Driver
		WebDriverManager.chromedriver().setup();
		
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Navigate to URL
		driver.get("http://www.leafground.com/pages/selectable.html");
		
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement item7 = driver.findElement(By.xpath("//li[text()='Item 7']"));
		WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		
		Actions builder=new Actions(driver);
		builder.keyDown(Keys.CONTROL)
		.click(item1)
		.click(item5)
		.click(item7)
		.click(item4)
		.click(item3)
		.keyUp(Keys.CONTROL).perform();
		driver.close();

	}

}
