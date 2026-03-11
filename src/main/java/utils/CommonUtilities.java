package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CommonUtilities {
	
      public static String generateBrandNewEmail() {
		
		Date date = new Date();
		String dateString = date.toString();
		String dateWithoutSpaces = dateString.replaceAll("\\s","");
	    String dateWithoutSpacesAndColons = dateWithoutSpaces.replaceAll("\\:","");
	    String brandNewEmail = dateWithoutSpacesAndColons+"@gmail.com";
	    return brandNewEmail;
	}
      
     public static boolean compareTwoScreenshots(String actualImagePath, String excpectedImagePath) throws IOException {
    	 
    	 BufferedImage BufferedactualImage = ImageIO.read(new File(actualImagePath));
    	 BufferedImage BufferedExcpectedImage = ImageIO.read(new File(excpectedImagePath));
    	 ImageDiffer differ = new ImageDiffer();
    	ImageDiff imageDiff = differ.makeDiff(BufferedExcpectedImage, BufferedactualImage);
    	return imageDiff.hasDiff();
    	 
     }
     
     public static void takeScreenshot(WebDriver driver, String screenshotPath) {
    	 
    	 TakesScreenshot ts = (TakesScreenshot)driver;
 		File srsScreenshots = ts.getScreenshotAs(OutputType.FILE);
 		try {
 			FileHandler.copy(srsScreenshots, new File(screenshotPath));
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    	 
    	 
     }
        
}
