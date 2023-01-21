package Madonna;

import static org.junit.Assert.*;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Madonna {
	
	static JavascriptExecutor js;
	static WebElement advertisement;
	static List <WebElement> SearchResults;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Open Browser
		WebDriverManager.chromedriver().setup();
		poModel.driver=new ChromeDriver();
		poModel.driver.manage().window().maximize();
		poModel.driver.get("https://www.youtube.com/");
		poModel.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//Close Browser and exit
		poModel.driver.quit();
	}

	@Test
	public void test1() throws Exception {
		//test1
		//Madonna search
		PageFactory.initElements(poModel.driver, poModel.class);
		poModel.serachInPutBox.sendKeys("madonna");
		poModel.serachButton.click();
		List<WebElement> list;
		boolean condition=true; 
		// searching for the right song loop
		while(condition) {
			list = poModel.driver.findElements(By.xpath("//h3//a[@id='video-title']"));
		    for(int i = 0; i < list.size(); i++) {
		    	if(list.get(i).getText().contains("Justify My Love")) {
		    		list.get(i).click();
		            condition=false;
		            break;
		        }
		   }
		   // scrolling the result screen
		   js=(JavascriptExecutor)poModel.driver;
		   js.executeScript("window,scrollBy(0,5000)","");
		   try {
		   WebElement myDynamicElement = new WebDriverWait(poModel.driver,Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a//yt-formatted-string[contains(@aria-label,'Justify My Love')]")));
		   }
			catch(Exception e) {
				System.out.println(e);	
			}
		}	
		try {
			// advertisement check
			advertisement=poModel.driver.findElement(By.xpath("//DIV//SPAN[@CLASS='ytp-ad-simple-ad-badge']")); 
			assertTrue(advertisement.getAttribute("id").contains("ad"));
			System.out.println("There is an advertisement at the beginning of the clip");
		}
		catch(Exception e) {
			System.out.println("There isn't an advertisement at the beginning of the clip");	
		}	
	}
}

