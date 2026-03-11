package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_010 {
	
	@Test
	public void verifyRegisteringAccountbyprovidinginvalidemailaddress() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Navaneeth");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys("navaneeth");
		driver.findElement(By.id("input-telephone")).sendKeys("12345");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		String expectedWarningMessageOne = "Please include an '@' in the email address. 'navaneeth' is missing an '@'.";
		String actualWarningMesageOne = driver.findElement(By.id("input-email")).getAttribute("validationMessage");
		Assert.assertEquals(actualWarningMesageOne, expectedWarningMessageOne);
		
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("navaneeth@");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedWarningMessageTwo = "Please enter a part following '@'. 'navaneeth@' is incomplete.";
		String actualWarningMesageTwo = driver.findElement(By.id("input-email")).getAttribute("validationMessage");
		Assert.assertEquals(actualWarningMesageTwo, expectedWarningMessageTwo);
		
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("navaneeth@gmail");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedWarningMessageThree = "E-Mail Address does not appear to be valid!";
		String actualWarningMesageThree = driver.findElement(By.xpath("//input[@id='input-email']//following-sibling::div")).getText();
		Assert.assertEquals(actualWarningMesageThree, expectedWarningMessageThree);
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("navaneeth@gmail.");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedWarningMessageFour = "'.' is used at a wrong position in 'gmail.'.";
		String actualWarningMesageFour = driver.findElement(By.id("input-email")).getAttribute("validationMessage");
		Assert.assertEquals(actualWarningMesageFour, expectedWarningMessageFour);
		
		driver.quit();
		
	}
	
}
