package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import constants.Constant;

public class HomePageObjects {

/////////////////////////////////////////////////////////////////////////////////////////////////////
	private static final String USER_NAME_LOG = "/html[1]/body[1]/div[3]/div[1]/form[1]/input[1]";
	private static final String PASSWORD_LOG = "/html[1]/body[1]/div[3]/div[1]/form[1]/input[2]";
	private static final String FIRST_NAME = "/html[1]/body[1]/div[3]/div[2]/form[1]/input[1]";
	private static final String LAST_NAME = "/html[1]/body[1]/div[3]/div[2]/form[1]/input[2]";
	private static final String USER_NAME_REG = "/html[1]/body[1]/div[3]/div[2]/form[1]/input[3]";
	private static final String EMAIL = "/html[1]/body[1]/div[3]/div[2]/form[1]/input[4]";
	private static final String PASWORD_REG = "/html[1]/body[1]/div[3]/div[2]/form[1]/input[5]";
	private static final String LOG_IN_BUTTON = "/html[1]/body[1]/div[3]/div[1]/form[1]/input[3]";
	private static final String REGISTER_BUTTON = "/html[1]/body[1]/div[3]/div[2]/form[1]/input[6]";
////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Go on Home page wherever we are
	public static void navigateHome(WebDriver dr) {
		dr.navigate().to(Constant.URL);
	}
	// ----------------------------------------------

	// Find First Name field
	public static WebElement getFrstName(WebDriver dr) {
		WebElement a = dr.findElement(By.xpath(FIRST_NAME));
		return a;
	}

	// Click on First Name field
	public static void clickFirstName(WebDriver dr) {
		getFrstName(dr).click();
	}

	// Set string in First Name field
	public static void setFirstName(WebDriver dr, String str) {
		getFrstName(dr).sendKeys(str);
	}
	// --------------------------------------------

	// Find Last Name field
	public static WebElement getLastName(WebDriver dr) {
		WebElement a = dr.findElement(By.xpath(LAST_NAME));
		return a;
	}

	// Click on Last Name field
	public static void clickLastName(WebDriver dr) {
		getLastName(dr).click();
	}

	// Set string in Last Name field
	public static void setLastName(WebDriver dr, String str) {
		getLastName(dr).sendKeys(str);
	}
	// --------------------------------------------

	// Find User Name field
	public static WebElement getUserName(WebDriver dr) {
		WebElement a = dr.findElement(By.xpath(USER_NAME_REG));
		return a;
	}

	// Click User Name field
	public static void clickUserName(WebDriver dr) {
		getUserName(dr).click();
	}

	// Set string in User Name field
	public static void setUserName(WebDriver dr, String str) {
		getUserName(dr).sendKeys(str);
	}
	// --------------------------------------------

	// Find Email field
	public static WebElement getEmail(WebDriver dr) {
		WebElement a = dr.findElement(By.xpath(EMAIL));
		return a;
	}

	// Click on Email field
	public static void clickEmail(WebDriver dr) {
		getEmail(dr).click();
	}

	// Set string in Email field
	public static void setEmail(WebDriver dr, String str) {
		getEmail(dr).sendKeys(str);
	}
	// --------------------------------------------

	// Find Password field
	public static WebElement getPassword(WebDriver dr) {
		WebElement a = dr.findElement(By.xpath(PASWORD_REG));
		return a;
	}

	// Click on Password field
	public static void clickPassword(WebDriver dr) {
		getPassword(dr).click();
	}

	// Set string in Password field
	public static void setPassword(WebDriver dr, String str) {
		getPassword(dr).sendKeys(str);
	}
	// --------------------------------------------

	// Find Register Button
	public static WebElement getRegisterButton(WebDriver dr) {
		WebElement a = dr.findElement(By.xpath(REGISTER_BUTTON));
		return a;
	}

	// Click on Register Button
	public static void clickRegisterButton(WebDriver dr) {
		getRegisterButton(dr).click();
	}
	// --------------------------------------------

	// Find User Name field at the place where is log
	public static WebElement getUserNameLog(WebDriver dr) {
		WebElement a = dr.findElement(By.xpath(USER_NAME_LOG));
		return a;
	}

	// Click on User Name field (Log)
	public static void clickUserNameLog(WebDriver dr) {
		getUserNameLog(dr).click();
	}

	// Set string in User Name field (Log)
	public static void setUserNameLog(WebDriver dr, String str) {
		getUserNameLog(dr).sendKeys(str);
	}
	// --------------------------------------------

	// Find Password field (Log)
	public static WebElement getPasswordLog(WebDriver dr) {
		WebElement a = dr.findElement(By.xpath(PASSWORD_LOG));
		return a;
	}

	// Click on Password field (Log)
	public static void clickPasswordLog(WebDriver dr) {
		getPasswordLog(dr).click();
	}

	// Set string in Password field (Log)
	public static void setPasswordLog(WebDriver dr, String str) {
		getPasswordLog(dr).sendKeys(str);
	}
	// --------------------------------------------

	// Find Log In Button
	public static WebElement getLogInButton(WebDriver dr) {
		WebElement a = dr.findElement(By.xpath(LOG_IN_BUTTON));
		return a;
	}

	// Click on Log In Button
	public static void clickLogInButton(WebDriver dr) {
		getLogInButton(dr).click();
	}
	// --------------------------------------------

}
