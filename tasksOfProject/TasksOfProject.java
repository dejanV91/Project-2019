package tasksOfProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import constants.Constant;
import pageObjects.HomePageObjects;
import testDashboard.TestDashboard;
import testDashboard.TestDeletePosts;
import testDashboard.TestEditPost;
import testHomePage.TestLogIn;
import testHomePage.TestRegistration;

public class TasksOfProject {

	public static void Tasks() throws InterruptedException {
		WebDriver dr = new ChromeDriver();
		dr.get(Constant.URL);
		dr.manage().window().maximize();
		Thread.sleep(2000);

		try {

			// (1) User registration
			TestRegistration.insertOneReg(dr);

			// (2) Registration with a set of data from Excel
			TestRegistration.InsertDatasInReg(dr, Constant.EXCEL_PATH, Constant.SHEET_NAME);

			// (3) User Log In
			TestLogIn.insertOneDataLog(dr);
			HomePageObjects.navigateHome(dr);

			// (4) Log in with set of data from Excel
			TestLogIn.insertLogIn(dr, Constant.EXCEL_PATH, Constant.SHEET_NAME);

			// (5) User creating posts
			TestLogIn.insertOneDataLog(dr);
			TestDashboard.insertOneDataInPost(dr);

			// (6) Automation create posts
			TestDashboard.insertDataInPost(dr, Constant.EXCEL_PATH, Constant.SHEET_NAME_TEKST);

			// (7) Delete the first two posts
			TestDeletePosts.deleteFirstTwoPosts(dr);

			// (8) Delete a specific number of posts
			TestDeletePosts.deleteSomePost(dr);

			// (9) Edit post
			TestEditPost.insertEditPost(dr, 3);
			
			// Delete more
			TestDeletePosts.deletePost(dr);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
