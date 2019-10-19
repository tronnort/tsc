package com.tron.file;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class ExcelDemo {
    public static void main(String[] args) {

         String[][]objs = {{"头1","头2","头3","头4"},{"1","1","1","1"},{"2","2","2","2"},{"3","3","3","3"}};
        try {
            pojoToExcel(objs,"tron");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            excelToPojo(new File("./java-study/src/main/java/com/tron/file/tron.xls"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static String pojoToExcel(String[][] objs,String tableName) throws Exception {
        //创建一个excle文档对象 .xls               XSSFWorkBook();  是.xlsx格式
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个工作表
        Sheet sheet = workbook.createSheet();
        //设置数据
        for (int i = 0 ; i < objs.length ; i++) {
            System.out.println("------------创建行第"+i+"行------");
            Row row = sheet.createRow(i);
            for (int j = 0; j< objs[i].length; j++) {
                System.out.println("-----------设置第"+i+"行 "+" 第"+j+"列数据---------："+objs[i][j]);
                row.createCell(j).setCellValue(objs[i][j]);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream("./java-study/src/main/java/com/tron/file/"+tableName+".xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
        return "";
    }

    public static String[][] excelToPojo(File file) throws Exception{
        //创建一个excle文档对象
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
        //获取工作表
        Sheet sheet = workbook.getSheetAt(0);
        int rowLength = sheet.getLastRowNum()+1;  //获取总行数
        int collLength = sheet.getRow(0).getLastCellNum();  //获取总列数
        String[][] pojsos =  new String[rowLength][collLength];
        int j = 0;
        for (Row row : workbook.getSheetAt(0)) {
            int i = 0;
            while (row.getCell(i) != null) {
                pojsos[j][i] = row.getCell(i)+"";
                i++;
            }
            j++;
        }
        return pojsos;
    }
}
