package com.itlearn.utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcelFile {
    
    public static FileInputStream inputStream;
    public static XSSFWorkbook workBook;
    public static XSSFSheet excelSheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    // Method to get cell value with proper null checks
    public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo) {
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
            excelSheet = workBook.getSheet(sheetName);

            if (excelSheet == null) {
                System.out.println("Error: Sheet '" + sheetName + "' not found.");
                workBook.close();
                return "";
            }

            row = excelSheet.getRow(rowNo);
            if (row == null) {
                System.out.println("Error: Row " + rowNo + " is empty.");
                workBook.close();
                return "";
            }

            cell = row.getCell(cellNo);
            if (cell == null) {
                System.out.println("Error: Cell[" + rowNo + "][" + cellNo + "] is empty.");
                workBook.close();
                return "";
            }

            String cellValue = cell.toString(); // Handles both String and Numeric values
            System.out.println("Reading Cell[" + rowNo + "][" + cellNo + "]: " + cellValue);
            
            workBook.close();
            return cellValue;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return "";
        }
    }

    // Method to get row count with improved error handling
    public static int getRowCount(String fileName, String sheetName) {
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
            excelSheet = workBook.getSheet(sheetName);

            if (excelSheet == null) {
                System.out.println("Error: Sheet '" + sheetName + "' not found.");
                workBook.close();
                return 0;
            }

            int ttlRows = excelSheet.getLastRowNum() + 1;
            System.out.println("Total Rows Found: " + ttlRows);
            
            workBook.close();
            return ttlRows;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return 0;
        }
    }

    // Method to get column count with proper null checks
    public static int getColCount(String fileName, String sheetName) {
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
            excelSheet = workBook.getSheet(sheetName);

            if (excelSheet == null || excelSheet.getRow(0) == null) {
                System.out.println("Error: No data found in the first row.");
                workBook.close();
                return 0;
            }

            int ttlCells = excelSheet.getRow(0).getLastCellNum();
            System.out.println("Total Columns Found: " + ttlCells);
            
            workBook.close();
            return ttlCells;
        } catch (IOException e) {
            System.out.println("Error reading columns: " + e.getMessage());
            return 0;
        }
    }
}

	


