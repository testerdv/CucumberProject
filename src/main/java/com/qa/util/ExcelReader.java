package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private String excelPath;
	private String sheetName;
	
	public ExcelReader(String path,String sheetName) {
	 this.excelPath=path;	
	 this.sheetName=sheetName;
	}
	
	/*public List readExcel(int rownum) {
		List<String> excelRowValues=new ArrayList<>();
		
		try {
			FileInputStream fis=new FileInputStream(new File(excelPath));
			
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			
			XSSFSheet sheet=workbook.getSheet(sheetName);
			
			XSSFRow row=sheet.getRow(rownum);
			
			Iterator<Cell> cellIterator=row.cellIterator();
			Cell cell;
			while(cellIterator.hasNext()) {
				
				cell=cellIterator.next();
				switch(cell.getCellType()) {
				//cell types in org.apache.poi.ss.usermodel.CellType enum
				case NUMERIC:
					break;
				case STRING:
					excelRowValues.add(cell.getStringCellValue());
					break;
				}
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return excelRowValues;
	}*/
	
	public Map readExcel(int rownum) {
		Map<String,String> excelRowValues=new HashMap<>();
		
		try {
			FileInputStream fis=new FileInputStream(new File(excelPath));
			
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			
			XSSFSheet sheet=workbook.getSheet(sheetName);
			
			XSSFRow row=sheet.getRow(rownum);
			
			int cellCount=row.getLastCellNum();
			System.out.println("Last Cell Number"+cellCount);
			Cell cell;
			for(int i=0;i<cellCount;i++) {
				
				cell=row.getCell(i);
				excelRowValues.put(sheet.getRow(0).getCell(i).getStringCellValue(), cell.getStringCellValue());
				
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return excelRowValues;
	}

}
