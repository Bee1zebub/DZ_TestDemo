package com.example.dto.app.device.response;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangZc
 * @date: 2023/1/4 11:45
 * @description: 设备列表查询返回参数
 */
@Data
public class DeviceListResponse {

    @ApiModelProperty(value = "设备id")
    private String id;
    @ApiModelProperty(value = "设备名称")
    private String deviceName;
    @ApiModelProperty(value = "设备类型")
    private Integer deviceType;
    @ApiModelProperty(value = "设备类型名称")
    private String deviceTypeName;
    @ApiModelProperty(value = "项目id")
    private String projectId;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "部门id")
    private Long deptId;
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    @ApiModelProperty(value = "设备状态 1:启用 0:不启用")
    private String enable;
    @ApiModelProperty(value = "在线状态 0:在线；1:离线")
    private String online;
    @ApiModelProperty(value = "在线状态 0:在线；1:离线")
    private String onlineName;
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    @ApiModelProperty(value = "设备sn编号，非设备算法关联唯一编号")
    private String outSn;
    @ApiModelProperty(value = "ip")
    private String ip;
    @ApiModelProperty(value = "设备版本号")
    private String softwareVersion;
    @ApiModelProperty(value = "是否为智能摄像头")
    private String smartCameraIs;
    @ApiModelProperty(value = "是否展示算法参数")
    private String isShowAlgorithm = "0";
    @ApiModelProperty(value = "视频流地址")
    private String rtmpUrl;
    @ApiModelProperty(value = "设备状态")
    private JSONArray equipments;
    @ApiModelProperty(value = "塔吊绘制坐标x")
    private BigDecimal coordinateX;
    @ApiModelProperty(value = "塔吊绘制坐标Y")
    private BigDecimal coordinateY;
    @ApiModelProperty(value = "设备展示字段")
    private transient List<Map<String, String>> tableDisplay;
    @ApiModelProperty(value = "纽带参数设置")
    private String linkParamsConfigStr;

    @ApiModelProperty(value = "纽带参数设置")
    private List<JSONObject> linkParamsConfig;

}