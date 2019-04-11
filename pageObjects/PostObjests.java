package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PostObjests {

/////////////////////////////////////////////////////////////////////////////////////////////////
	public static final String CLASS_THREE = "fa-ellipsis-v";
	public static final String CLASS_POSTS = "posts";
	public static final String DELETE = "fa-trash-alt";
	public static final String EDIT = "fa-edit";
	public static final String EDIT_TITLE = "title";
	public static final String EDIT_LOCATION = "location";
	public static final String EDIT_TRANSPORT = "transport";
	public static final String EDIT_OPIS = "description";
	public static final String EDIT_POST = "/html[1]/body[1]/div[1]/div[6]/form[1]/input[4]";
//////////////////////////////////////////////////////////////////////////////////////////////////

////////////   Methods for delete     /////////////////////////////////////////////////////////////////

	// Takes as a list all the posts with the same Class Name
	public static WebElement getPosts(WebDriver dr, int a) {
		List<WebElement> posts = dr.findElements(By.className(CLASS_POSTS));
		WebElement e = posts.get(a);
		return e;
	}
	// Find field with three points in one of many posts
	public static WebElement getThree(WebDriver dr, int a) {
		WebElement three = getPosts(dr, a).findElement(By.className(CLASS_THREE));
		return three;
	}
	// Click on field with three points
	public static void clickThree(WebDriver dr, int a) {
		getThree(dr, a).click();
	}
	// Find Delete Button
	public static WebElement getDelete(WebDriver dr, int a) {
		WebElement e = getPosts(dr, a).findElement(By.className(DELETE));
		return e;
	}
	// Click on Delete button
	public static void clickDelete(WebDriver dr, int a) {
		getDelete(dr, a).click();
	}
////////////////////////////////////////////////////////////////////////////////////////

/////////////////  Methods for edit posts  ///////////////////////////////////////////
	
	// Find Edit button 
	public static WebElement getEdit(WebDriver dr, int a) {
		WebElement e = getPosts(dr, a).findElement(By.className(EDIT));
		return e;
	}
	// Click on Edit button
	public static void clickEdit(WebDriver dr, int a) {
		getEdit(dr, a).click();
	}
	//---------------------------------------------------------------

	// Find Title field
	public static WebElement getEditTitle(WebDriver dr) {
		WebElement a = dr.findElement(By.id(EDIT_TITLE));
		return a;
	}
	// Click on Title field
	public static void clickEditTitle(WebDriver dr) {
		getEditTitle(dr).click();
	}
	// Set string on Title field
	public static void setEditTitle(WebDriver dr, String str) {
		getEditTitle(dr).sendKeys(str);
	}
	// --------------------------------------------------------

	// Find Location field
	public static WebElement getEditLocation(WebDriver dr) {
		WebElement a = dr.findElement(By.id(EDIT_LOCATION));
		return a;
	}
	// Click on Location field
	public static void clickEditLocation(WebDriver dr) {
		getEditLocation(dr).click();
	}
	// Set string in Location field
	public static void setEditLocation(WebDriver dr, String str) {
		getEditLocation(dr).sendKeys(str);
	}
	// --------------------------------------------------------

	// Click on Walk field and random selection one of a few 
	//way of transport
	public static void clickEditWalk(WebDriver dr) {
		Select walk = new Select(dr.findElement(By.id(EDIT_TRANSPORT)));
		String niz[] = { "Walk", "Car", "Motorbike", "Bicycle", "Bus" };
		int ran = (int) (Math.random() * 5);
		walk.selectByVisibleText(niz[ran]);
	}
	// --------------------------------------------
	
	//Click on Walk field and select one tranport
	public static void clickWalk(WebDriver dr, String nesto) {
		Select walk =new Select(dr.findElement(By.id(EDIT_TRANSPORT)));
		walk.selectByVisibleText(nesto);
	}
	// --------------------------------------------

	// Find Opis field
	public static WebElement getEditOpis(WebDriver dr) {
		WebElement a = dr.findElement(By.id(EDIT_OPIS));
		return a;
	}
	// Click on Opis field
	public static void clickEditOpis(WebDriver dr) {
		getEditOpis(dr).click();
	}
	// Set string in Opis field
	public static void setEditOpis(WebDriver dr, String str) {
		getEditOpis(dr).sendKeys(str);
	}
	// --------------------------------------------------------

	// Find Post Button
	public static WebElement getEditPost(WebDriver dr) {
		WebElement e = dr.findElement(By.xpath(EDIT_POST));
		return e;
	}
	
	// Click on Post Button
	public static void clickEditPost(WebDriver dr) {
		getEditPost(dr).click();
	}
	//-----------------------------------------------------------

}
