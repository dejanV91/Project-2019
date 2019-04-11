package testHomePage;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;

import constants.ExcelData;
import pageObjects.HomePageObjects;

public class TestRegistration {

//////////// User insert datas in register fields at Home Page//////////////////

	public static void insertOneReg(WebDriver dr, String firstName, String lastName, String userName, String email,
			String password) {

		HomePageObjects.setFirstName(dr, firstName);
		HomePageObjects.setLastName(dr, lastName);
		HomePageObjects.setUserName(dr, userName);
		HomePageObjects.setEmail(dr, email);
		HomePageObjects.setPassword(dr, password);
		HomePageObjects.clickRegisterButton(dr);

		

	}

////////////  Automation insert datas in Register fields  /////////////////////////////////

	public static void InsertDatasInReg(WebDriver dr, String path, String sheet) throws Exception {
		String data, email;

		ExcelData.setExcelFile(path, sheet);
		Thread.sleep(3000);

		for (int i = 1; i < ExcelData.getRowCount() + 1; i++) {

			HomePageObjects.clickFirstName(dr);
			data = ExcelData.getCellData(i, 0);
			HomePageObjects.setFirstName(dr, data);

			HomePageObjects.clickLastName(dr);
			data = ExcelData.getCellData(i, 1);
			HomePageObjects.setLastName(dr, data);

			HomePageObjects.clickUserName(dr);
			data = ExcelData.getCellData(i, 2);
			HomePageObjects.setUserName(dr, data);

			HomePageObjects.clickEmail(dr);
			email = ExcelData.getCellData(i, 3);
			HomePageObjects.setEmail(dr, email);

			HomePageObjects.clickPassword(dr);
			data = ExcelData.getCellData(i, 4);
			HomePageObjects.setPassword(dr, data);

			HomePageObjects.clickRegisterButton(dr);
			Thread.sleep(1000);

			// If the email is not a specific form, delete all datas from all fields
			Pattern sablon = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+(.+)[a-zA-Z]{2,6}$");
			Matcher m = sablon.matcher(email);
			if (!m.find()) {
				HomePageObjects.getFrstName(dr).clear();
				HomePageObjects.getLastName(dr).clear();
				HomePageObjects.getUserName(dr).clear();
				HomePageObjects.getEmail(dr).clear();
				HomePageObjects.getPassword(dr).clear();
			}
		}
	}
}
