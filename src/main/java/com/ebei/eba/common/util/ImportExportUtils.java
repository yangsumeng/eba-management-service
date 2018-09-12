package com.ebei.eba.common.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ImportExportUtils {

    public static void exportModel(List<Object[]> lists, List<String> titles, String excelName, int except, HttpServletResponse response)
            throws Exception {
        String basePath = System.getProperty("java.io.tmpdir") + File.separator;
        String reportPath = basePath + "report";
        String version = "2007";
        Workbook book;
        ServletOutputStream out = null;
        InputStream is = null;
        try {

            book = new XSSFWorkbook();
        } catch (Exception ex) {
            book = new HSSFWorkbook();
            version = "2003";
        }

        Sheet sheet = book.createSheet();
        book.setSheetName(0, excelName);

        //设置样式(表头)
        CellStyle sc = book.createCellStyle();
        Font font = book.createFont();
        font.setBold(true);
        sc.setFont(font);
        //居中
        sc.setAlignment(HorizontalAlignment.CENTER);
        sc.setWrapText(true);

        //设置样式（内容）
        CellStyle sctext = book.createCellStyle();
        sctext.setAlignment(HorizontalAlignment.CENTER);

        sctext.setWrapText(true);

        Row row = sheet.createRow(0);

        Cell cell1 = null;
        for (int i = 0; i < titles.size(); i++) {
            cell1 = row.createCell(i);
            cell1.setCellType(CellType.STRING);
            cell1.setCellValue(titles.get(i));
            cell1.setCellStyle(sc);
            sheet.setColumnWidth(i, 6500);
        }

        //列表
        int col = 0;
        int nums = 0;
        if (lists != null && lists.size() > 0) {
            for (int j = 0; j < lists.size(); j++) {
                int num = 0;
                Object[] task = lists.get(j);
                int clo = (++col);
                Row rowtemp = sheet.createRow(clo);
                Cell celll_count1 = null;
                nums = task.length > titles.size() ? titles.size() : task.length;
                if (except >= 0) {
                    nums++;
                }
                for (int k = 0; k < nums; k++) {
                    if (except >= 0 && except == k) {
                        continue;
                    } else {
                        celll_count1 = rowtemp.createCell((num++));
                        celll_count1.setCellType(CellType.STRING);
                        celll_count1.setCellValue(ConvertUtil.convert(task[k], ""));
                        celll_count1.setCellStyle(sctext);
                    }
                }

            }
        }
        try {
            //导出
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String nowflag = sf.format(new Date());
            String type = ".xlsx";
            if ("2003".equals(version)) {
                type = ".xls";
            }
            File folder = new File(reportPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            File file = new File(reportPath + nowflag + type);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            book.write(fileoutputstream);
            fileoutputstream.flush();
            fileoutputstream.close();

            OutputStream os = null;
            //获取流文件
            is = new FileInputStream(file);
            //TODO do callback

            //设置默认返回excel模板名称
            if (ValidateUtil.stringIsEmpty(excelName)) {
                excelName = DateUtils.getCurrentFormatDate("yyyyMMddHHmmss") + excelName;
            }
            //转换格式 防止乱码
            excelName = URLEncoder.encode(excelName, "UTF-8");

            response.reset(); // 必要地清除response中的缓存信息
            response.setHeader("Content-disposition", "attachment; filename=" + excelName);

            out = response.getOutputStream();

            byte[] content = new byte[1024];
            int length = -1;
            while ((length = is.read(content)) != -1) {
                out.write(content, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != out) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
