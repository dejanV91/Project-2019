package testHomePage;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import constants.ExcelData;
import pageObjects.HomePageObjects;

public class TestLogIn {

	///////////////////////////////////////////////////////////////////////////////////////
	public static final String URL_DASH = "http://localhost/izlet/dashboard.php";
	public static final String URL_NO_LOG = "http://localhost/izlet/processlogin.php";
	////////////////////////////////////////////////////////////////////////////////////////

	// User Log In
	public static void insertOneDataLog(WebDriver dr) {
		System.out.println("--User Log In--");
		String userName, password;
		Scanner input=new Scanner(System.in);
		
		System.out.println("Insert user name: ");
		userName = input.next();
		System.out.println("Insert password: ");
		password = input.next();

		HomePageObjects.setUserNameLog(dr, userName);
		HomePageObjects.setPasswordLog(dr, password);
		HomePageObjects.clickLogInButton(dr);

		if (dr.getCurrentUrl().equals(URL_NO_LOG)) {
			System.out.println("Unsuccessful log in!!");
			HomePageObjects.navigateHome(dr);
		} else {
			System.out.println("Successful log in!!");
		}
		
	}

	// Automation Log in with datas from Excel
	public static void insertLogIn(WebDriver dr, String path, String sheet) {
		try {
			String data;
			ExcelData.setExcelFile(path, sheet);
			Thread.sleep(3000);

			HomePageObjects.navigateHome(dr);
			for (int i = 1; i < ExcelData.getRowCount() + 1; i++) {

				data = ExcelData.getCellData(i, 2);
				HomePageObjects.setUserNameLog(dr, data);

				data = ExcelData.getCellData(i, 4);
				HomePageObjects.setPasswordLog(dr, data);

				HomePageObjects.clickLogInButton(dr);

				// Insert in Excel "pass" or "false"
				// it depends whether the logging is pass or not
				if (dr.getCurrentUrl().equals(URL_DASH)) {
					ExcelData.setCellData("pass", i, 5);
					ExcelData.setCellData("pass", i, 6);
					HomePageObjects.navigateHome(dr);
				} else {
					ExcelData.setCellData("false", i, 5);
					ExcelData.setCellData("false", i, 6);
					HomePageObjects.navigateHome(dr);
				}
			}
			// Save inserted datas in Excel
			ExcelData.saveExcel();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
