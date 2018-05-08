package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PDP {
	
	public WebDriver driver ;
	//public Select Se1;
	
	
	public PDP(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	By favoriteIcon= By.xpath("//a[@class='my-lists' and text()='Favorites']");
		
	public WebElement getfavoriteIcon()
	{
		return driver.findElement(favoriteIcon);
		
	}
}
