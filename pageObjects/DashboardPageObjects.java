package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DashboardPageObjects {
////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static final String MAKE_A_POST = "/html[1]/body[1]/div[2]/div[1]/div[3]/a[1]";
	private static final String URL_NEW_POST = "http://localhost/izlet/dashboard.php#";

	private static final String NAZIV = "/html[1]/body[1]/div[1]/div[4]/form[1]/input[1]";
	private static final String LOKACIJA = "/html[1]/body[1]/div[1]/div[4]/form[1]/input[2]";
	private static final String WALK = "/html[1]/body[1]/div[1]/div[4]/form[1]/select[1]";
	private static final String OPIS = "/html[1]/body[1]/div[1]/div[4]/form[1]/textarea[1]";
	private static final String POST_BUTTON = "/html[1]/body[1]/div[1]/div[4]/form[1]/input[3]";
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Go on Dashboard page wherever we are
	public static void navigateDashboard(WebDriver dr) {
		dr.navigate().to(URL_NEW_POST);
	}
	//----------------------------------------------------------

	// Find "Make a post" button
	public static WebElement getMakePost(WebDriver dr) {
		WebElement a = dr.findElement(By.xpath(MAKE_A_POST));
		return a;
	}
	//--------------------------------------------------------
	
	//Click on "Make a post button"
	public static void clickMkPostButton(WebDriver dr) {
		getMakePost(dr).click();
	}
	// -------------------------------------

	// Find Naziv field
	public static WebElement getNaziv(WebDriver dr) {
		WebElement a = dr.findElement(By.xpath(NAZIV));
		return a;
	}

	// Click on Naziv field
	public static void clickNaziv(WebDriver dr) {
		getNaziv(dr).click();
	}
	
	// Set string in Naziv field
	public static void setNaziv(WebDriver dr, String str) {
		getNaziv(dr).sendKeys(str);
	}
	// --------------------------------------------------------

	// Find Lokacija field
	public static WebElement getLokacija(WebDriver dr) {
		WebElement a = dr.findElement(By.xpath(LOKACIJA));
		return a;
	}

	// Click on Lokacija field
	public static void clickLokacija(WebDriver dr) {
		getLokacija(dr).click();
	}
	
	// Set string in Lokacija field
	public static void setLokacija(WebDriver dr, String str) {
		getLokacija(dr).sendKeys(str);
	}
	// --------------------------------------------

	// Click on Walk field and random selection one of a few 
	//way of transport
	public static void clickRandomWalk(WebDriver dr) {
		Select walk = new Select(dr.findElement(By.xpath(WALK)));
		String niz[] = { "Walk", "Car", "Motorbike", "Bicycle", "Bus" };
		int ran = (int) (Math.random() * 5);
		walk.selectByVisibleText(niz[ran]);
	}
	
	
	//Click on Walk field and select one tranport
	public static void clickWalk(WebDriver dr, String nesto) {
		Select walk =new Select(dr.findElement(By.xpath(WALK)));
		walk.selectByVisibleText(nesto);
	}
	// --------------------------------------------
	

	// Find Opis field
	public static WebElement getOpis(WebDriver dr) {
		WebElement a = dr.findElement(By.xpath(OPIS));
		return a;
	}

	// Click on Opis field
	public static void clickOpis(WebDriver dr) {
		getOpis(dr).click();
	}

	// Set string on Opis field
	public static void setOpis(WebDriver dr, String str) {
		getOpis(dr).sendKeys(str);
	}
	// --------------------------------------------

	// Find Post Button
	public static WebElement getPostButton(WebDriver dr) {
		WebElement a = dr.findElement(By.xpath(POST_BUTTON));
		return a;
	}
	
	// Click on Post Button
	public static void clickPostButton(WebDriver dr) {
		getPostButton(dr).click();
	}
	// -------------------------------------
}
