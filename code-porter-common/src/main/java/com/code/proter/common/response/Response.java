package com.code.proter.common.response;

import lombok.Data;

@Data
public final class Response {

    private String code;
    private String message;
    private Object data;

    public static Response ok(Object data) {
        return new Response(ResponseEnum.SUCCESS.code,ResponseEnum.SUCCESS.message,data);
    }

    public static Response ok() {
        return new Response(ResponseEnum.SUCCESS.code,ResponseEnum.SUCCESS.message,"");
    }

    public static Response fail(){
        return new Response(ResponseEnum.FAIL.code,ResponseEnum.FAIL.message,"");
    }

    public static  Response fail(String message){
        return new Response(ResponseEnum.FAIL.code,ResponseEnum.FAIL.message,message);
    }

    public static Response info(String code,String message,Object data){
        return new Response(code,message,data);
    }

    public static Response error(String message){
        return new Response(ResponseEnum.ERROR.code,message,"");
    }

    public static Response sessionOutTime(){
        return new Response(ResponseEnum.SESSION_OUT_TIME.code,ResponseEnum.SESSION_OUT_TIME.message,"登录信息已过期，请重新登录");
    }

    private Response(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    enum  ResponseEnum{

        SUCCESS("20000","success"),
        FAIL("40500","fail"),
        ERROR("50000","error"),
        SESSION_OUT_TIME("40013","session_out_time");

        private String code;
        private String message;

        ResponseEnum(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
