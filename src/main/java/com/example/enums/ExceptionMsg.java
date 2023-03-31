package com.example.enums;

public enum ExceptionMsg implements CodeEnum {
    /*通用*/
    SUCCESS(200, "操作成功"),
    FAILED(400, "操作失败"),
    ParamError(401, "参数错误！"),
    FriendTrip(4001, "友情提示"),
    SERVER_ERROR(500, "服务器错误"),
    PERMISSION_ERROR(600, "抱歉，数据权限不足，请联系管理员！");

    private final Integer code;
    private final String message;

    ExceptionMsg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ExceptionMsg{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
