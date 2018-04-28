package fun.xzl.tool.excel.entity;

public class ExcelHeader {

    private String name;
    private String code;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
