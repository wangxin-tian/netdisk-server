package com.dhx.config;

public class Result<T> {

    private int code;
    private String msg;
    private Long total;
    private T data;

    //失败
    public static<T> Result<T> fail(){
        return result(400,"失败",0L,null);
    }
    public static<T> Result<T> fail(String msg){
        return result(400,msg,0L,null);
    }

    //成功
    public static<T> Result<T> suc(){
        return result(200,"成功",0L,null);
    }
    public static<T> Result<T> suc(T data){
        return result(200,"成功",0L,data);
    }
    public static<T> Result<T> suc(T data,Long total){
        return result(200,"成功",total,data);
    }

    private static<T> Result<T> result(int code,String msg,Long total,T data){
        Result<T> result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setTotal(total);
        result.setData(data);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
