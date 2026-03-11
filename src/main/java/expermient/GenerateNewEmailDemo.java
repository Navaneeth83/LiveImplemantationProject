package expermient;

import java.util.Date;

public class GenerateNewEmailDemo {

	public static void main(String[] args) {
		
		 System.out.println(generateBrandNewEmail ());
		
	}
   
	public static String generateBrandNewEmail () {
		
		Date date = new Date();
		String dateString = date.toString();
		String dateWithoutSpaces = dateString.replaceAll("\\s","");
	    String dateWithoutSpacesAndColons = dateWithoutSpaces.replaceAll("\\:","");
	    String brandNewEmail = dateWithoutSpacesAndColons+"@gmail.com";
	    return brandNewEmail;
	    
	}
} 
 