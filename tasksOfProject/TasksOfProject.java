package tasksOfProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import constants.Constant;
import constants.ExcelData;
import gui.GuiDeleteAuto;
import gui.GuiRegistration;
import pageObjects.HomePageObjects;
import testDashboard.TestDashboard;
import testDashboard.TestDeletePosts;
import testDashboard.TestEditPost;
import testHomePage.TestLogIn;
import testHomePage.TestRegistration;

public class TasksOfProject {

	public static void automationTest() throws Exception {
		WebDriver dr = new ChromeDriver();
		dr.get(Constant.URL);
		dr.manage().window().maximize();
		Thread.sleep(2000);

		// (1) Registration with a set of data from Excel
		TestRegistration.InsertDatasInReg(dr, Constant.EXCEL_PATH, Constant.SHEET_NAME);

		// (2) Log in with set of data from Excel
		TestLogIn.insertLogIn(dr, Constant.EXCEL_PATH, Constant.SHEET_NAME);

		// (3) Automation create posts
		String a, b;
		ExcelData.setExcelFile(Constant.EXCEL_PATH, Constant.SHEET_NAME);
		a = ExcelData.getCellData(1, 2);
		b = ExcelData.getCellData(1, 4);
		TestLogIn.insertOneDataLog(dr, a, b);
		TestDashboard.insertDataInPost(dr, Constant.EXCEL_PATH, Constant.SHEET_NAME_TEKST);

		// (4) Delete the first two posts
		TestDeletePosts.deleteFirstTwoPosts(dr);

		// (5) Delete more
		GuiDeleteAuto.GuiDeleteAuto(dr);
	}

	public static void manualTest() throws InterruptedException {
		WebDriver dr = new ChromeDriver();
		dr.get(Constant.URL);
		dr.manage().window().maximize();
		Thread.sleep(2000);

		GuiRegistration.GuiReg(dr);

	}

}
