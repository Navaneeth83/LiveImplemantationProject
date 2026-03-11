package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonUtilities;

public class TC_RF_012 {
	
	@Test
	public void verifyRegisteringAccountusingKeyboardkeys() {
		
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Register")).click();
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
		.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		for(int i=1;i<=23;i++) {
			
			actions.sendKeys(Keys.TAB).perform();	
		}
		
		actions.sendKeys("Navaneeth").sendKeys(Keys.TAB).sendKeys("kumar").sendKeys(Keys.TAB).sendKeys(CommonUtilities.generateBrandNewEmail())
		.sendKeys(Keys.TAB).sendKeys("1234567890").sendKeys(Keys.TAB).sendKeys("12345").sendKeys(Keys.TAB).sendKeys("12345")
		.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB)
		.sendKeys(Keys.ENTER).build().perform();
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		
		driver.quit();
		
	}

}
