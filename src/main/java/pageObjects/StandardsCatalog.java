package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StandardsCatalog {
	public WebDriver driver;
	
	public StandardsCatalog(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	By Product1 = By.xpath("//img[@alt='10032.']");
	
	By Product1New=By.xpath("//img[@alt='Miraca monitor']");
	By Add2cartbtn=By.xpath("//a[@id='add_to_cart_desk_10886231");
	By Closeicon=By.xpath("(//button[@title='Close (Esc)'])[2]");
	By Closeicon2=By.xpath("(//button[@class='mfp-close' and @type='button'])[1]");
	By Product2New=By.xpath("//img[@alt='OfficeJet']");
	By Product3New=By.xpath("(//a[@class='image-link hitProductForDetail'])[1]");
	By Cartbtn1=By.xpath("//a[@id='add_to_cart_desk_10886231']");
	By CartBtnNew=By.xpath("//a[text()='Add to Cart ']");
	
	public WebElement getCartBtnNew()
	{
		return driver.findElement(CartBtnNew);
	}
	public WebElement getCloseicon2()
	{
		return driver.findElement(Closeicon2);
	}
	
	
	public WebElement getCartbtn1()
	{
		return driver.findElement(Cartbtn1);
	}
	public WebElement getProduct3New()
	{
		return driver.findElement(Product3New);
	}
	public WebElement getProduct2New()
	{
		return driver.findElement(Product2New);
	}
	
	public WebElement getCloseicon()
	{
		return driver.findElement(Closeicon);
	}
	
	public WebElement getAdd2cartbtn()
	{
		return driver.findElement(Add2cartbtn);
	}
	
	
	public WebElement getProduct1()
	{
		return driver.findElement(Product1);
	}
	
	public List<WebElement> getProduct1Count()
	{
		return driver.findElements(Product1);
	}
	
	public WebElement getProduct1New()
	{
		return driver.findElement(Product1New);
	}
	
	public List<WebElement> getProduct1CountNew()
	{
		return driver.findElements(Product1New);
	}

}
