package week4day2assignmen;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		//Setup Chrome Driver
				WebDriverManager.chromedriver().setup();
				
				//Launch Browser
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//Navigate to URL
				driver.get("https://www.nykaa.com/");
				
				//Store the Parent Window Handle
				String parentWindowHandle = driver.getWindowHandle();
				
				//Mouseover on Brands and Search L'Oreal Paris
				Actions builder = new Actions(driver);
				
				WebElement brands = driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
				builder.moveToElement(brands).perform();
				
				//3) Click L'Oreal Paris
				WebElement loreal = driver.findElement(By.xpath(""
						+ "//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']"));
				
				builder.moveToElement(loreal).click().perform();
				
				//Check the title contains L'Oreal Paris(Hint-GetTitle)
				if (driver.getTitle().contains("L'Oreal Paris"))
					System.out.println("Title Matches");
				else
					System.out.println("Title Doesnt Match");
				
				//Click sort By and select customer top rated
				driver.findElement(By.xpath("//span[@class='sort-name']")).click();
				driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
				
				//Click Category and click Hair->Click haircare->Shampoo
				driver.findElement(By.xpath("//span[text()='Category']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[text()='Hair']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
				Thread.sleep(1000);
				WebElement shampoo = driver.findElement(By.xpath("//div[@class='control-indicator checkbox ']"));
				shampoo.click();
				Thread.sleep(1000);
				
				//Click->Concern->Color Protection
				driver.findElement(By.xpath("//span[text()='Concern']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
				Thread.sleep(1000);
				
				//check whether the Filter is applied with Shampoo
				String filter = driver.findElement(By.xpath("//span[text()='Shampoo']")).getText();
				if (filter.contains("Shampoo"))
					System.out.println("Shampoo Filter is Selected");
				else
					System.out.println("Shampoo Filter is not Selected");
				
				//Click on L'Oreal Paris Colour Protect Shampoo
				WebElement findProduct = driver.findElement(By.xpath("//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"]"));
				builder.moveToElement(findProduct).click().perform();
				
				//GO to the new window and select size as 175ml
				//Get Window Handle
				Set<String> windowsHandle = driver.getWindowHandles();
				
				//Convert Set to List
				List<String> windowsList = new ArrayList<String>(windowsHandle);
				
				//Switch to Window Tab opened
				driver.switchTo().window(windowsList.get(1));
				
				WebElement Size = driver.findElement(By.xpath("//select[@title='SIZE']"));
				Select ml = new Select(Size);
				
				ml.selectByValue("0"); 
				
				//Print the MRP of the product
				String MRP = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
				System.out.println("MRP: " + MRP);
				
				// Click on ADD to BAG
				driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
				
				//Go to Shopping Bag
				driver.findElement(By.xpath("(//div/button[@type='button'])[1]")).click();
				
				//Print the Grand Total amount
				
				//Switch to the frame
				driver.switchTo().frame(driver.findElement(By.className("css-acpm4k")));
				
				String GrandTotal = driver.findElement(
						By.xpath("//div[@class='name medium-strong']/following-sibling::div")).getText();
				System.out.println("Grand Total: " + GrandTotal);
				
				//Click Proceed
				driver.findElement(By.xpath("//span[text()='Proceed']")).click();
				
				//Click on Continue as Guest
				driver.findElement(By.xpath("//button[@class='btn full big']")).click();
				Thread.sleep(1000);
				
				//Check if this grand total is the same in step 14
				String fGrandTotal = driver.findElement(By.xpath("(//div[@class='value']/span)[2]")).getText();
				if (GrandTotal.contains(fGrandTotal))
					System.out.println("Total Value Matches");
				else
					System.out.println("Total Value Doesnt Matches");
				
				//Close all windows
				driver.quit();

	}

}
