package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TrackPage {
	public WebDriver driver ;
	//public Select Se1;
	
	
	public TrackPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	By CalendarDiv = By.xpath("//*[@id='track-dashboard']/div[1]/div/div[1]/div[3]/div");
	By QuickFinder= By.xpath("//input[@class='quick-search']");
	By CalendarBtn=By.linkText("Calendar");
	By ReportsBtn=By.linkText("Reports");
	By OrdersBtn=By.linkText("Orders");
	By Purchase_Analysis_Btn=By.linkText("Purchase Analysis");
	By SavedReports=By.xpath("//a[@class='my-reports']");
	By View_Full_Calendar=By.linkText("View full calendar");
	//By RecentOrdersDropDown=
	//Select Se2 = new Select(driver.findElement(By.xpath("//select[@class='grid-item-control-select']")));
	//Select Se3 = new Select(driver.findElement(By.xpath("//select[@class='grid-item-control-select']")));
	By AllOrdersLink=By.linkText("See all orders");
	By SeeAllQuotes=By.linkText("See all quotes");
	
	public WebElement getQuickFinder()
	{
		return driver.findElement(QuickFinder);
	}
	
	public WebElement getCalendarBtn()
	{
		return driver.findElement(CalendarBtn);
	}
	public WebElement getReportsBtn()
	{
		return driver.findElement(ReportsBtn);
	}
	
	public WebElement getOrdersBtnBtn()
	{
		return driver.findElement(OrdersBtn);
	}
	
	public WebElement get_Purchase_Analysis_BtnBtn()
	{
		return driver.findElement(Purchase_Analysis_Btn);
	}
	
	public WebElement getSavedReports()
	{
		return driver.findElement(SavedReports);
	}
	
	public WebElement getView_Full_Calendar()
	{
		return driver.findElement(View_Full_Calendar);
	}
	
	public WebElement getAllOrdersLink()
	{
		return driver.findElement(AllOrdersLink);
	}
	
	public WebElement getSeeAllQuotes()
	{
		return driver.findElement(SeeAllQuotes);
	}
	
	public WebElement getCalendarDiv()
	{
		return driver.findElement(CalendarDiv);
	}
	
}
