package Madonna;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class poModel {
	
	static WebDriver driver;
	
//	@FindBy(id="search")
//	static WebElement serachInPutBox;
	//@FindBy(xpath="//div[@id='sb_ifc50']//input[@id='search']")
	//static List <WebElement> serachResults;
//	@FindBy(id="quantity")
//	static WebElement quantity;
	@FindBy(xpath="//input[@id='search']")
	static WebElement serachInPutBox;
	@FindBy(xpath="//button[@id='search-icon-legacy']")
	static WebElement serachButton;
//	@FindBy(xpath="//DIV//SPAN[@CLASS='ytp-ad-simple-ad-badge']")
//	static WebElement advertisement;
	

}
