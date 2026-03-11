package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_RF_014 {
	
	
	WebDriver driver;
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	@Test
	public void verifyAccountRegisteringwithSpecialCharactersAstricSymbol() {
		
		
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String expectedContent = "\"* \"";
		String expectedColor ="rgb(255, 0, 0)";
		
		WebElement firstNameLabel = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		WebElement lastNameLabel = driver.findElement(By.cssSelector("label[for='input-lastname']"));
		WebElement emailLabel = driver.findElement(By.cssSelector("label[for='input-email']"));
		WebElement telephoneLabel = driver.findElement(By.cssSelector("label[for='input-telephone']"));
		WebElement passwordLabel = driver.findElement(By.cssSelector("label[for='input-password']"));
		WebElement confirmPasswordLabel = driver.findElement(By.cssSelector("label[for='input-confirm']"));
		WebElement privacyPolicyLabel = driver.findElement(By.cssSelector("//div[@class='pull-right']"));
		
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    String firstNameContentLabel = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", firstNameLabel);
	    Assert.assertEquals(firstNameContentLabel,expectedContent );
	    String firstNameColorLabel = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", firstNameLabel);
		Assert.assertEquals(firstNameColorLabel, expectedColor);
		
		
		String lastNameContentLabel = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", lastNameLabel);
	    Assert.assertEquals(lastNameContentLabel,expectedContent );
	    String lastNameColorLabel = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", lastNameLabel);
		Assert.assertEquals(lastNameColorLabel, expectedColor);
		
		String emailContentLabel = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", emailLabel);
	    Assert.assertEquals(emailContentLabel,expectedContent );
	    String emailColorLabel = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", emailLabel);
		Assert.assertEquals(emailColorLabel, expectedColor);
		
		String telephoneContentLabel = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", telephoneLabel);
	    Assert.assertEquals(telephoneContentLabel,expectedContent );
	    String telephoneColorLabel = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", telephoneLabel);
		Assert.assertEquals(telephoneColorLabel, expectedColor);
		
		String passwordContentLabel = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", passwordLabel);
	    Assert.assertEquals(passwordContentLabel,expectedContent );
	    String passwordColorLabel = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", passwordLabel);
		Assert.assertEquals(passwordColorLabel, expectedColor);
		
		String confirmpasswordContentLabel = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",confirmPasswordLabel );
	    Assert.assertEquals(confirmpasswordContentLabel,expectedContent );
	    String confirmpasswordColorLabel = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", confirmPasswordLabel);
		Assert.assertEquals(confirmpasswordColorLabel, expectedColor);
		
		String privacyPolicyContentLabel = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",privacyPolicyLabel );
	    Assert.assertEquals(privacyPolicyContentLabel,expectedContent );
	    String privacyPolicyColorLabel = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", privacyPolicyLabel);
		Assert.assertEquals(privacyPolicyColorLabel, expectedColor);
		
		
	}

}
