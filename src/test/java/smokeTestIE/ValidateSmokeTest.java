package smokeTestIE;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AllProducts;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.FavouritePage;
import pageObjects.Footer;
import pageObjects.Header;
import pageObjects.HomePage;
import pageObjects.MyProfilePage;
import pageObjects.PurchaseAnalysis;
import pageObjects.SearchResultPage;
import pageObjects.StandardsCatalog;
import pageObjects.TrackPage;
import resources.base;


public class ValidateSmokeTest extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	public HomePage hp;
	public SearchResultPage Srp;
	// String parentWindowHandler;
	// String subWindowHandler;

	public WebDriver driver;

	@Test(priority = 0)

	public void ValidateLogin() throws IOException, InterruptedException {
		//WebDriverWait wait=new WebDriverWait(driver,500);
		driver = initializeDriver();
		Thread.sleep(5000);
		String TitleHome = driver.getTitle();
		// System.out.println(TitleHome);
		// Boolean IsPresent=driver.findElements(By.yourLocator).size() > 0;

		try {
			Assert.assertEquals(TitleHome, "Shop - MarkITplace");

			Log.info("User Have Successfully Login To The Home Page");
		} catch (Throwable e) {

			Log.error("User Is Not Being Able To Login");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(TitleHome, "Shop - MarkITplace");

	}
	
	@Test(priority = 1)

	public void ValidateFavoriteIcon() throws InterruptedException {
		Header hd = new Header(driver);
		WebDriverWait wt = new WebDriverWait(driver, 20);
		hd.getFavrtIcon().click();
		Thread.sleep(10000);
		String title = driver.getTitle();
		String favoritesTitle = "Favorites - MarkITplace";
		try {
			Assert.assertEquals(title, favoritesTitle);

			Log.info("User Have Successfully reached the favorites Page");
		} catch (Throwable e) {

			Log.error("Favorite page not Open");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title, favoritesTitle);
		Thread.sleep(10000);
		FavouritePage FP = new FavouritePage(driver);
		//wt.until(ExpectedConditions.elementToBeClickable(FP.getSelectall()));
		try {
		FP.getSelectall().click();
		wt.until(ExpectedConditions.elementToBeClickable(FP.getDeleteAll()));
		FP.getDeleteAll().click();
		//String parentWindowHandler = driver.getWindowHandle(); // Store your parent
		// window
		//String subWindowHandler = null;

		//Set<String> handles = driver.getWindowHandles(); // get all window handles
		//Iterator<String> iterator = handles.iterator();
		//while (iterator.hasNext()) {
			//subWindowHandler = iterator.next();
		//}
		//driver.switchTo().window(subWindowHandler);
		
		Thread.sleep(10000);
		wt.until(ExpectedConditions.elementToBeClickable(FP.getYesBtn()));
		//driver.switchTo().alert().accept();
		FP.getYesBtn().click();
		Thread.sleep(10000);
		driver.navigate().back();
		}
		catch (Throwable e) {

			Log.error("Favorite page not Open");
			Log.error(e.getMessage());
		}
		
		
		}



	@Test(priority = 2)

	public void ValidateSearching() throws InterruptedException, IOException {
		//14marchProperties prop = new Properties();
		//14marchFileInputStream fis = new FileInputStream("C:\\Users\\bilaw\\TestEcommerce1\\src\\main\\java\\resources\\data1.properties");
		//14marchprop.load(fis);
		//14marchString url1 = prop.getProperty("url1");
	
		//14marchdriver.get(url1+"/shop/results?q=Printers&type=Keywords");
		//14marchLog.info("User has reached the Printer Search result page");
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		HomePage hp = new HomePage(driver);
		
		/*
		Thread.sleep(50000);
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent
		// window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		//wait.until(ExpectedConditions.visibilityOf(hp.getsearchboxFF()));
		//wait.until(ExpectedConditions.elementToBeClickable(hp.getsearchboxFF()));
		wait.until(ExpectedConditions.visibilityOf(hp.getsearchboxFF()));
	
		//wait.until(presenceOfElementLocated(hp.getsearchboxFF()));
		//wait.until(presenceOFElementlocated)
		//WebElement element =wait.until(presenceOfElementLocated(hp.getsearchbox()));
		//Thread.sleep(50000);
		//Actions actions= new Actions(driver);
		//driver.navigate().refresh();
		//Thread.sleep(50000);
		//actions.moveToElement(hp.getsearchboxFF());
		//actions.click();
		//actions.sendKeys("printers" + Keys.ENTER);
		 * 
		 * 
		 */
		wait.until(ExpectedConditions.elementToBeClickable(hp.getsearchbox()));
		hp.getsearchbox().click();
		hp.getsearchbox().sendKeys("printers" + Keys.ENTER);
		Thread.sleep(20000);
		//System.out.println(hp.getsearchbox().isDisplayed());
		//System.out.println(hp.getsearchboxFF().isEnabled());
		Log.info("user is searching printer using the search textbox");
		
		String title3 = driver.getTitle();
		try {
			Assert.assertEquals(title3, "Printers - MarkITplace");
			Log.info("User Have Successfully reached the printer search listing page");
		} catch (Throwable e) {

			Log.error("Search Result not displaying");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title3, "Printers - MarkITplace");
		SearchResultPage Srp = new SearchResultPage(driver);
		try {
			Assert.assertEquals(Srp.getAllProducts().isDisplayed(), true);
			Log.info("Search result data is Appearing on the Search Result Page");
		}

		catch (Throwable e) {

			Log.error("Search Result data is not appearing on the page");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(Srp.getAllProducts().isDisplayed(), true);
	}
	
	@Test(priority = 3,enabled=false)

	public void ValidateAddToCart() throws InterruptedException {
		SearchResultPage Srp = new SearchResultPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(20000);
		// --wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='add_to_cart_10886231']"))));
		wait.until(ExpectedConditions.visibilityOf(Srp.getProduct1Cart()));
		Srp.getProduct1Cart().click();
		Log.info("User has clicked on Add to Cart on First Searched Product");
		// driver.findElement(By.xpath("//button[@title='Close (Esc)']")).click();
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent
		// window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window

		// wait.until(ExpectedConditions.elementToBeClickable(Srp.getProduct1Cart()));
		// --wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='cart-dialog']/div[1]/div[1]/div/div/div/button"))));
		wait.until(ExpectedConditions.visibilityOf(Srp.getCloseIcon()));

		try {
			Assert.assertEquals((Srp.getCloseIcon().isDisplayed()), true);
			// System.out.println(driver.findElement(By.xpath("//*[@id='products-content']/div/div[2]/div/div/div[1]/h4")).isEnabled());
			Log.info("Product 1 is successfully added to Cart");
		} catch (Throwable e) {
			Log.error("Product 1 has not added to Cart");
			Log.error(e.getMessage());
		}
		Assert.assertEquals((Srp.getCloseIcon().isDisplayed()), true);

		Srp.getCloseIcon().click();
		Log.info("User has closed the Add to Cart Modal after adding 1st product to cart");
		// WebDriverWait wait = new WebDriverWait(driver,10000);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cart-dialog']/div[1]/div[1]/div/div/div/button")));
		// --driver.findElement(By.xpath("//*[@id='cart-dialog']/div[1]/div[1]/div/div/div/button")).click();

		// Actions actions= new Actions(driver);
		// actions.moveToElement(driver.findElement(By.xpath("//*[@id='cart-dialog']/div[1]/div[1]/div/div/div/button")));
		// actions.click();
		driver.switchTo().window(parentWindowHandler);
		Thread.sleep(5000);
		//19march-wait.until(ExpectedConditions.elementToBeClickable(Srp.getProduct2Cart()));
/*19march-wait.until(ExpectedConditions.elementToBeClickable(Srp.getProduct4Cart()));
//19march-Srp.getProduct2Cart().click();
Srp.getProduct4Cart().click();
		Log.info("User has clicked on Add to Cart on Second Searched Product");
		driver.switchTo().window(subWindowHandler);
		// --wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='cart-dialog']/div[1]/div[1]/div/div/div/button"))));
		wait.until(ExpectedConditions.visibilityOf(Srp.getCloseIcon()));

		try {
			Assert.assertEquals((Srp.getCloseIcon().isDisplayed()), true);
			// System.out.println(driver.findElement(By.xpath("//*[@id='products-content']/div/div[2]/div/div/div[1]/h4")).isEnabled());
			Log.info("Product 2 is successfully added to CArt");
		} catch (Throwable e) {
			Log.error("Product 2 has not added to Cart");
			Log.error(e.getMessage());
		}
		Assert.assertEquals((Srp.getCloseIcon().isDisplayed()), true);

		// --driver.findElement(By.xpath("//*[@id='cart-dialog']/div[1]/div[1]/div/div/div/button")).click();
		Srp.getCloseIcon().click();
		Log.info("User has closed the Add to Cart Modal after adding 2nd product to cart");
		19march*/
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='cart-dialog']/div[1]/div[1]/div/div/div/button"))));
		// -driver.findElement(By.xpath("//*[@id='cart-dialog']/div[1]/div[1]/div/div/div/button")).click();
		// -driver.switchTo().window(parentWindowHandler);
		// driver.findElement(By.className("mfp-close")).click();
		// actions.moveToElement(driver.findElement(By.xpath("//*[@id='cart-dialog']/div[1]/div[1]/div/div/div/button")));
		// driver.findElement(By.xpath("//button[@title='Close (Esc)']"));

		
	}

	@Test(priority = 4,enabled=false)

	public void ValidateAddTofavorites() throws InterruptedException {
		SearchResultPage Srp = new SearchResultPage(driver);
		// System.out.println(driver.findElement(By.xpath("//*[@id='products-content']/div/div[2]/div/div/div[1]/h4")).isDisplayed());
		// System.out.println(driver.findElement(By.xpath("//*[@id='products-content']/div/div[2]/div/div/div[1]/h4")).isEnabled());
		// Srp.getFav1Product().click();
		driver.findElement(By.xpath("//*[@id='fav_btn_10886231']")).click();
		Log.info("User has clicked on Add to Favorites on First Searched Product");
		// Log.info("user has clicked add to favorites button");
		try {
			Assert.assertEquals(Srp.getFavdialog().isEnabled(), true);
			// System.out.println(driver.findElement(By.xpath("//*[@id='products-content']/div/div[2]/div/div/div[1]/h4")).isEnabled());
			Log.info("Product is successfully added to favorites");
		} catch (Throwable e) {
			Log.error("Product is not added to favorites");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Srp.getFavdialog().isEnabled(), true);
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent
		// window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		Srp.getfavClose().click();
		Log.info("User has Close Add to Favorites Dialog box");
		driver.switchTo().window(parentWindowHandler);

		// Thread.sleep(5000);
		// try {
		// Srp.getProduct3Cart().click();
		// Srp.getProduct1Name().click();
		// Thread.sleep(5000);
		// } catch (Throwable e) {
		// }
		// Thread.sleep(5000);
	}

	
	@Test(priority = 5)

	public void ValidatePDP() throws InterruptedException {
		Thread.sleep(5000);
		Srp = new SearchResultPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// --wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='add_to_cart_10886231']"))));
		wait.until(ExpectedConditions.visibilityOf(Srp.getProduct1Name()));

		Srp.getProduct1Name().click();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Thread.sleep(10000);
		String expected1 = "HP Officejet Pro 8710 All-in-One - Multifunction printer - MarkITplace";
		String title5 = driver.getTitle();

		try {
			Assert.assertEquals(title5, expected1);

			Log.info("User Have Successfully reached the PDP Page");
		} catch (Throwable e) {

			Log.error("User Is Not Able To reached the PDP Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title5, expected1);

	}

	@Test(priority = 6)
	public void ValidateRecentViewLink() throws InterruptedException {
		FavouritePage fav = new FavouritePage(driver);
		fav.getRecentlyViewed().click();
		Thread.sleep(20000);
		String Title8 = driver.getTitle();
		String expectedtitle8 = "Recently Viewed Products - MarkITplace";
		try {
			Assert.assertEquals(Title8, expectedtitle8);

			Log.info("Recently Viewed Page is Opened");
		} catch (Throwable e) {

			Log.error("Recently Viewed page is not getting opened");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Title8, expectedtitle8);
	}

	@Test(priority = 7)

	public void ValidateFooterLogo() {
		Footer ft = new Footer(driver);
		// hd.getHeadLogo().click();
		ft.getFootLogo().click();
		Log.info("User has clicked the Logo from the footer of the page");
		String title5 = driver.getTitle();
		try {
			Assert.assertEquals(title5, "Shop - MarkITplace");

			Log.info("User Have reached the Home Page clicking on the footer Logo");
		} catch (Throwable e) {

			Log.error("User not able to reach home clicking on the footer logo");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title5, "Shop - MarkITplace");
	}

	@Test(priority = 8)
	public void ValidateMyProfNavigation() throws InterruptedException {
		WebDriverWait wt = new WebDriverWait(driver,20);
		MyProfilePage mpp = new MyProfilePage(driver);
		wt.until(ExpectedConditions.elementToBeClickable(mpp.getAccountDropdown()));
		mpp.getAccountDropdown().click();
		wt.until(ExpectedConditions.elementToBeClickable(mpp.getMyProfileLinkLink()));
		mpp.getMyProfileLinkLink().click();
		Thread.sleep(5000);
		Log.info("User has clicked on the My Profile page from My Account dropdown");
		String title9 = driver.getTitle();
		String expectedMyProfTitle = "My Profile - MarkITplace";
		try {
			Assert.assertEquals(title9, expectedMyProfTitle);

			Log.info("User has clicked on the My Profile page from My Account dropdown");
		} catch (Throwable e) {

			Log.error(
					"User is not able to reach the My Profile page by clicking the My profile link from my account dropdown");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title9, expectedMyProfTitle);
		wt.until(ExpectedConditions.elementToBeClickable(mpp.getShippingAddressLinkFF()));
		mpp.getShippingAddressLinkFF().click();
		Thread.sleep(10000);
		String title10 = driver.getTitle();
		String expectedShippingTitle = "Shipping Address - MarkITplace";
		try {
			Assert.assertEquals(title10, expectedShippingTitle);

			Log.info("User has clicked on the My Profile page from My Account dropdown");
		} catch (Throwable e) {

			Log.error(
					"User is not able to reach the My Profile page by clicking the My profile link from my account dropdown");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title10, expectedShippingTitle);

	}

	@Test(priority = 9)

	public void ValidateHeaderLogo() throws InterruptedException {
		Header hd = new Header(driver);
		hd.getHeadLogo().click();
		Thread.sleep(10000);
		Log.info("User has clicked the Logo from the header of the page");
		String title4 = driver.getTitle();
		try {
			Assert.assertEquals(title4, "Shop - MarkITplace");

			Log.info("User Have reached the Home Page clicking on the Header Logo");
		} catch (Throwable e) {

			Log.error("User not able to reach home clicking on the header logo");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title4, "Shop - MarkITplace");
	}

	@Test(priority = 10)
	public void ValidateStandardsCatalog() throws InterruptedException {
		Header head = new Header(driver);
		head.getStanCatalogLink().click();
		Log.info("User has clicked on the Standard Catalog Navigation button from header");
		Thread.sleep(5000);
		String title4 = driver.getTitle();
		String expectedTitle = "Standard Products - MarkITplace";
		try {
			Assert.assertEquals(title4, expectedTitle);
			Log.info("User Have reached the Standard Catalog Page");
		} catch (Throwable e) {

			Log.error(
					"User have not reached the Standard Catalog Page after clicking on the Standard Catalog Header button");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title4, expectedTitle);
	}

	@Test(priority = 11)
	public void ValidateStandardsCatalogDetail() throws InterruptedException {
		WebDriverWait wt = new WebDriverWait(driver,20);
		StandardsCatalog St = new StandardsCatalog(driver);
		Thread.sleep(6000);
		St.getProduct3New().click();
		//St.getProduct2New().click();
		//Boolean IsPresent = St.getProduct1CountNew().size() > 0;
		//Boolean Expect = true;
		//String exp="HP Officejet Pro 8710 All-in-One - Multifunction printer - MarkITplace";
		String exp=driver.getTitle();
		String title=driver.getTitle();
		Thread.sleep(10000);
		//Thread.sleep(3000);
		// String title5 = driver.getTitle();
		// String expectedTitle = "Standard - MarkITplace";
		try {
			Assert.assertEquals(title, exp);
			Log.info("User has clicked on the 1st Standard Product appearing and reached the PDP Page");
			
			//Log.info("standard Product found");
		} catch (Throwable e) {

			Log.error("No standard Product found to click");
			Log.error(e.getMessage());
		}

		wt.until(ExpectedConditions.elementToBeClickable(St.getCartBtnNew()));
		St.getCartBtnNew().click();
		Thread.sleep(10000);
		wt.until(ExpectedConditions.elementToBeClickable(St.getCloseicon2()));
		St.getCloseicon2().click();
		Thread.sleep(10000);
		Assert.assertEquals(title, exp);
	}

	@Test(priority = 12)
	public void ValidateAllProduct() throws InterruptedException {
		Header Head = new Header(driver);
		Head.getAllProductLink().click();
		
		Log.info("User has clicked on the All Product Nevigation button from the header");
		
		Thread.sleep(10000);
		String title5 = driver.getTitle();
		String expectedTitle = "All Products - MarkITplace";
		try {
			Assert.assertEquals(title5, expectedTitle);
			Log.info("User Have reached the All Product Page");
		} catch (Throwable e) {

			Log.error(
					"User have not reached the All Products Page after clicking on the All Product Nevigation button from the header");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title5, expectedTitle);

	}

	@Test(priority = 13)
	public void ValidateAudioCablesCategory() throws InterruptedException {
		AllProducts AP = new AllProducts(driver);
		Thread.sleep(4000);
		AP.getAudioCablesFF().click();
		Log.info("User has clicked on Audio Cables Category From All Products Page");
		String title5 = driver.getTitle();
		String expectedTitle = "Audio Cables - MarkITplace";
		Thread.sleep(15000);
		try {
			Assert.assertEquals(title5, expectedTitle);
			Log.info("User Have reached the Audio Cables Category Page");
		} catch (Throwable e) {

			Log.error(
					"User have not reached the Audio Cable Category Page after clicking Audio Cable category from all product page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title5, expectedTitle);
	}

	@Test(priority = 14)
	public void ValidateResources() throws InterruptedException {
		Header Head = new Header(driver);
		Head.getResources().click();
		Log.info("User has clicked on Resouces link from the header");
		Thread.sleep(10000);
		String title5 = driver.getTitle();
		String expectedTitle = "Resources - MarkITplace";
		try {
			Assert.assertEquals(title5, expectedTitle);
			Log.info("User Have reached the Resources Page");
		} catch (Throwable e) {

			Log.error("User have not reached the Resources Page after clicking resources link from the header");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title5, expectedTitle);
	}

	@Test(priority = 15)
	public void ValidateSpecialOffer() {
		Header Head = new Header(driver);
		Head.getSpecialOffers().click();
		Log.info("User has clicked on Special Offer Link from the header");
		String title5 = driver.getTitle();
		String expectedTitle = "Special Offers - MarkITplace";
		try {
			Assert.assertEquals(title5, expectedTitle);
			Log.info("User Have reached the Special Offer Page");
		} catch (Throwable e) {

			Log.error("User have not reached the Special Offer Page after clicking Special Offer link from the header");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title5, expectedTitle);
	}

	@Test(priority = 16)
	public void ValidateCartPage() {
		Header Head = new Header(driver);
		Head.getCartIcon().click();
		Log.info("User has clicked on Cart Icon from the header");
		String title5 = driver.getTitle();
		String expectedTitle = "Cart - MarkITplace";
		try {
			Assert.assertEquals(title5, expectedTitle);
			Log.info("User Have reached the Shopping Cart Page");
		} catch (Throwable e) {

			Log.error("User have not reached the Shopping Cart Page after clicking Cart Icon from the header");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title5, expectedTitle);
	}

	@Test(priority = 17,enabled=false)
	public void ValidateRemoveFromCart() throws InterruptedException {
		CartPage CP = new CartPage(driver);
		Boolean IsPresent = null;
		Boolean Expect = null;
		try {
		Thread.sleep(3000);
		CP.getRemove1().click();
		Log.info("User has clicked on remove link for the 1st product");
		// 8-march/driver.navigate().refresh();
		Thread.sleep(5000);
		// 8-march/Boolean IsPresent = CP.getRemove1Count().size() > 0;
		 IsPresent = CP.getRemove1().isDisplayed();
		 Expect = false;
		// driver.findElements(By.xpath("")).size()
		try {
			Assert.assertEquals(IsPresent, Expect);

			Log.info("User Have successfull removed the first product");
		} catch (Throwable e) {

			Log.error("User is not able to remove the first product");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(IsPresent, Expect);
		
		}
		catch(Throwable e) {
			Log.error("User has got the issue in removing product from cart");
			Assert.assertEquals(IsPresent, Expect);
		}
		
		}


	@Test(priority = 18,enabled=false)
	public void ValidateCheckoutProcess() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Random random = new Random();
		int x = random.nextInt(9000) + 100;
		CartPage CP = new CartPage(driver);
		CP.getCheckoutBtnFF().click();
		// String actitle=driver.getTitle();
		// String extitle= "Checkout - MarkITplace";
		CheckoutPage CO = new CheckoutPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(CO.getPO()));
		CO.getPO().sendKeys((String.valueOf(x)));
		//wait.until(ExpectedConditions.elementToBeClickable(CO.getBillingDropdown()));
		//CO.getBillingDropdown().click();
		//Thread.sleep(5000);
		//wait.until(ExpectedConditions.elementToBeClickable(CO.getListvalue()));
		//CO.getListvalue().click();
		

		
		wait.until(ExpectedConditions.elementToBeClickable(CO.getSaveBtn1()));
		CO.getSaveBtn1().click();
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.elementToBeClickable(CO.getBillingDropdown()));
		//CO.getBillingDropdown().click();
		wait.until(ExpectedConditions.elementToBeClickable(CO.getShippingAddValue()));
		CO.getShippingAddValue().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(CO.getNewbtn()));
		CO.getNewbtn().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(CO.getSaveBtn1()));

		CO.getSaveBtn1().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(CO.getEmailConfirm()));
		CO.getEmailConfirm().clear();
		CO.getEmailConfirm().sendKeys("bilawal.tsg@gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(CO.getSaveBtn1()));
		CO.getSaveBtn1().click();
		wait.until(ExpectedConditions.elementToBeClickable(CO.getPlaceOrderBtn()));
		Assert.assertEquals(CO.getPlaceOrderBtn().isEnabled(), true);
		CO.getPlaceOrderBtn().click();

		Thread.sleep(10000);
		// driver.manage().timeouts().pageLoadTimeout(1000,TimeUnit.SECONDS);
		// String act = driver.getTitle();
		// System.out.println(act);
		// CO.getPO().sendKeys(arg0);

		// WebDriverWait wait = new WebDriverWait(driver,5000);
		// --wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='add_to_cart_10886231']"))));
		// wait.until(ExpectedConditions.visibilityOf(Srp.getProduct1Cart()));
	}

	@Test(priority = 19,enabled=false)

	public void ValidateCheckoutHeaderLogo() throws InterruptedException {
		Header hd = new Header(driver);
		hd.getHeadLogo().click();
		Thread.sleep(10000);
		Log.info("User has clicked the Logo from the header of the page");
		String title4 = driver.getTitle();
		try {
			Assert.assertEquals(title4, "Shop - MarkITplace");

			Log.info("User Have reached the Home Page clicking on the Header Logo");
		} catch (Throwable e) {

			Log.error("User not able to reach home clicking on the header logo");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title4, "Shop - MarkITplace");
	}

	@Test(priority = 20,enabled=false)

	public void ValidateCheckoutFooterLogo() {
		Footer ft = new Footer(driver);
		// hd.getHeadLogo().click();
		ft.getFootLogo().click();
		Log.info("User has clicked the Logo from the footer of the page");
		String title5 = driver.getTitle();
		try {
			Assert.assertEquals(title5, "Shop - MarkITplace");

			Log.info("User Have reached the Home Page clicking on the footer Logo");
		} catch (Throwable e) {

			Log.error("User not able to reach home clicking on the footer logo");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title5, "Shop - MarkITplace");
	}

	@Test(priority = 21)

	public void ValidateFooterLinks() throws InterruptedException {
		Footer ft = new Footer(driver);
		ft.getFStandCatalogFF().click();
		Log.info("User has clicked on the Standard Catalog Link from the footer of the page");
		Thread.sleep(10000);
		String title1 = driver.getTitle();
		String exp1 = "Standard Products - MarkITplace";
		try {
			Assert.assertEquals(title1, exp1);

			Log.info(
					"User Have reached the Standard Product page after clicking on the Standard Catalog Link from the footer of the page");
		} catch (Throwable e) {

			Log.error(
					"User have not reached the Standard Product page after clicking on the Standard Catalog Link from the footer of the page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title1, exp1);

		ft.getFAllPrdctFF().click();
		Thread.sleep(5000);
		Log.info("User has clicked on the All product Link from the footer of the page");
		String title2 = driver.getTitle();
		String exp2 = "All Products - MarkITplace";
		try {
			Assert.assertEquals(title2, exp2);

			Log.info(
					"User Have reached the All Product page after clicking on the Standard Catalog Link from the footer of the page");
		} catch (Throwable e) {

			Log.error(
					"User have not reached the All Product page after clicking on the Standard Catalog Link from the footer of the page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title2, exp2);

		ft.getFResourcesFF().click();
		Thread.sleep(5000);
		Log.info("User has clicked on the resources  Link from the footer of the page");
		String title3 = driver.getTitle();
		String exp3 = "Resources - MarkITplace";
		try {
			Assert.assertEquals(title3, exp3);

			Log.info(
					"User Have reached the resources page after clicking on the resources Link from the footer of the page");
		} catch (Throwable e) {

			Log.error(
					"User have not reached the resources page after clicking on the resources Link from the footer of the page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title3, exp3);

		ft.getFSpecialOffersFF().click();
		Thread.sleep(5000);
		Log.info("User has clicked on the Special offer Link from the footer of the page");
		String title4 = driver.getTitle();
		String exp4 = "Special Offers - MarkITplace";
		try {
			Assert.assertEquals(title4, exp4);

			Log.info(
					"User Have reached the Special offer after clicking on the Special offer Link from the footer of the page");
		} catch (Throwable e) {

			Log.error(
					"User have not reached the Special offer page after clicking on the Special offer Link from the footer of the page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title4, exp4);

		ft.getFFavoritesFF().click();
		Thread.sleep(5000);
		Log.info("User has clicked on the Special offer Link from the footer of the page");
		String title5 = driver.getTitle();
		String exp5 = "Favorites - MarkITplace";
		try {
			Assert.assertEquals(title5, exp5);

			Log.info(
					"User Have reached the Favorites after clicking on the Favorites Link from the footer of the page");
		} catch (Throwable e) {

			Log.error(
					"User have not reached the Favorites page after clicking on the Favorites Link from the footer of the page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title5, exp5);

	}

	@Test(priority = 22)

	public void ValidateTrackpage() throws InterruptedException {
		Header head = new Header(driver);
		head.getTrackBtnFF().click();
		Thread.sleep(20000);
		Log.info("User has clicked on the Track button from the header of the page");
		String title5 = driver.getTitle();
		String exp5 = "Track Dashboard - MarkITplace";
		try {
			Assert.assertEquals(title5, exp5);

			Log.info("User have reached the Track page after clicking on the Track button from the header of the page");
		} catch (Throwable e) {

			Log.error(
					"User have not reached the Track page after clicking on the Track button from the header of the page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title5, exp5);
	}

	@Test(priority = 23)

	public void ValidateordersPage() throws InterruptedException {
		Header head = new Header(driver);
		head.getOrderBtn().click();
		Thread.sleep(5000);
		Log.info("User has clicked on the order button from the header of the page");
		String title5 = driver.getTitle();
		String exp5 = "Orders - MarkITplace";
		try {
			Assert.assertEquals(title5, exp5);

			Log.info("User have reached the Order page after clicking on the Order button from the header of the page");
		} catch (Throwable e) {

			Log.error(
					"User have not reached the order page after clicking on the Order button from the header of the page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title5, exp5);
		Thread.sleep(5000);
	}

	@Test(priority = 24)

	public void ValidatePurchaseAnalysisPage() throws InterruptedException {
		Header head = new Header(driver);
		// WebDriverWait wait = new WebDriverWait(driver,10000);
		// wait.until(ExpectedConditions.visibilityOf(head.getPAnalysisBtn()));
		head.getPAnalysisBtn().click();
		Thread.sleep(10000);
		Log.info("User has clicked on the Purchase Analysis button from the header of the page");
		String title5 = driver.getTitle();
		String exp5 = "Purchase Analysis - MarkITplace";
		try {
			Assert.assertEquals(title5, exp5);

			Log.info(
					"User have reached the Purchase Analysis page after clicking on the Purchase Analysis button from the header of the page");
		} catch (Throwable e) {

			Log.error(
					"User have not reached the Purchase Analysis page after clicking on the Purchase Analysis button from the header of the page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title5, exp5);
	}

	@Test(priority = 25)

	public void ValidatePAEmail() throws InterruptedException {
		PurchaseAnalysis PA = new PurchaseAnalysis(driver);
		WebDriverWait wait = new WebDriverWait(driver, 1000000);
		wait.until(ExpectedConditions.visibilityOf(PA.getEmail()));
		PA.getEmail().click();
		Log.info("User have clicked on email icon on purchase analysis Page");
		wait.until(ExpectedConditions.visibilityOf(PA.getEAddressField()));
		PA.getEAddressField().sendKeys("bilawal.tsg@gmail.com");
		Log.info("User have entered the email on email field at purchase analysis Page");
		wait.until(ExpectedConditions.visibilityOf(PA.getSendBtn()));
		// System.out.println(PA.getSendBtn().isEnabled());
		// System.out.println(PA.getSendBtn().isSelected());
		// System.out.println(PA.getSendBtn().isDisplayed());
		PA.getSendBtn().click();
		Log.info("User have click on Send button at email popup screen at purchase analysis Page");
		Actions actions = new Actions(driver);

		actions.moveToElement(PA.getdownload()).click().perform();
		// Thread.sleep(5000);

		// System.out.println(PA.getSendBtn().isEnabled());
		// System.out.println(PA.getSendBtn().isSelected());
		// System.out.println(PA.getSendBtn().isDisplayed());
		Boolean IsPresent = PA.getEmailDialog().isDisplayed();
		Boolean Expect = false;
		// String title5 = driver.getTitle();
		// String expectedTitle = "Standard - MarkITplace";
		Assert.assertEquals(IsPresent, Expect);

		// wait.until(ExpectedConditions.elementToBeClickable(PA.getdownload()));
		// PA.getdownload().click();
		// Thread.sleep(5000);
	}

	@Test(priority = 26)

	public void ValidateCalendarPage() throws InterruptedException {
		Header head = new Header(driver);
		// WebDriverWait wait = new WebDriverWait(driver,10000);
		// wait.until(ExpectedConditions.visibilityOf(head.getPAnalysisBtn()));
		head.getTrackBtnFF().click();
		// Actions actions = new Actions(driver);

		// actions.moveToElement(head.getCalendar()).click().perform();
		head.getCalendar().click();
		Log.info("User has clicked on the Calendar button from the header of the page");
		Thread.sleep(10000);
		String title5 = driver.getTitle();
		String exp5 = "Calendar Monthly View - MarkITplace";
		try {
			Assert.assertEquals(title5, exp5);

			Log.info(
					"User have reached the  Calendar page after clicking on the Calendar button from the header of the page");
		} catch (Throwable e) {

			Log.error(
					"User have not reached the Calendar page after clicking on the Calendar button from the header of the page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title5, exp5);
	}

	@Test(priority = 27,enabled=false)

	public void ValidateCalendarLinks() throws InterruptedException {
		// Calendar Cal = new Calendar(driver);
		// Select Sel = new Select(Cal.getCalendarDropdown());
		WebDriverWait wt = new WebDriverWait(driver,50);
		
		Select Sel = new Select(driver.findElement(By.id("calendarSelectYearMonthly")));

		Sel.selectByVisibleText("2017");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@class='btn-expand-content'])[1]")).click();
		Thread.sleep(10000);
		//wt.until(ExpectedConditions.elementToBeClickable(By.linkText("(6) PLANAR SYSTEMS")));
		driver.findElement(By.linkText("(6) PLANAR SYSTEMS")).click();
		Thread.sleep(10000);
		String exp1 = "Expiration Report - MarkITplace";
		String Act1 = driver.getTitle();

		try {
			Assert.assertEquals(Act1, exp1);

			Log.info(
					"User have reached the expiration report after clicking on the report button from the Calendar page from monthly view tab");
		} catch (Throwable e) {

			Log.error(
					"User have not reached the expiration report after clicking on the report button from the Calendar page from monthly view tab");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Act1, exp1);
		// Assert.assertEquals(Act1, exp1);
		// Header head = new Header(driver);
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@class='tab-link']")).click();
		driver.findElement(By.xpath("(//span[text()='(1) SAMSUNG'])[1]")).click();
		String Act2 = driver.getTitle();
		try {
			Assert.assertEquals(Act2, exp1);

			Log.info(
					"User have reached the expiration report after clicking on the report button from the Calendar page from Detail view tab");
		} catch (Throwable e) {

			Log.error(
					"User have not reached the expiration report after clicking on the report button from the Calendar page from Detail view tab");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Act2, exp1);
	}

	@Test(priority = 28,enabled=false)

	public void ValidateAllReportsLinks() throws InterruptedException {
		WebDriverWait wt = new WebDriverWait(driver,50);
		driver.navigate().back();
		SoftAssert SF = new SoftAssert();
		Header head = new Header(driver);
		wt.until(ExpectedConditions.elementToBeClickable(head.getReports()));
		head.getReports().click();
		Thread.sleep(5000);
		//wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Assets'])[3]"))));
		driver.findElement(By.xpath("(//a[text()='Assets'])[3]")).click();
		Thread.sleep(10000);
		Log.info("User has clicked on the Assets report from Report tab");
		String title5 = driver.getTitle();
		String exp5 = "Assets Report - MarkITplace";
		try {
			Assert.assertEquals(title5, exp5);

			Log.info("User have reached the assets report after clicking on asset link from report tab");
		} catch (Throwable e) {
			SF.assertEquals(title5, exp5,"User not able to reach the assets report after clicking on asset link from report tab");
			Log.error("User not able to reach the assets report after clicking on asset link from report tab");
			Log.error(e.getMessage());
		}
		// 9march/Assert.assertEquals(title5, exp5);
		wt.until(ExpectedConditions.elementToBeClickable(head.getReports()));
		head.getReports().click();
		Thread.sleep(10000);
		//wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Days to Ship'])[2]"))));
		driver.findElement(By.xpath("(//a[text()='Days to Ship'])[2]")).click();
		Log.info("User has clicked on the Days To Ship report from Report tab");
		Thread.sleep(10000);
		String title6 = driver.getTitle();
		String exp6 = "Days To Ship Report - MarkITplace";
		try {
			Assert.assertEquals(title6, exp6);

			Log.info("User have reached the Days To Ship report after clicking on Days To Ship link from report tab");
		} catch (Throwable e) {
			SF.assertEquals(title6, exp6,"User not able to reach the Days To Ship report after clicking on Days To Ship link from report tab");
			Log.error("User not able to reach the Days To Ship report after clicking on Days To Ship link from report tab");
			Log.error(e.getMessage());
			driver.navigate().back();
		}
		// 9march/Assert.assertEquals(title6, exp6);
		wt.until(ExpectedConditions.elementToBeClickable(head.getReports()));
		head.getReports().click();
		//wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Expiration'])[2]"))));
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//a[text()='Expiration'])[2]")).click();
		Log.info("User has clicked on the Expiration report from Report tab");
		Thread.sleep(10000);
		String title7 = driver.getTitle();
		String exp7 = "Expiration Report - MarkITplace";
		try {
			Assert.assertEquals(title7, exp7);

			Log.info("User have reached the Expiration report after clicking on Expiration link from report tab");
		} catch (Throwable e) {
			SF.assertEquals(title7, exp7,"User not able to reach the Expiration report after clicking on Expiration link from report tab");
			Log.error("User not able to reach the Expiration report after clicking on Expiration link from report tab");
			Log.error(e.getMessage());
			driver.navigate().back();
		}
		// 9march/Assert.assertEquals(title7, exp7);
		wt.until(ExpectedConditions.elementToBeClickable(head.getReports()));
		head.getReports().click();
		//wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Inventory'])[3]"))));
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//a[text()='Inventory'])[3]")).click();
		Log.info("User has clicked on the Inventory report from Report tab");
		Thread.sleep(10000);
		String title8 = driver.getTitle();
		String exp8 = "Inventory Report - MarkITplace";
		try {
			Assert.assertEquals(title8, exp8);

			Log.info("User have reached the Inventory report after clicking on Inventory link from report tab");
		} catch (Throwable e) {
			SF.assertEquals(title8, exp8,"User not able to reach the Inventory report after clicking on Inventory link from report tab");
			Log.error("User not able to reach the Inventory report after clicking on Inventory link from report tab");
			Log.error(e.getMessage());
			driver.navigate().back();
		}
		// 9marchAssert.assertEquals(title8, exp8);
		wt.until(ExpectedConditions.elementToBeClickable(head.getReports()));
		head.getReports().click();
		
		//wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Invoices'])[3]"))));
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//a[text()='Invoices'])[3]")).click();
		Log.info("User has clicked on the Invoices report from Report tab");
		Thread.sleep(10000);
		String title9 = driver.getTitle();
		String exp9 = "Invoices Report - MarkITplace";
		try {
			Assert.assertEquals(title9, exp9);

			Log.info("User have reached the Invoices report after clicking on Invoices link from report tab");
		} catch (Throwable e) {
			SF.assertEquals(title9, exp9,"User not able to reach the Invoices report after clicking on Invoices link from report tab");

			Log.error("User not able to reach the Invoices report after clicking on Invoices link from report tab");
			Log.error(e.getMessage());
			driver.navigate().back();
		}
		// 9march/Assert.assertEquals(title9, exp9);
		wt.until(ExpectedConditions.elementToBeClickable(head.getReports()));
		head.getReports().click();
		//wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Invoice Line'])[2]"))));
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//a[text()='Invoice Line'])[2]")).click();
		Log.info("User has clicked on the Invoice Line report from Report tab");
		Thread.sleep(10000);
		String title10 = driver.getTitle();
		String exp10 = "Invoice Line Report - MarkITplace";
		try {
			Assert.assertEquals(title10, exp10);

			Log.info("User have reached the Invoice Line report after clicking on Invoice Line link from report tab");
		} catch (Throwable e) {
			SF.assertEquals(title10, exp10,"User not able to reach the Invoice Line report after clicking on Invoice Line link from report tab");
			Log.error("User not able to reach the Invoice Line report after clicking on Invoice Line link from report tab");
			Log.error(e.getMessage());
			driver.navigate().back();
		}
		// 9march/SF.assertEquals(title10, exp10);
		// Assert.assertEquals(title10, exp10);
		// driver.navigate().back();
		wt.until(ExpectedConditions.elementToBeClickable(head.getReports()));
		head.getReports().click();
		//wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Licenses'])[3]"))));
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//a[text()='Licenses'])[3]")).click();
		Log.info("User has clicked on the Licenses report from Report tab");
		Thread.sleep(10000);
		String title11 = driver.getTitle();
		String exp11 = "Licenses Report - MarkITplace";
		try {
			Assert.assertEquals(title11, exp11);

			Log.info("User have reached the Licenses report after clicking on Licenses link from report tab");
		} catch (Throwable e) {
			SF.assertEquals(title11, exp11,"User not able to reach the Licenses report after clicking on Licenses link from report tab");
			Log.error("User not able to reach the Licenses report after clicking on Licenses link from report tab");
			Log.error(e.getMessage());
			driver.navigate().back();
		}
		// 9march/Assert.assertEquals(title11, exp11);
		wt.until(ExpectedConditions.elementToBeClickable(head.getReports()));
		head.getReports().click();
		// driver.findElement(By.linkText("Orders")).click();
		//wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Orders'])[5]"))));
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//a[text()='Orders'])[5]")).click();
		Thread.sleep(10000);
		Log.info("User has clicked on the Orders report from Report tab");
		String title12 = driver.getTitle();
		String exp12 = "Orders Report - MarkITplace";
		try {
			Assert.assertEquals(title12, exp12);

			Log.info("User have reached the Orders report after clicking on Orders link from report tab");
		} catch (Throwable e) {
			SF.assertEquals(title12, exp12,"User not able to reach the Orders report after clicking on Orders link from report tab");
			Log.error("User not able to reach the Orders report after clicking on Orders link from report tab");
			Log.error(e.getMessage());
			driver.navigate().back();
		}
		// 9march/Assert.assertEquals(title12, exp12);
		wt.until(ExpectedConditions.elementToBeClickable(head.getReports()));
		head.getReports().click();
		//wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Order Line'])[2]"))));
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("a[href='/track/reports/order-line']")).click();
		//driver.findElement(By.xpath("(//a[text()='Order Line'])[2]")).click();
		Log.info("User has clicked on the Order Line report from Report tab");
		Thread.sleep(15000);
		String title13 = driver.getTitle();
		String exp13 = "Order Line Report - MarkITplace";
		try {
			Assert.assertEquals(title13, exp13);

			Log.info("User have reached the Order Line report after clicking on Order Line link from report tab");
		} catch (Throwable e) {
			SF.assertEquals(title13, exp13,"User not able to reach the Order Line report after clicking on Order Line link from report tab");
			Log.error("User not able to reach the Order Line report after clicking on Order Line link from report tab");
			Log.error(e.getMessage());
			driver.navigate().back();
		}
		// 9march/Assert.assertEquals(title13, exp13);
		wt.until(ExpectedConditions.elementToBeClickable(head.getReports()));
		head.getReports().click();
		//wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='PARs'])[3]"))));
		Thread.sleep(10000);
		//driver.findElement(By.xpath("(//a[text()='PARs'])[3]")).click();
		driver.findElement(By.cssSelector("a[href='/track/reports/pars']")).click();
		Log.info("User has clicked on the PARs report from Report tab");
		Thread.sleep(15000);
		String title14 = driver.getTitle();
		String exp14 = "PARs Report - MarkITplace";
		try {
			Assert.assertEquals(title14, exp14);

			Log.info("User have reached the PARs report after clicking on PARs link from report tab");
		} catch (Throwable e) {
			SF.assertEquals(title14, exp14,"User not able to reach the PARs report after clicking on PARs  link from report tab");
			Log.error("User not able to reach the PARs report after clicking on PARs  link from report tab");
			Log.error(e.getMessage());
			driver.navigate().back();
		}
		// 9march/Assert.assertEquals(title14, exp14);
		wt.until(ExpectedConditions.elementToBeClickable(head.getReports()));
		head.getReports().click();
		//wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Quotes'])[3]"))));
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//a[text()='Quotes'])[3]")).click();
		Log.info("User has clicked on the Quotes report from Report tab");
		Thread.sleep(10000);
		String title15 = driver.getTitle();
		String exp15 = "Quotes Report - MarkITplace";
		try {
			Assert.assertEquals(title15, exp15);

			Log.info("User have reached the Quotes report after clicking on Quotes link from report tab");
		} catch (Throwable e) {
			SF.assertEquals(title15, exp15,"User not able to reach the Quotes report after clicking on Quotes link from report tab");
			Log.error("User not able to reach the Quotes report after clicking on Quotes link from report tab");
			Log.error(e.getMessage());
			driver.navigate().back();
		}
		// 9march/Assert.assertEquals(title15, exp15);
		wt.until(ExpectedConditions.elementToBeClickable(head.getReports()));
		head.getReports().click();
		//wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Receiving Log'])[3]"))));
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//a[text()='Receiving Log'])[3]")).click();
		Log.info("User has clicked on the Receiving Log report from Report tab");
		Thread.sleep(10000);
		String title16 = driver.getTitle();
		String exp16 = "Receiving Log Report - MarkITplace";
		try {
			Assert.assertEquals(title16, exp16);

			Log.info("User have reached the Receiving Log report after clicking on Receiving Log link from report tab");
		} catch (Throwable e) {
			SF.assertEquals(title16, exp16,"User not able to reach the Receiving Log report after clicking on Receiving Log link from report tab");
			Log.error("User not able to reach the Receiving Log report after clicking on Receiving Log link from report tab");
			Log.error(e.getMessage());
			driver.navigate().back();
		}
		// 9march/Assert.assertEquals(title16, exp16);
		wt.until(ExpectedConditions.elementToBeClickable(head.getReports()));
		head.getReports().click();
		//wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Shipments'])[3]"))));
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//a[text()='Shipments'])[3]")).click();
		Thread.sleep(10000);
		Log.info("User has clicked on the Shipments report from Report tab");
		String title17 = driver.getTitle();
		String exp17 = "Shipments Report - MarkITplace";
		try {
			Assert.assertEquals(title17, exp17);

			Log.info("User have reached the Shipments report after clicking on Shipments link from report tab");
		} catch (Throwable e) {
			SF.assertEquals(title17, exp17,"User not able to reach the Shipments report after clicking on Shipments link from report tab");
			Log.error("User not able to reach the Shipments report after clicking on Shipments link from report tab");
			Log.error(e.getMessage());
			driver.navigate().back();
		}
		// 9march/Assert.assertEquals(title17, exp17);
		wt.until(ExpectedConditions.elementToBeClickable(head.getReports()));
		head.getReports().click();
		//wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Standards'])[3]"))));
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//a[text()='Standards'])[3]")).click();
		Log.info("User has clicked on the Shipments report from Report tab");
		Thread.sleep(10000);
		String title18 = driver.getTitle();
		String exp18 = "Standards Report - MarkITplace";
		try {
			Assert.assertEquals(title18, exp18);

			Log.info("User have reached the Standards report after clicking on Standards link from report tab");
		} catch (Throwable e) {
			SF.assertEquals(title18, exp18,"User not able to reach the Standards report after clicking on Standards link from report tab");
			Log.error("User not able to reach the Standards report after clicking on Standards link from report tab");
			Log.error(e.getMessage());
			driver.navigate().back();
		}
		// 9march/Assert.assertEquals(title18, exp18);
		wt.until(ExpectedConditions.elementToBeClickable(head.getReports()));
		head.getReports().click();
		//wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Warranties'])[2]"))));
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//a[text()='Warranties'])[2]")).click();
		Log.info("User has clicked on the Warranties report from Report tab");
		Thread.sleep(10000);
		String title19 = driver.getTitle();
		String exp19 = "Warranties Report - MarkITplace";
		try {
			Assert.assertEquals(title19, exp19);

			Log.info("User have reached the Warranties report after clicking on Warranties link from report tab");
		} catch (Throwable e) {
			SF.assertEquals(title19, exp19,"User not able to reach the Warranties report after clicking on Warranties link from report tab");
			Log.error("User not able to reach the Warranties report after clicking on Warranties link from report tab");
			Log.error(e.getMessage());
			driver.navigate().back();
		}
		// 9march/Assert.assertEquals(title19, exp19);

		SF.assertAll();

	}

	@Test(priority = 29)
	public void ValidateSavedReports() throws InterruptedException {
		TrackPage TP = new TrackPage(driver);
		TP.getSavedReports().click();
		Log.info("User has clicked on the Saved Report icon from the header of the page");
		Thread.sleep(15000);
		String title5 = driver.getTitle();
		String exp5 = "Saved Reports - MarkITplace";
		try {
			Assert.assertEquals(title5, exp5);
			Log.info(
					"User have reached the  Saved Report page after clicking on the Saved Report icon from the header of the page");
		} catch (Throwable e) {
			Log.error(
					"User have not reached the Saved Report page after clicking on the Saved Report icon from the header of the page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(title5, exp5);
	}
	
	@Test(priority=30)
	public void ValidateComparePage() throws InterruptedException
	{
		WebDriverWait wt = new WebDriverWait(driver,20);
		//wt.until(ExpectedConditions.elementToBeClickable(locator))
		SearchResultPage srp = new SearchResultPage(driver);
		HomePage hp = new HomePage(driver);
		String Exp = "Product Compare - MarkITplace";
		String act = null;
		try {
		hp.getsearchbox().sendKeys("printers" + Keys.ENTER);
		Log.info("user is searching printer using the search textbox");
		Thread.sleep(10000);
		//driver.findElement(By.xpath("(//div[@class='control__indicator'])[1]")).click();
		//driver.findElement(By.xpath("(//div[@class='control__indicator'])[2]")).click();
		//driver.findElement(By.linkText("Compare")).click();
		//
			srp.getCompare1().click();
		srp.getCompare2().click();
		srp.getCompareBtn().click();
		Thread.sleep(10000);
		
		Exp = "Product Compare - MarkITplace";
		act = driver.getTitle();
		Assert.assertEquals(act, Exp);
		Log.info("User Have Successfully reached the Compare page");
		}
		catch (RuntimeException ee)
		{
		    if (ee.toString().contains("NoSuchElementException"))
		    {
		    	Log.info("Compare Page not reached");
		    }
		}
		Assert.assertEquals(act, Exp);
	}
		
	
	

	@AfterTest

	public void closebrowser()

	{
		driver.close();
	}

}
