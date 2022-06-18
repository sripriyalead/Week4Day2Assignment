package week4day2assignmen;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sortableActivity {

	public static void main(String[] args) {
		//Setup Chrome Driver
		WebDriverManager.chromedriver().setup();
		
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Navigate to URL
		driver.get("http://www.leafground.com/pages/sortable.html");
		
		WebElement eledrag = driver.findElement(By.xpath("//ul[@id='sortable']/li[1]"));
		WebElement eledrop = driver.findElement(By.xpath("//ul[@id='sortable']/li[3]"));
		
		Actions builder=new Actions(driver);
		builder.moveToElement(eledrop).clickAndHold().dragAndDrop(eledrop,eledrag).perform();

	}

}
