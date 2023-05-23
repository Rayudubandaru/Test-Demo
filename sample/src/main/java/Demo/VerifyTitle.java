package Demo;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitle {
	WebDriver driver;
	
	@Test
	public void login() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		driver.get("https://www.makemytrip.com/");
		String pageTitle=driver.getTitle();
//		String actualTitle="MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
//		Assert.assertEquals(actualTitle, pageTitle);
		System.out.println(pageTitle);
		driver.findElement(By.xpath("//div[@data-cy='LanguageSwitcherWidget']")).click();
		driver.findElement(By.xpath("//p[@data-cy='selectCountry']")).click();
		
		List<WebElement> country=driver.findElements(By.xpath("//div[@data-cy='countryList']/p"));
		for (WebElement NameOfcountry : country) {
			
			String countryName=NameOfcountry.getText();
			if(countryName.equalsIgnoreCase("USA")) {
				NameOfcountry.click();
				break;
			}
			else {
				Assert.assertFalse(true);
				System.err.println();
			    
			}
		}
//		WebElement textUSA=driver.findElement(By.xpath("//div[@data-cy='countryList']/p[contains(text(),'USAAA')]"));
//		
//		if(textUSA.isDisplayed()) {
//			textUSA.click();
//		}
//		else {
//			System.err.println();
//			Assert.assertFalse(true);
//		}
		
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
