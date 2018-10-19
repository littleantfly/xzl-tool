package fun.xzl.tool.excel;

import fun.xzl.tool.collection.CollectionUtils;
import fun.xzl.tool.excel.entity.ExcelHeader;
import fun.xzl.tool.map.MapUtils;
import fun.xzl.tool.object.ObjectUtils;
import fun.xzl.tool.time.TimeUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.OutputStream;
import java.util.*;

public class ExcelUtils {

    public static void export(List<ExcelHeader> headers, List<Map<String, Object>> data, OutputStream out) throws Exception{
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
//        wb.setCompressTempFiles(true); // 临时文件将会被压缩
        Sheet sh = wb.createSheet();
        int rownum = 0;
        int cellnum = 0;

        Collections.sort(headers, Comparator.comparing(ExcelHeader::getSort));


        // 设置为文本格式
        CellStyle style = wb.createCellStyle();
        DataFormat format = wb.createDataFormat();


        Row headerRow = sh.createRow(rownum++);
        cellnum = 0;
        for(ExcelHeader header: headers) {
            Cell cell = headerRow.createCell(cellnum++);
            cell.setCellValue(header.getName());
            //设置列的单元格格式
            if(ObjectUtils.isNotNull(header.getType())) {
                switch (header.getType()) {
                    case STRING:
                        style.setDataFormat(format.getFormat("@"));
                        break;
                }
                sh.setDefaultColumnStyle(cellnum, style);
            }


        }


        if(CollectionUtils.isNotEmpty(data)) {
            for(Map<String, Object> map: data) {
                Row row = sh.createRow(rownum++);
                cellnum = 0;

                for (ExcelHeader header : headers) {
                    Cell cell = row.createCell(cellnum++);
                    String key = header.getCode();
                    Object val = map.get(key);
                    if (ObjectUtils.isNotNull(val)) {
                        if (val instanceof Double) {
                            cell.setCellValue(MapUtils.getDoubleValue(map, key));
                        } else if (val instanceof Boolean) {
                            cell.setCellValue(MapUtils.getBooleanValue(map, key));
                        } else if(val instanceof Date){
                            cell.setCellValue(TimeUtils.format((Date)val));
                        } else {
                            cell.setCellValue(MapUtils.getString(map, key));
                        }
                    }
                }
            }
        }

        wb.write(out);
        out.close();
        // dispose of temporary files backing this workbook on disk
        wb.dispose();
    }
}
