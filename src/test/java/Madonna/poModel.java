package Madonna;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class poModel {
	static WebDriver driver;
	@FindBy(xpath="//input[@id='search']")
	static WebElement serachInPutBox;
	@FindBy(xpath="//button[@id='search-icon-legacy']")
	static WebElement serachButton;
}
