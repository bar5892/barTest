package Madonna;

import java.time.Duration;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Madonna {
	
	static JavascriptExecutor js;
	static WebElement advertisement;
	static List <WebElement> SearchResults;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		WebDriverManager.chromedriver().setup();
		poModel.driver=new ChromeDriver();
		poModel.driver.manage().window().maximize();
		poModel.driver.get("https://www.youtube.com/");
		poModel.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		poModel.driver.quit();
	}

	@Test
	public void test1() throws Exception {
		//test1
		try {
			PageFactory.initElements(poModel.driver, poModel.class);
			poModel.serachInPutBox.sendKeys("madonna");
			poModel.serachButton.click();
			List<WebElement> list;
			boolean condishen = true; 
			while (condishen){
				list = poModel.driver.findElements(By.xpath("//h3//a[@id='video-title']"));
		        System.out.println("size list is : "+list.size());
		        for (int i = 0; i < list.size(); i++) {
		        	if (list.get(i).getText().contains("Justify My Love")){
		        		System.out.println(list.get(i).getText());
		                list.get(i).click();
		                condishen=false;
		                break;
		            }
		        }
		        js = (JavascriptExecutor) poModel.driver;
		        js.executeScript("window,scrollBy(0,5000)","");
		        Thread.sleep(5000);
		    }	
			try {
				advertisement = poModel.driver.findElement(By.xpath("//DIV//SPAN[@CLASS='ytp-ad-simple-ad-badge']"));           
				System.out.println("Test pass: There is an advertisement at the beginning of the clip");
		    }
		    catch(Exception e) {
		    	System.out.println("Test fail: There isn't an advertisement at the beginning of the clip");
		    }
		}
		catch(Exception e) {
			System.out.println("Error test : " +e);
		}
	}
}


