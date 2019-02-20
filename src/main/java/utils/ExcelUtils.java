package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils{
	
	private Workbook workbook;
	
	public Map<String, String> getMapTestData(String filePath, String fileName, String sheetName, int testCaseRowNumber) throws FileNotFoundException, IOException{
		workbook = getWorkbook(filePath, fileName);
		Sheet sheet = workbook.getSheet(sheetName);
		int columnCount = sheet.getRow(0).getLastCellNum() - 1;
		Map<String, String> testcaseData = new HashMap<String, String>();
		Row headerRow = sheet.getRow(0);
		String key;
		String value;
		for(int i = 1; i <= columnCount; i++) {
			key = headerRow.getCell(i).getCellType().toString().equalsIgnoreCase("numeric")
					? new BigDecimal(headerRow.getCell(i).getNumericCellValue()).toString()
							: headerRow.getCell(i).getStringCellValue();
					if(sheet.getRow(testCaseRowNumber).getCell(i) != null) {
						value = sheet.getRow(testCaseRowNumber).getCell(i).getCellType().toString().equalsIgnoreCase("numeric")
								? new BigDecimal(sheet.getRow(testCaseRowNumber).getCell(i).getNumericCellValue()).toString()
										: sheet.getRow(testCaseRowNumber).getCell(i).getStringCellValue();	
								testcaseData.put(key, value);
					}
					else 
						value = "";
		}
		return testcaseData;
	}

	private Workbook getWorkbook(String filePath, String fileName) throws FileNotFoundException, IOException {
		
		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if(fileExtensionName.equals(".xlsx"))
			workbook = new XSSFWorkbook(inputStream);
		else if(fileExtensionName.equals(".xls"))
			workbook = new HSSFWorkbook(inputStream);
		return workbook;
	} 
}
