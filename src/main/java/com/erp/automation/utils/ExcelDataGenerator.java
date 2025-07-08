package com.erp.automation.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataGenerator {

    public static void writeRandomDataToExcel(String filePath, String sheetName) {
        FileOutputStream fos = null;
        Workbook workbook = null;

        try {
            File file = new File(filePath);
            if (file.exists()) {
                file.delete(); // Always start fresh
            }



            workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(sheetName);
            Row header = sheet.createRow(0);

            String[] headers = {
                "Customer Name", "Vendor Code", "Email Id", "Address Line 1", "Address Line 2", "Address Line 3",
                "Pin Code", "Mobile", "FAX", "PAN", "REGN", "Trade Name", "Legal Name", "Bank Name", "Account",
                "IFSC Code", "Payment Cycle", "Grace Period", "Special Instructions", "GRN Grace Period",
                "Item Code", "Their Item Code", "Their Item Name", "Amortization Cost", "Amortization QTY"
            };

            for (int i = 0; i < headers.length; i++) {
                header.createCell(i).setCellValue(headers[i]);
            }

            // Data Row
            Row row = sheet.createRow(1);
            Random random = new Random();

            String customerName = "Customer_" + random.nextInt(10000);
            System.out.println("Customer Name: " + customerName);
            row.createCell(0).setCellValue(customerName);

            String vendorCode = "VENDOR" + random.nextInt(9999);
            System.out.println("Vendor Code: " + vendorCode);
            row.createCell(1).setCellValue(vendorCode);

            String email = "user" + random.nextInt(10000) + "@mail.com";
            System.out.println("Email Id: " + email);
            row.createCell(2).setCellValue(email);

            String address1 = "123 Main Street";
            System.out.println("Address Line 1: " + address1);
            row.createCell(3).setCellValue(address1);

            String address2 = "Building B";
            System.out.println("Address Line 2: " + address2);
            row.createCell(4).setCellValue(address2);

            String address3 = "Floor 3";
            System.out.println("Address Line 3: " + address3);
            row.createCell(5).setCellValue(address3);

            String pinCode = "400" + random.nextInt(100);
            System.out.println("Pin Code: " + pinCode);
            row.createCell(6).setCellValue(pinCode);

            String mobile = "9" + (100000000 + random.nextInt(900000000));
            System.out.println("Mobile: " + mobile);
            row.createCell(7).setCellValue(mobile);

            String fax = "1234567890";
            System.out.println("FAX: " + fax);
            row.createCell(8).setCellValue(fax);

            String pan = "PAN" + random.nextInt(9999);
            System.out.println("PAN: " + pan);
            row.createCell(9).setCellValue(pan);

            String regn = "REGN" + random.nextInt(9999);
            System.out.println("REGN: " + regn);
            row.createCell(10).setCellValue(regn);

            String tradeName = "TradeCo" + random.nextInt(999);
            System.out.println("Trade Name: " + tradeName);
            row.createCell(11).setCellValue(tradeName);

            String legalName = "LegalCo Pvt Ltd";
            System.out.println("Legal Name: " + legalName);
            row.createCell(12).setCellValue(legalName);

            String bankName = "ICICI Bank";
            System.out.println("Bank Name: " + bankName);
            row.createCell(13).setCellValue(bankName);

            String account = "1234567890";
            System.out.println("Account: " + account);
            row.createCell(14).setCellValue(account);

            String ifsc = "ICIC0001234";
            System.out.println("IFSC Code: " + ifsc);
            row.createCell(15).setCellValue(ifsc);

            String paymentCycle = "30";
            System.out.println("Payment Cycle: " + paymentCycle);
            row.createCell(16).setCellValue(paymentCycle);

            String gracePeriod = "10";
            System.out.println("Grace Period: " + gracePeriod);
            row.createCell(17).setCellValue(gracePeriod);

            String specialInstructions = "Handle with care";
            System.out.println("Special Instructions: " + specialInstructions);
            row.createCell(18).setCellValue(specialInstructions);

            String grnGrace = "5";
            System.out.println("GRN Grace Period: " + grnGrace);
            row.createCell(19).setCellValue(grnGrace);

            String itemCode = "11064";
            System.out.println("Item Code: " + itemCode);
            row.createCell(20).setCellValue(itemCode);

            String theirItemCode = "THEIR" + random.nextInt(1000);
            System.out.println("Their Item Code: " + theirItemCode);
            row.createCell(21).setCellValue(theirItemCode);

            String theirItemName = "Sample Item";
            System.out.println("Their Item Name: " + theirItemName);
            row.createCell(22).setCellValue(theirItemName);

            int amortCost = random.nextInt(100000);  // e.g. large cost value
            System.out.println("Amortization Cost: " + amortCost);
            row.createCell(23).setCellValue(amortCost);

            int amortQty = random.nextInt(100);
            System.out.println("Amortization QTY: " + amortQty);
            row.createCell(24).setCellValue(amortQty);


            fos = new FileOutputStream(filePath);
            workbook.write(fos);
            System.out.println("✅ Random test data written to Excel successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
					fos.close();
				}
                if (workbook != null) {
					workbook.close();
				}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
            workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(sheetName);
            Row header = sheet.createRow(0);

            String[] headers = {
                "Customer Name", "Vendor Code", "Email Id", "Address Line 1", "Address Line 2", "Address Line 3",
                "Pin Code", "Mobile", "FAX", "PAN", "REGN", "Trade Name", "Legal Name", "Bank Name", "Account",
                "IFSC Code", "Payment Cycle", "Grace Period", "Special Instructions", "GRN Grace Period",
                "Item Code", "Their Item Code", "Their Item Name", "Amortization Cost", "Amortization QTY"
            };

            for (int i = 0; i < headers.length; i++) {
                header.createCell(i).setCellValue(headers[i]);
            }

            // Data Row
            Row row = sheet.createRow(1);
            Random random = new Random();

            row.createCell(0).setCellValue("Customer_" + random.nextInt(10000));
            row.createCell(1).setCellValue("VENDOR" + random.nextInt(9999));
            row.createCell(2).setCellValue("user" + random.nextInt(10000) + "@mail.com");
            row.createCell(3).setCellValue("123 Main Street");
            row.createCell(4).setCellValue("Building B");
            row.createCell(5).setCellValue("Floor 3");
            row.createCell(6).setCellValue("400" + random.nextInt(100));
            row.createCell(7).setCellValue("9" + (100000000 + random.nextInt(900000000)));
            row.createCell(8).setCellValue("1234567890");
            row.createCell(9).setCellValue("PAN" + random.nextInt(9999));
            row.createCell(10).setCellValue("REGN" + random.nextInt(9999));
            row.createCell(11).setCellValue("TradeCo" + random.nextInt(999));
            row.createCell(12).setCellValue("LegalCo Pvt Ltd");
            row.createCell(13).setCellValue("ICICI Bank");
            row.createCell(14).setCellValue("1234567890");
            row.createCell(15).setCellValue("ICIC0001234");
            row.createCell(16).setCellValue("30");
            row.createCell(17).setCellValue("10");
            row.createCell(18).setCellValue("Handle with care");
            row.createCell(19).setCellValue("5");
            row.createCell(20).setCellValue("11064");
            row.createCell(21).setCellValue("THEIR" + random.nextInt(1000));
            row.createCell(22).setCellValue("Sample Item");
            row.createCell(23).setCellValue(random.nextInt());         // cost
            System.out.println();
            row.createCell(24).setCellValue(random.nextInt(100));        // quantity

            fos = new FileOutputStream(filePath);
            workbook.write(fos);
            System.out.println("✅ Random test data written to Excel successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) fos.close();
                if (workbook != null) workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
*/