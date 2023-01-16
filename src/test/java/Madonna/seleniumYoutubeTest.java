package Madonna;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

//public class seleniumYoutubeTest {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub

		
		public class seleniumYoutubeTest {
			static WebDriver driver;
		    public static void main(String[] args) throws InterruptedException {
		        // set up webdriver
		    	
		    	WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.youtube.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    	
//		        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
//		        WebDriver driver = new ChromeDriver();

		        // navigate to youtube
		    //    driver.get("https://www.youtube.com/");

		        // locate search bar and search for "Madonna"
		        WebElement searchBar = driver.findElement(By.name("search_query"));
		        searchBar.sendKeys("Madonna");
		        searchBar.submit();

		        
		        
		     // locate "justify my love" video and click on it
		        Actions actions = new Actions(driver);
		        WebElement element = null;
		        while (element == null) {
		            actions.moveToElement(driver.findElement(By.tagName("html"))).perform();
		            actions.click();
		            actions.sendKeys(Keys.PAGE_DOWN).perform();
		            element = driver.findElement(By.partialLinkText("Justify My Love"));
		        }
		        element.click();
//		     // scroll down the search result page to locate "justify my love" video 
//	        JavascriptExecutor js = (JavascriptExecutor) driver;
//	        WebElement element = driver.findElement(By.partialLinkText("Justify My Love"));
//	        while (element == null) {
//	            js.executeScript("window.scrollBy(0,1000)");
//	            element = driver.findElement(By.partialLinkText("Justify My Love"));
//	        }
//
//	        // click on the video
//	        element.click();
//		        
//		        
		        // locate "justify my love" video and click on it
	//	        WebElement video = driver.findElement(By.partialLinkText("Justify My Love"));
	 //       video.click();

		        // check if there is an advertisement before the video
		        Thread.sleep(5000); // wait for video to load
		        if (driver.findElements(By.className("videoAdUiSkipButton")).size() > 0) {
		            System.out.println("There is an advertisement before the video.");
		        } else {
		            System.out.println("There is no advertisement before the video.");
		        }

		        // close the browser
		        driver.quit();
		    }
		}		

