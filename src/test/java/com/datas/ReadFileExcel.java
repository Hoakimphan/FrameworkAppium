package com.datas;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFileExcel {
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell= null;
	public ReadFileExcel(String filePath) throws IOException
	{
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}
	public String readData(String sheetName, String col_name, int row_num) throws IOException
	{
		int col_num = -1;
		try
		{
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			for(int i=0; i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(col_name.trim()))
					col_num = i;
			}
			row = sheet.getRow(row_num-1);
			cell = row.getCell(col_num);
			if(cell.getCellTypeEnum()==CellType.STRING)
				return cell.getStringCellValue();
			else if(cell.getCellTypeEnum()==CellType.NUMERIC||cell.getCellTypeEnum()==CellType.FORMULA)
			{
				String cellValue = String.valueOf(cell.getNumericCellValue());
				return cellValue;
			}else if(cell.getCellTypeEnum()==CellType.BLANK)
				return "";
			else return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return "row"+row_num+ "or column"+col_num+"does not exist in Excel";
		}
	}

}
