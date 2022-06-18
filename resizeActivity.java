package week4day2assignmen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class resizeActivity {

	public static void main(String[] args) {
		//Setup Chrome Driver
		WebDriverManager.chromedriver().setup();
		
		//Setup Browser Options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Launching url
		driver.get("https://jqueryui.com/resizable/");
		
		//Switching inside the frame as resize box inside the frame
		driver.switchTo().frame(0);
		
	
		WebElement size = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		WebElement rs = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));
	    WebElement bs = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-s']"));
	    
	    //Action object initialised
	    Actions builder =new Actions(driver);
		
		for(int i = 1; i <=5;i++ )
		{
		builder.clickAndHold(rs).moveByOffset(i,i).release().perform();
		}
		System.out.println("Rightside location" +size.getLocation());
		

		for(int j = 1; j <=5; j++ )
		{
		builder.clickAndHold(bs).moveByOffset(j,j).release().perform();
		}
		System.out.println("Bottomside location" +size.getLocation());
		
		
		for(int i = 1, j = 1; i <=5 && j <=5; i++, j++ )
		{
		builder.clickAndHold(size).moveByOffset(i,j).release().perform();
		}
		System.out.println("Diaganoal location" +size.getLocation());
		


	}

}
