package testDashboard;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import constants.ExcelData;
import pageObjects.DashboardPageObjects;

public class TestDashboard {

	// User make one post
	public static void insertOneDataInPost(WebDriver dr) {
		Scanner input = new Scanner(System.in);
		String naziv, lokacija, opis;
		// Click "Make a post" button
		DashboardPageObjects.clickMkPostButton(dr);

		System.out.println("Creating post: ");
		System.out.println("Insert Title: ");
		naziv = input.next();
		System.out.println("Insert Location: ");
		lokacija = input.next();
		System.out.println("Insert Description: ");
		opis = input.next();

		// Insert datas in Naziv, Lokacija, Walk and Opis fields
		DashboardPageObjects.clickNaziv(dr);
		DashboardPageObjects.setNaziv(dr, naziv);
		DashboardPageObjects.setLokacija(dr, lokacija);
		DashboardPageObjects.clickRandomWalk(dr);
		DashboardPageObjects.setOpis(dr, opis);

		// Click on Post Button
		DashboardPageObjects.clickPostButton(dr);
		
	}

	// Automation insert datas in Post fields from Excel
	public static void insertDataInPost(WebDriver dr, String path, String sheet) throws Exception {

		String data;

		ExcelData.setExcelFile(path, sheet);

		for (int i = 1; i < ExcelData.getRowCount() + 1; i++) {

			DashboardPageObjects.clickMkPostButton(dr);

			DashboardPageObjects.clickNaziv(dr);
			data = ExcelData.getCellData(i, 1);
			DashboardPageObjects.setNaziv(dr, data);

			DashboardPageObjects.clickLokacija(dr);
			data = ExcelData.getCellData(i, 2);
			DashboardPageObjects.setLokacija(dr, data);

			DashboardPageObjects.clickRandomWalk(dr);

			DashboardPageObjects.clickOpis(dr);
			data = ExcelData.getCellData(i, 0);
			DashboardPageObjects.setOpis(dr, data);

			DashboardPageObjects.clickPostButton(dr);

		}
	}

}