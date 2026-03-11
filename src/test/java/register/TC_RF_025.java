package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_025 {
	
	
	@Test
	public void verifyRegisteringAccountToCheckTheBreadcrumbFields() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String exepectedtitle = "Register Account";
		Assert.assertEquals(driver.getTitle(), exepectedtitle);
		
		String excepectedURL = "https://tutorialsninja.com/demo/index.php?route=account/register";
		Assert.assertEquals(driver.getCurrentUrl(), excepectedURL);
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
		 
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Register Account']")).getText(), "Register Account");
		
		driver.quit();
			
		
	}

}
