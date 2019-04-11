package testDashboard;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import pageObjects.PostObjests;

public class TestDeletePosts {

	// Delete first two posts
	public static void deleteFirstTwoPosts(WebDriver dr) {
		for (int i = 0; i < 2; i++) {
			PostObjests.clickThree(dr, 0);
			PostObjests.clickDelete(dr, 0);
		}
	}

	// Delete large quantities and a specific post
	public static void deleteSomePost(WebDriver dr, int indexPost) {
			
			PostObjests.clickThree(dr, indexPost);
			PostObjests.clickDelete(dr, indexPost);
		}

	// Deleting a specific number of posts
	public static void deletePost(WebDriver dr, int noPost) {

		for (int i = 0; i < noPost; i++) {
			PostObjests.clickThree(dr, 0);
			PostObjests.clickDelete(dr, 0);
		}

	}
}
