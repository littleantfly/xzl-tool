package fun.xzl.tool.excel.entity;

import org.apache.poi.ss.usermodel.CellType;

public class ExcelHeader {

    //标题名称
    private String name;
    //数据编码
    private String code;
    //数据类型
    private CellType type;
    //列排序
    private Integer sort=1;

    public ExcelHeader(){}

    public ExcelHeader(String name, String code){
        this.name = name;
        this.code = code;
    }

    public ExcelHeader(String name, String code, int sort) {
        this.name = name;
        this.code = code;
        this.sort = sort;
    }

    public ExcelHeader(String name, String code, CellType type, int sort) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
