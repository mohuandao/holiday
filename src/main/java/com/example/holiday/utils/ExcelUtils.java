package com.example.holiday.utils;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * excel导出的工具类
 */
@Component
public class ExcelUtils {
    //单sheet页
    public ByteArrayInputStream export(List<LinkedHashMap<String,Object>> list,String title,
                          List<String> headers,ByteArrayOutputStream out) throws IOException {
        //声明一个工作簿
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet(title);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 15);
        //产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for(short i = 0;i < headers.size();i++) {
            HSSFCell cell = row.createCell(i);
            //cell.setCellStyle(style);
            HSSFRichTextString textString = new HSSFRichTextString(headers.get(i));
            cell.setCellValue(textString);
        }

        // 遍历集合数据，产生数据行
        createList(list, sheet);
        book.write(out);
        byte[] bytes = out.toByteArray();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);

        return in;
    }

    //多sheet页导出
    public Boolean export_m(List<LinkedHashMap<String,Object>> list,
                            String title,List<String> headers,HSSFWorkbook workbook){
        HSSFSheet createSheet = workbook.createSheet(title);
        // 设置表格默认列宽度为15个字节
        createSheet.setDefaultColumnWidth((short) 15);
        //产生表格标题行
        HSSFRow row = createSheet.createRow(0);
        for(short i = 0;i < headers.size();i++) {
            HSSFCell cell = row.createCell(i);
            //cell.setCellStyle(style);
            HSSFRichTextString textString = new HSSFRichTextString(headers.get(i));
            cell.setCellValue(textString);

        }

        // 遍历集合数据，产生数据行
        createList(list, createSheet);
        return true;
    }

    private void createList(List<LinkedHashMap<String, Object>> list, HSSFSheet createSheet) {
        HSSFRow row;
        for(int i = 1; i<list.size()+1; i++) {
            row = createSheet.createRow(i);
            int flag = 0;
            for (Map.Entry<String, Object> entry : list.get(i-1).entrySet()) {
                HSSFCell cell_n = row.createCell(flag++);
                String value = entry.getValue() == null ? "" :entry.getValue().toString();
                cell_n.setCellValue(value);

            }
        }
    }
}
