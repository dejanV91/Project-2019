package constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class ExcelData {
	
//////////////////////////////////////////////////////////////////////////////////////////////////
	private static HSSFWorkbook workBook;
	private static HSSFSheet sheet;
	private static HSSFCell cell;
	private static HSSFRow row;
	private static DataFormatter formatter;
	private static int rowCount;
//////////////////////////////////////////////////////////////////////////////////////////////////

	// Returns the number of rows from excel table
	public static int getRowCount() {
		rowCount = sheet.getLastRowNum();
		return rowCount;
	}
	//--------------------------------------------------------------------------------

	// Find Excel file, open it and find a specified sheet
	public static void setExcelFile(String path, String sheetName) throws Exception {
		try {
			FileInputStream excelFile = new FileInputStream(path);
			workBook = new HSSFWorkbook(excelFile);
			sheet = workBook.getSheet(sheetName);
			formatter = new DataFormatter();
		} catch (Exception e) {
			throw (e);
		}
	//---------------------------------------------------------------------------------

	}

	// Return datas from excel's cell
	public static String getCellData(int row, int col) {

		try {
			cell = sheet.getRow(row).getCell(col);
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			return "";
		}
	}
	//-------------------------------------------------------------------------------
	
	// Set specified datas in excel
	public static void setCellData(String result, int rowNum, int colNum) throws Exception {

		row = sheet.getRow(rowNum);
		cell = row.getCell((colNum), MissingCellPolicy.RETURN_BLANK_AS_NULL);

		if (cell == null) {
			cell = row.createCell(colNum);
			cell.setCellValue(result);
		} else {
			cell.setCellValue(result);
		}
	}
	//---------------------------------------------------------------------------------------
	
	// Save entered datas in excel
	public static void saveExcel() {
		try {
			FileOutputStream fileOut = new FileOutputStream(Constant.EXCEL_PATH);
			workBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//---------------------------------------------------------------------------------------------
}
