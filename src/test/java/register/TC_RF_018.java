package register;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchCookieException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonUtilities;

public class TC_RF_018 {
	
	WebDriver driver;
	public void teardown() {
		
		driver.quit();
	}
	
	@Test
	public void verifyRegisteringAccounttoChecktheHeightandWedthofBraces() throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String expectedHeight = "34px";
		String expectedWidth = "701.25px";
		
		//FirstName Field Check
		
		WebElement firstNameField = driver.findElement(By.id("input-firstname"));
		String actualFirstNameFieldHeight = firstNameField.getCssValue("height");
		Assert.assertEquals(actualFirstNameFieldHeight, expectedHeight);
		String actualFirstNameFieldWidth = firstNameField.getCssValue("width");
		Assert.assertEquals(actualFirstNameFieldWidth, expectedWidth);
		
		String expectedFirstNameWarning ="First Name must be between 1 and 32 characters!";
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']//following-sibling::div")).getText(), expectedFirstNameWarning);
		firstNameField = driver.findElement(By.id("input-firstname"));
		firstNameField.sendKeys("N");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		boolean firstNameWarningStatus = false;
		try {
			firstNameWarningStatus = driver.findElement(By.xpath("//input[@id='input-firstname']//following-sibling::div")).isDisplayed();
		}catch(NoSuchElementException e) {
			firstNameWarningStatus = false;
		}
		Assert.assertFalse(firstNameWarningStatus);
		
		firstNameField = driver.findElement(By.id("input-firstname"));
		firstNameField.clear();
		firstNameField.sendKeys("abcdeabcdeabcdeabcdeabcdeabcdeab");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		firstNameWarningStatus = false;
		try {
			firstNameWarningStatus = driver.findElement(By.xpath("//input[@id='input-firstname']//following-sibling::div")).isDisplayed();
		}catch(NoSuchElementException e) {
			firstNameWarningStatus = false;
		}
		Assert.assertFalse(firstNameWarningStatus);
		firstNameField = driver.findElement(By.id("input-firstname"));
		firstNameField.clear();
		firstNameField.sendKeys("abcdeabcdeabcdeabcdeabcdeabcdeabc");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']//following-sibling::div")).getText(), expectedFirstNameWarning);
		
		//LastName Field Check
		
		WebElement lastNameField = driver.findElement(By.id("input-lastname"));
		String actualLastNameFieldHeight = lastNameField.getCssValue("height");
		Assert.assertEquals(actualLastNameFieldHeight, expectedHeight);
		String actualLastNameFieldWidth = lastNameField.getCssValue("width");
		Assert.assertEquals(actualLastNameFieldWidth, expectedWidth);
		
		String expectedLastNameWarning ="Last Name must be between 1 and 32 characters!";
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']//following-sibling::div")).getText(), expectedLastNameWarning);
		lastNameField = driver.findElement(By.id("input-lastname"));
		lastNameField.sendKeys("N");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		boolean lastNameWarningStatus = false;
		try {
			lastNameWarningStatus = driver.findElement(By.xpath("//input[@id='input-lastname']//following-sibling::div")).isDisplayed();
		}catch(NoSuchElementException e) {
			lastNameWarningStatus = false;
		}
		Assert.assertFalse(lastNameWarningStatus);
		
		lastNameField = driver.findElement(By.id("input-lastname"));
		lastNameField.clear();
		lastNameField.sendKeys("abcdeabcdeabcdeabcdeabcdeabcdeab");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		lastNameWarningStatus = false;
		try {
			lastNameWarningStatus = driver.findElement(By.xpath("//input[@id='input-lastname']//following-sibling::div")).isDisplayed();
		}catch(NoSuchElementException e) {
			lastNameWarningStatus = false;
		}
		Assert.assertFalse(lastNameWarningStatus);
		lastNameField = driver.findElement(By.id("input-lastname"));
		lastNameField.clear();
		lastNameField.sendKeys("abcdeabcdeabcdeabcdeabcdeabcdeabc");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']//following-sibling::div")).getText(), expectedLastNameWarning);
		
		//Email Field Check
		
		WebElement emailField = driver.findElement(By.id("input-email"));
		String actualEmailFieldHeight = emailField.getCssValue("height");
		Assert.assertEquals(actualEmailFieldHeight, expectedHeight);
		String actualEmailFieldWidth = emailField.getCssValue("width");
		Assert.assertEquals(actualEmailFieldWidth, expectedWidth);
		emailField.sendKeys("navsdyedgddtdgdjdgdudgdjnvcg@gmail.com");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		boolean emailWarningStatus = false;
		try {
			emailWarningStatus = driver.findElement(By.xpath("//input[@id='input-email']//following-sibling::div")).isDisplayed();
		}catch(NoSuchElementException e) {
			emailWarningStatus = false;
		}
		Assert.assertFalse(emailWarningStatus);
		
		//Telephone Field Check
		

