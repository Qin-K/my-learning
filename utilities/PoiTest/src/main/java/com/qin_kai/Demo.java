package com.qin_kai;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * @author Qin Kai
 * @date 2019-10-14
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        File file = new File ("test.xlsx");
        OutputStream outputStream = new FileOutputStream(file);
        // 创建工作簿和工作表
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("test");
        // 添加表头
        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("姓名");
        row.createCell(1).setCellValue("年龄");

        Scanner sc = new Scanner(System.in);
        int rowNum = 1;
        while (true) {
            String[] strs = sc.nextLine().split("\\s+");
            if (strs.length > 0 && "$".equals(strs[0])) {
                break;
            }

            if (strs.length < 2 || !strs[1].matches("\\d+")) {
                System.err.println("输入有误请重新输入!!");
                continue;
            }

            row = sheet.createRow(rowNum);
            rowNum++;
            row.createCell(0).setCellValue(strs[0]);
            row.createCell(1).setCellValue(strs[1]);
        }

        workbook.write(outputStream);
        outputStream.close();
    }
}
