package com.erp.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
    private Workbook workbook;
    private Sheet sheet;

    // Constructor to load the Excel file and sheet
    public ExcelUtils(String excelPath, String sheetName) {
        try {
            File file = new File(excelPath);
            if (!file.exists()) {
                System.out.println("❌ Error: Excel file not found at " + excelPath);
                throw new IOException("Excel file not found: " + excelPath);
            }

            FileInputStream fis = new FileInputStream(file);
            workbook = WorkbookFactory.create(fis);

            System.out.println("✅ Excel file loaded successfully.");

            sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.out.println("❌ Error: Sheet '" + sheetName + "' not found in Excel file.");
                throw new IOException("Sheet '" + sheetName + "' not found.");
            } else {
                System.out.println("✅ Sheet '" + sheetName + "' loaded successfully.");
            }

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*
    // Method to get data from a specific cell
    public String getCellData(int row, int col) {
        if (sheet == null) {
            System.out.println("❌ Error: Sheet is null. Cannot fetch data.");
            return "";
        }

        Row excelRow = sheet.getRow(row);
        if (excelRow == null) {
            System.out.println("❌ Error: Row " + row + " does not exist in sheet.");
            return "";
        }

        Cell cell = excelRow.getCell(col);
        if (cell == null) {
            System.out.println("❌ Error: Cell (" + row + ", " + col + ") is empty.");
            return "";
        }

        //return cell.toString(); // Convert cell value to String
        // Handle different cell types properly
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue(); // Return String directly

            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString(); // Convert date cells properly
                } else {
                    return String.valueOf((long) cell.getNumericCellValue()); // Convert double to long (remove .0)
                }

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue()); // Convert boolean to String

            case FORMULA:
                return cell.getCellFormula(); // Return the formula as a String

            default:
                return ""; // Return empty for other cell types
        }
    }
*/

    public String getCellData(int row, int col) {
        if (sheet == null) {
            System.out.println("❌ Error: Sheet is null. Cannot fetch data.");
            return "";
        }

        Row excelRow = sheet.getRow(row);
        if (excelRow == null) {
            System.out.println("❌ Error: Row " + row + " does not exist in sheet.");
            return "";
        }

        Cell cell = excelRow.getCell(col);
        if (cell == null) {
            System.out.println("❌ Error: Cell (" + row + ", " + col + ") is empty.");
            return "";
        }

        // Use DataFormatter to preserve numeric format
        DataFormatter formatter = new DataFormatter();

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue(); // Return String directly

            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString(); // Convert date cells properly
                } else {
                    return formatter.formatCellValue(cell); // Preserve decimal values
                }

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue()); // Convert boolean to String

            case FORMULA:
                return cell.getCellFormula(); // Return the formula as a String

            default:
                return ""; // Return empty for other cell types
        }
    }


    // Method to get the total row count
    public int getRowCount() {
        if (sheet == null) {
            System.out.println("❌ Error: Sheet is null. Cannot get row count.");
            return 0;
        }
        int rowCount = sheet.getLastRowNum() + 1; // Adding 1 because indexing starts from 0
        System.out.println("📊 Total rows in sheet: " + rowCount);
        return rowCount;
    }

    // Close the workbook
    public void closeWorkbook() {
        try {
            if (workbook != null) {
                workbook.close();
                System.out.println("✅ Workbook closed successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