		WebElement telephoneField = driver.findElement(By.id("input-telephone"));
		String actualTelephoneFieldHeight = telephoneField.getCssValue("height");
		Assert.assertEquals(actualTelephoneFieldHeight, expectedHeight);
		String actualTelephoneFieldWidth = telephoneField.getCssValue("width");
		Assert.assertEquals(actualTelephoneFieldWidth, expectedWidth);
		
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']//following-sibling::div")).getText(), expectedTelephoneWarning);
		telephoneField = driver.findElement(By.id("input-telephone"));
		telephoneField.sendKeys("1");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']//following-sibling::div")).getText(), expectedTelephoneWarning);
		telephoneField = driver.findElement(By.id("input-telephone"));
		telephoneField.clear();
		telephoneField.sendKeys("12");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']//following-sibling::div")).getText(), expectedTelephoneWarning);
		telephoneField = driver.findElement(By.id("input-telephone"));
		telephoneField.clear();
		telephoneField.sendKeys("123");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		boolean telephoneWarningStatus = false;
		try {
			telephoneWarningStatus = driver.findElement(By.xpath("//input[@id='input-telephone']//following-sibling::div")).isDisplayed();
		}catch(NoSuchElementException e) {
			telephoneWarningStatus = false;
		}
		Assert.assertFalse(telephoneWarningStatus);
		telephoneField = driver.findElement(By.id("input-telephone"));
		telephoneField.clear();
		telephoneField.sendKeys("12345678901234567890123456789012");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		telephoneWarningStatus = false;
		try {
			telephoneWarningStatus = driver.findElement(By.xpath("//input[@id='input-telephone']//following-sibling::div")).isDisplayed();
		}catch(NoSuchElementException e) {
			telephoneWarningStatus = false;
		}
		Assert.assertFalse(telephoneWarningStatus);
		telephoneField = driver.findElement(By.id("input-telephone"));
		telephoneField.clear();
		telephoneField.sendKeys("123456789012345678901234567890123");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']//following-sibling::div")).getText(), expectedTelephoneWarning);
		
		//Password Field Check
		
		
		WebElement passwordField = driver.findElement(By.id("input-password"));
		String actualPasswordFieldHeight = passwordField.getCssValue("height");
		Assert.assertEquals(actualPasswordFieldHeight, expectedHeight);
		String actualPasswordFieldWidth = passwordField.getCssValue("width");
		Assert.assertEquals(actualPasswordFieldWidth, expectedWidth);
		
		String expectedPasswordWarning ="Password must be between 4 and 20 characters!";
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).getText(), expectedPasswordWarning);
	    passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("1");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).getText(), expectedPasswordWarning);
	    passwordField = driver.findElement(By.id("input-password"));
		passwordField.clear();
		passwordField.sendKeys("12");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).getText(), expectedPasswordWarning);
		passwordField = driver.findElement(By.id("input-password"));
		passwordField.clear();
		passwordField.sendKeys("123");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).getText(), expectedPasswordWarning);passwordField = driver.findElement(By.id("input-password"));
		passwordField.clear();
		passwordField.sendKeys("1234");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).getText(), expectedPasswordWarning);
		boolean passwordWarningStatus = false;
		try {
			passwordWarningStatus = driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).isDisplayed();
		}catch(NoSuchElementException e) {
			passwordWarningStatus = false;
		}
		Assert.assertFalse(passwordWarningStatus);
		passwordField = driver.findElement(By.id("input-password"));
		passwordField.clear();
		passwordField.sendKeys("12345678901234567890");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).getText(), expectedPasswordWarning);
		passwordWarningStatus = false;
		try {
			passwordWarningStatus = driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).isDisplayed();
		}catch(NoSuchElementException e) {
			passwordWarningStatus = false;
		}
		Assert.assertFalse(passwordWarningStatus);
		passwordField = driver.findElement(By.id("input-password"));
		passwordField.clear();
		passwordField.sendKeys("123456789012345678901");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).getText(),expectedPasswordWarning);
		passwordWarningStatus = false;
		try {
			passwordWarningStatus = driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).isDisplayed();
		}catch(NoSuchElementException e) {
			passwordWarningStatus = false;
		}
		Assert.assertTrue(passwordWarningStatus); 
		
		//PasswordConfirm Field
		
		WebElement passwordConfirmField = driver.findElement(By.id("input-confirm"));
		String actualPasswordConfirmFieldHeight = passwordConfirmField.getCssValue("height");
		Assert.assertEquals(actualPasswordConfirmFieldHeight, expectedHeight);
		String actualPasswordConfirmFieldWidth = passwordConfirmField.getCssValue("width");
		Assert.assertEquals(actualPasswordConfirmFieldWidth, expectedWidth);
		
		//Continue Button Field
		
		WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		String actualButtonTextColor = continueButton.getCssValue("color");
		Assert.assertEquals(actualButtonTextColor,"rgba(255, 255, 255, 1)");
		String actualButtonBackgroundColor = continueButton.getCssValue("background-color");
		Assert.assertEquals(actualButtonBackgroundColor,"rgba(34, 154, 200, 1)");
		String actualButtonFontSize = continueButton.getCssValue("font-size");
		Assert.assertEquals(actualButtonFontSize,"12px");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(srcScreenshot,new File(System.getProperty("user.dir")+"\\Screenshots\\AcutalRAPageAligment.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertFalse(CommonUtilities.compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\AcutalRAPageAligment.png", System.getProperty("user.dir")+"\\Screenshots\\ExpectedRAPageAligment.png"));
	
		
		
		
		
	}

}
