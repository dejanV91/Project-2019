package testDashboard;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import pageObjects.DashboardPageObjects;
import pageObjects.PostObjests;

public class TestEditPost {
	public static int brPosta;

	// User Edit post
	public static void insertEditPost(WebDriver dr,  String title, String loc, String trans, String desc) {

		// Find post, click on three points field and click on edit field
		PostObjests.getPosts(dr, brPosta);
		PostObjests.clickThree(dr, brPosta);
		PostObjests.clickEdit(dr, brPosta);
		// --------------------------------------------


		// Insert in Title, Location, Walk and Opis fields and then
		// click on Post button
		PostObjests.getEditTitle(dr).clear();
		PostObjests.setEditTitle(dr, title);
		PostObjests.getEditLocation(dr).clear();
		PostObjests.setEditLocation(dr, loc);
		PostObjests.clickWalk(dr, trans);
		PostObjests.getEditOpis(dr).clear();
		PostObjests.setEditOpis(dr, desc);

		PostObjests.clickEditPost(dr);

		// --------------------------------------------------
	}
}
