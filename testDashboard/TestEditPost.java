package testDashboard;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import pageObjects.PostObjests;

public class TestEditPost {
	
	// User Edit post
	public static void insertEditPost(WebDriver dr, int brPosta) {
		
		// Find post, click on three points field and click on edit field
		PostObjests.getPosts(dr, brPosta);
		PostObjests.clickThree(dr, brPosta);
		PostObjests.clickEdit(dr, brPosta);
		//--------------------------------------------
		
		String a,b,c;
		Scanner input= new Scanner(System.in);
		System.out.println("Insert Title: ");
		a=input.next();
		System.out.println("Insert Location: ");
		b=input.next();
		System.out.println("Insert Description: ");
		c=input.next();
		
		// Insert in Title, Location, Walk and Opis fields and then
		// click on Post button
		PostObjests.getEditTitle(dr).clear();
		PostObjests.setEditTitle(dr, a);
		PostObjests.getEditLocation(dr).clear();
		PostObjests.setEditLocation(dr, b);
		PostObjests.clickEditWalk(dr);
		PostObjests.getEditOpis(dr).clear();
		PostObjests.setEditOpis(dr, c);
		
		PostObjests.clickEditPost(dr);
		
		//--------------------------------------------------
	}
}
