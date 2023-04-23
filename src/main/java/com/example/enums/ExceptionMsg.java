
package com.example.enums;

/**
 * Copyright © 2019 Xinke(Shanghai) Network Science and Technology Co., Ltd. All rights reserved.
 * 接口返回枚举
 *
 * @author yy
 * @date 2019/5/23
 */
public enum ExceptionMsg implements CodeEnum {
    /*通用*/
    SUCCESS(200, "操作成功"),
    FAILED(400, "操作失败"),
    ParamError(401, "参数错误！"),
    FriendTrip(4001, "友情提示"),
    SERVER_ERROR(500, "服务器错误"),
    PERMISSION_ERROR(600, "抱歉，数据权限不足，请联系管理员！"),

    /*权限登录相关*/
    LOGIN_OUT(1001, "token失效，请重新登陆！"),
    ACCESS_LIMIT_REACHED(1002, "访问太频繁了！"),
    CAPTCHA_ERROR(1003, "验证码错误"),
    APPINFO_ERROR(1004, "app参数缺少"),
    LOGINPASS_ERROR(1005, "账户或密码错误"),
    USER_DOT_EXIST(1006, "该账号不存在"),
    LOGINPASS_LENGTH_ERROR(1007, "密码为6~18位数字或字母或数字和字母组合"),
    LOGIN_TWO(1008, "您的账号已在其他设备登录"),
    USERPASS_EXIST(1009, "用户密码已存在"),
    USERPASS_OLD_ERROR(1010, "原始密码错误"),
    USERPASS_NEW_ERROR(1011, "新密码不能与旧密码相同"),
    USER_DEVICE_TYPE_EXIST(1012, "用户系统类型已存在"),
    ADMIN_NOT_EXIST(1013, "登录失败,用户不存在或密码错误"),
    ADMIN_CAPTCHA_ERROR(1014, "登录失败,验证码错误"),
    USER_ADD_FALSE(1015, "新用户创建失败"),
    USER_HAS_EXIST(1016, "此账号的用户已存在"),
    USER_UPDATE_FAILED(1017, "更新失败"),
    DEVICE_EXIST(1018,"设备名称重复"),
    DEVICE_INSERT_FAILED(1019, "新增出入记录失败"),
    DEVICE_CHECK_1_FAILED(1020, "设备信息不存在"),
    DEVICE_IP_PORT_DEIST(1021, "设备IP或IP、端口重复"),
    ALARM_OPERATION_ERROR(1022, "当前不是最新操作流程"),
    DEVICE_IP_PORT_CHANNEL_DEIST(1023, "设备IP、端口、通道号重复"),
    REDIS_WAITING(1033, "未获取到redis数据"),
    PARKING_NAME_EXIST(1034, "同一项目下不能重复"),
    NO_MESSAGE_RECEIVED(1035, "没有接收到推送信息"),
    REFUSED_ACCEPT(1036, "不接收推送数据"),
    USER_NOT_IN_PROJECT(1037, "未在项目中查询到该人员"),
    UPLOAD_FILE_MAX_ERROR(1038, "上传文件过大"),
    PERMISSION_NOT_FIND(1039, "未检测到人员数据权限，请联系管理员！"),
    PROJECT_NOT_FIND(1040, "项目不存在！"),
    ALARM_HAS_EXIST(1041, "告警已被插入！"),
    ALARM_NOT_FIND(1042, "告警信息不存在！"),
    ALARM_TYPE_NOT_FIND(1043, "告警类型不能为空！"),
    DEVICE_NOT_FIND_PROJECT(1044, "设备未绑定项目！"),
    EXPORT_EXCEEDS_MAX_ERROR(1045,"导出条数超过上线，请重新筛选导出"),
    DEVICE_NOT_FIND_ALGORITHM(1046, "设备未开启算法告警类型"),
    UPLOAD_FILE_NOT_FIND(1047, "上传文件为空"),
    UPLOAD_FILE_FORMAT_ERROR(1048, "上传文件格式出错"),
    UPLOAD_FILE_ERROR(1049, "上传文件失败"),
    UPLOAD_FILE_SIZE_ASTRICT(1050, "文件上传不能超过2M"),
    ALARM_TIME_HAS_EXPIRED(1051,"告警免提醒时间已过期"),
    DEVICE_NOT_FIND(1052, "设备不存在!"),
    ALARM_PUSH_ERROR(1053, "推送失败，未有人接收到信息。"),
    DEVICE_NOT_FIND_ALGORITHM_SERVER(1053, "设备未开启算法服务！"),
    DEVICE_IP_DEIST(1054, "设备IP重复"),
    DEVICE_IP_CHANNEL_DEIST(1055, "设备IP或IP、通道号重复"),
    NOTE_ERROR_MESSAGE(1066, "请联系管理员开通短信推送服务！"),
    WECHAT_ERROR_MESSAGE(1067, "请联系管理员开通微信公众号推送服务！"),
    QIWEI_ERROR_MESSAGE(1068, "请联系管理员开通企业微信推送服务！"),;


    private ExceptionMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    @Override
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ExceptionMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}

