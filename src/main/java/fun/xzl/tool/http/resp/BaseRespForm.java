package fun.xzl.tool.http.resp;

import java.io.Serializable;

public class BaseRespForm<T>  implements Serializable  {

    private String status;
    private T data;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
