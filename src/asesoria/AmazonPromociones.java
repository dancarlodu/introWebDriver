package asesoria;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPromociones {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com.mx/");
		driver.findElement(By.linkText("Promociones")).click();
		List<WebElement> dealList =  driver.findElements(By.id("dealTitle"));
		
		for (WebElement we: dealList) {
			System.out.println(we.getText());
			
			if(we.getText().contains("Sony")) {
				String dealText = we.getText().trim();
			
			
				String [] palabrasPromo = dealText.split(" ");
				for (String s: palabrasPromo) {
					
					if(s.endsWith("%")) {
						System.out.println(s);
						break;
						
					}
						
					
				
				}
			we.click();
			break;
			
			}
		}


	}

}
