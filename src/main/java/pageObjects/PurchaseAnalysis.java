package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseAnalysis {

	public WebDriver driver;

	public PurchaseAnalysis(WebDriver driver ) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;

	}

	By Email=By.xpath("//a[@class='action-icon icon-mail' and text()='Email']");
	By download=By.xpath("//a[@class='action-icon icon-download' and text()='Download']");
	By EAddressField=By.xpath("//input[@type='text' and @name='email_addresses']");
	By SendBtn=By.xpath("//button[@id='send_btn']");
	
	By EmailDialog=By.xpath("(//div[@class='modal-content'])[4]");
	
	public List<WebElement> getEmailDialogCount()
	{
		return driver.findElements(EmailDialog);
	}
	
	public WebElement getEmailDialog()
	{
		return driver.findElement(EmailDialog);
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(Email);
	}

	public WebElement getdownload()
	{
		return driver.findElement(download);
	}
	
	public WebElement getEAddressField()
	{
		return driver.findElement(EAddressField);
	}
	
	public WebElement getSendBtn()
	{
		return driver.findElement(SendBtn);
	}
	
	
	
	
}
