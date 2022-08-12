package com.framework.automation.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelHandle {

    static String value;
    static String ret;
    public static HashMap<String, Integer> excelColData = null;
    static String path = "D:\\SOF Automation\\IMAF-main\\Resources\\Testdata.xlsx";
    static FileInputStream fis;
    static {
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static XSSFWorkbook workbook;

    static {
        try {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static XSSFSheet sh = workbook.getSheet("Sheet1");

    public ExcelHandle() throws IOException, InterruptedException {
    }

    public static CharSequence ExcelFunction(int testCase, String keys) {
        int rowName = testCase;
        String colName = keys;
        int colNumber = 0;
        try {
            String path = "D:\\SOF Automation\\IMAF-main\\Resources\\Testdata.xlsx";
            FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            sh = workbook.getSheet("Sheet1");

            int lastIndex = sh.getLastRowNum();
            System.out.println(lastIndex);

            excelColData = new HashMap<String, Integer>();
            int colIndex = 0;
            Row rows = sh.getRow(0);
            Iterator<Cell> cells = rows.cellIterator();

            while (cells.hasNext())
            {
                Cell cell = cells.next();
                String colmName = cell.getStringCellValue();
                excelColData.put(colmName, colIndex);
                colIndex++;
            }
            colNumber=(excelColData.get(colName));
            value=getCellData(rowName,colNumber);

        }
        catch (Exception e) {
            System.out.println("Error");

        }

        return value;
    }

    public static void ExcelWriteFunction(int testCase, String keys, String transNum) {
        int rowName = testCase;
        String colName = keys;
        String data = transNum;
        int colNumber = 0;
        try {
            String path = "D:\\SOF Automation\\IMAF-main\\Resources\\Testdata.xlsx";
            FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            sh = workbook.getSheet("Sheet1");

            int lastIndex = sh.getLastRowNum();
            System.out.println(lastIndex);

            excelColData = new HashMap<String, Integer>();
            int colIndex = 0;
            Row rows = sh.getRow(0);
            Iterator<Cell> cells = rows.cellIterator();

            while (cells.hasNext())
            {
                Cell cell = cells.next();
                String colmName = cell.getStringCellValue();
                excelColData.put(colmName, colIndex);
                colIndex++;
            }
            colNumber=(excelColData.get(colName));
//            System.out.println(colNumber);
//            setCellData(rowName,colNumber,data);
//            fis.close();
            Row row = sh.getRow(rowName);
            Cell cell = row.getCell(colNumber);
            System.out.println(cell);
            cell.setCellValue(data);
            System.out.println(cell);
            fis.close();

            FileOutputStream fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.close();

        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }

   public static void setCellData(int rowNum, int colNum, String transNum) throws IOException {
        ret = transNum;
        System.out.println(rowNum);
        System.out.println(ret);
        Row row = sh.getRow(rowNum);
        Cell cell = row.createCell(colNum);
        System.out.println(cell);
        cell.setCellValue(ret);
        System.out.println(cell);

        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fos.close();
   }


    public static String getCellData(int rowNum, int colNum) {
        String ret = " ";
        Row row = sh.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        if(cell.getCellType()==CellType.STRING) {
            ret = cell.getStringCellValue();
            return ret;
        }
        else if(cell.getCellType()==CellType.NUMERIC) {
            ret = NumberToTextConverter.toText(cell.getNumericCellValue());
        }
        return ret;
    }
}
