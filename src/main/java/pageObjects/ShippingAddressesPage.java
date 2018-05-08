package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressesPage {
	public WebDriver driver ;
	//public Select Se1;
	
	
	public ShippingAddressesPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	Select Se3 = new Select(driver.findElement(By.className("state-filter")));
	Select Se4 = new Select(driver.findElement(By.className("city-filter")));
	
	By SearchAddress= By.className("search-for-address");
	Select Se5 = new Select(driver.findElement(By.id("address-select")));
	By Add_NewAddressBtn= By.linkText("Add New Address");
	By ClearSearch= By.linkText("Clear search");
	By MyProfile= By.linkText("My Profile");
	
	public WebElement getSearchAddress()
	{
		return driver.findElement(SearchAddress);
	}
	
	
	public WebElement getAdd_NewAddressBtn()
	{
		return driver.findElement(Add_NewAddressBtn);
	}
	
	public WebElement getClearSearch()
	{
		return driver.findElement(ClearSearch);
	}
	
	public Select getStateFilter()
	{
		return Se3;
	}
	
	public Select getCityFilter()
	{
		return Se4;
	}
	public Select getAddressDropdown()
	{
		return Se5;
	}
	
	public WebElement getMyProfile()
	{
		return driver.findElement(MyProfile);
	}
	
}
