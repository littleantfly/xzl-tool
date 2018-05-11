package fun.xzl.tool.excel;

import com.google.common.collect.Lists;
import fun.xzl.tool.collection.CollectionUtils;
import fun.xzl.tool.excel.entity.ExcelHeader;
import fun.xzl.tool.map.MapUtils;
import fun.xzl.tool.object.ObjectUtils;
import fun.xzl.tool.time.TimeUtils;

import java.io.*;
import java.util.*;

public class CsvUtils {

    public static final void export(List<ExcelHeader> headers, List<Map<String, Object>> data, OutputStream out)
    throws Exception {
        OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
        BufferedWriter bw =new BufferedWriter(osw,1024);

        Collections.sort(headers, Comparator.comparing(ExcelHeader::getSort));
        for(ExcelHeader header: headers) {
            bw.write(header.getName());
            bw.append(",");
        }
        bw.append("\r\n");


        if(CollectionUtils.isNotEmpty(data)){
            for(Map<String, Object> map : data){
                for (ExcelHeader header : headers) {
                    String key = header.getCode();
                    Object val = map.get(key);
                    if (ObjectUtils.isNotNull(val)) {
                        if (val instanceof Double) {
                            bw.write(MapUtils.getDouble(map, key).toString());
                        } else if (val instanceof Boolean) {
                            bw.write(MapUtils.getBoolean(map, key).toString());
                        } else if(val instanceof Date){
                            bw.write(TimeUtils.format((Date)val));
                        } else {
                            bw.write(MapUtils.getString(map, key));
                        }
                    }
                    bw.write(",");
                }
//                for(Map.Entry<String, Object> entry : map.entrySet()) {
//                    bw.write(entry.getValue().toString());
//                    bw.write(",");
//                }
                bw.write("\r\n");
            }
        }
        bw.flush();
        bw.close();
    }


    public static void main(String[] args) throws Exception {
        List<ExcelHeader> headers = Lists.newArrayList();
        ExcelHeader header = new ExcelHeader("序号", "id");
        ExcelHeader header1 = new ExcelHeader("名称", "name");
        ExcelHeader header2 = new ExcelHeader("时间", "time");
        headers.add(header);
        headers.add(header1);
        headers.add(header2);

        List<Map<String, Object>> data = Lists.newArrayList();
        for(int i = 0; i < 10; i++) {
            Map<String, Object> map = MapUtils.newHashMap();
            map.put("id", (i+1));

            map.put("name", "中国");
            map.put("time", TimeUtils.format(new Date()));
            data.add(map);
        }

        File file = new File("D://test.csv");
        OutputStream out = new FileOutputStream(file);
        export(headers, data, out);

    }
}
