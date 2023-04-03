package com.example.dto.app.device.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Copyright © 2019 Xinke(Shanghai) Network Science and Technology Co., Ltd. All rights reserved.
 *
 * @author xuwh
 * @date 2020/6/18 14:48
 */
@Data
public class DeviceRequest {

    @ApiModelProperty(value = "页码")
    private Integer page ;
    @ApiModelProperty(value = "每页个数")
    private Integer pageSize ;
    @ApiModelProperty(value = "设备名称")
    private String deviceName;
    @ApiModelProperty(value = "设备类型")
    private Integer deviceType;
    @ApiModelProperty(value = "项目id")
    private String projectId;
    @ApiModelProperty(value = "部门id")
    private String deptId;
    @ApiModelProperty(value = "设备状态 1:启用 0:不启用")
    private String enable;
    @ApiModelProperty(value = "在线状态 0:在线；1:离线")
    private String online;
    @ApiModelProperty(value = "创建开始时间")
    private String createTimeBegin;
    @ApiModelProperty(value = "创建结束时间")
    private String createTimeEnd;
    @ApiModelProperty(value = "设备类型分组字典项")
    private String dictCategory;
    @ApiModelProperty(value = "设备id")
    private String deviceId;
    @ApiModelProperty(value = "多个设备类型")
    private String deviceTypes;
    @ApiModelProperty(value = "告警类型")
    private String alarmType;
    @ApiModelProperty(value = "告警类型id")
    private String alarmTypes;
    @ApiModelProperty(value = "关键字")
    private String keyWord;
}
