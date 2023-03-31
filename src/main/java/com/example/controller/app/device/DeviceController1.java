package com.example.controller.app.device;

import cn.hutool.core.map.MapUtil;
import com.example.constant.SwaggerConstant;
import com.xinke.sSiteWeb.config.annotation.Log;
import com.xinke.sSiteWeb.config.annotation.PassToken;
import com.xinke.sSiteWeb.config.annotation.PermissionCheck;
import com.xinke.sSiteWeb.dto.app.v1.device.DeviceDelRequest;
import com.xinke.sSiteWeb.dto.app.v1.device.request.*;
import com.xinke.sSiteWeb.dto.app.v1.device.response.*;
import com.xinke.sSiteWeb.dto.app.v1.monitor.request.MonitorRequest;
import com.xinke.sSiteWeb.enums.DeviceTypeEnum;
import com.xinke.sSiteWeb.mapper.app.DeviceMapper;
import com.xinke.sSiteWeb.result.Result;
import com.xinke.sSiteWeb.result.ResultVo;
import com.xinke.sSiteWeb.service.app.device.DeviceService;
import com.xinke.sSiteWeb.service.app.device.OutDeviceService;
import com.xinke.sSiteWeb.service.app.sd.SdEnvironmentalMonitorSevice;
import com.xinke.sSiteWeb.utils.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Copyright © 2019 Xinke(Shanghai) Network Science and Technology Co., Ltd. All rights reserved.
 *
 * @author xuwh
 * @date 2020/6/18 10:42
 */
@RestController
@Api(value = "device", tags = SwaggerConstant.DEVICE)
@RequestMapping(value = "smartSite/device", produces = "application/json;charset=utf-8")
@Slf4j
public class DeviceController1 {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private AsyncTaskExecutor taskExecutor;

    @Autowired
    private OutDeviceService outDeviceService;

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private SdEnvironmentalMonitorSevice sdEnvironmentalMonitorSevice;

    @ApiOperation(value = "设备添加", notes = "添加设备接口")
    @PostMapping("{version}/add")
    public ResultVo<AddDeviceResultResponse> addDevice(@PathVariable("version") String version, HttpServletRequest httpServletRequest, @RequestBody DeviceAddRequest request) {
        return Result.success(deviceService.addDevice(request, httpServletRequest));
    }

    //@Log(value = "记录获取设备列表操作日志",logType = 2,operationType = 3,module = 1)
    @ApiOperation(value = "设备列表", notes = "设备列表接口")
    @PostMapping("{version}/deviceList")
    @PermissionCheck
    public ResultVo<PageUtil<DeviceListResponse>> devicePages(@PathVariable("version") String version, @RequestBody DeviceRequest request) {
        return Result.success(deviceService.getDeviceListPage(request));
    }

    //@Log(value = "记录获取设备列表操作日志",logType = 2,operationType = 3,module = 1)
    @ApiOperation(value = "设备详情", notes = "设备详情接口")
    @GetMapping("{version}/{id}")
    public ResultVo<DeviceInfoResponse> deviceInfoById(@PathVariable("version") String version, @PathVariable("id") String id) {
        return Result.success(deviceService.deviceInfoById(id));
    }

    @ApiOperation(value = "设备修改", notes = "设备修改接口")
    @PostMapping("{version}/updateDevice")
    public ResultVo updateDevice(@PathVariable("version") String version, HttpServletRequest httpServletRequest, @RequestBody DeviceUpdateRequest request) {
        deviceService.updateDevice(request, httpServletRequest);
        return Result.success();
    }

    @Log(value = "记录设备批量启用停用日志", logType = 2, operationType = 2, module = 1)
    @ApiOperation(value = "批量启用停用", notes = "批量启用停用接口")
    @PostMapping("{version}/batchUpdate")
    public ResultVo batchUpdate(@PathVariable("version") String version, @RequestBody BatchUpdateRequest request) {
        //deviceService.batchUpdate(request);
        deviceService.newBatchUpdate(request);
        return Result.success();
    }

    @Log(value = "记录设备删除操作日志", logType = 2, operationType = 4, module = 1)
    @ApiOperation(value = "设备删除", notes = "设备删除接口")
    @PostMapping("{version}/deviceDel")
    public ResultVo delDevice(@PathVariable("version") String version, @RequestBody DeviceDelRequest request) throws Exception {
        deviceService.delDevice(Long.valueOf(request.getId()), request.getDeviceType());
        return Result.success();
    }

    /**
     * 获取智能服务器下拉数据
     *
     * @return
     */
    @PostMapping("{version}/smartService")
    @ApiOperation(value = "获取智能服务器下拉数据")
    public ResultVo<List<SmartServiceResponse>> getSmartService(@PathVariable("version") String version, @RequestBody SmartServiceRequest request) {
        return Result.success(deviceService.smartService(request.getProjectId()));
    }

    @GetMapping("{version}/capturePictures")
    @ApiOperation(value = "抓取图片 (置空表字段)")
    public ResultVo capturePictures(@PathVariable("version") String version, String id) {
        return Result.success(outDeviceService.capturePictures(Long.valueOf(id)));
    }

    @GetMapping("{version}/getPicture")
    @PassToken
    @ApiOperation(value = "获取电子围栏预览图")
    public ResultVo<WebPreviewResponse> getPicture(@PathVariable("version") String version, String id, String projectId) {
        return Result.success(outDeviceService.getWebPreview(Long.valueOf(id), projectId));
    }

    @GetMapping("{version}/insertCamera")
    @ApiOperation(value = "手动触发新增设备跑批")
    public void insertCamera(@PathVariable("version") String version) throws Exception {
//        deviceService.outDelDevice(true);
    }


    /**
     * 获取人员录入机设备
     *
     * @return
     */
    @PostMapping("{version}/fetchMachine")
    @ApiOperation(value = "获取人员录入机设备")
    public ResultVo<List<MachineResponse>> fetchMachine(@PathVariable("version") String version, @RequestBody SmartServiceRequest request) {
        return Result.success(deviceService.fetchMachine(request.getProjectId()));
    }

    /**
     * 根据项目和设备类型查询设备
     *
     * @return
     */
    @PostMapping("{version}/getDeviceByProjectAndType")
    @ApiOperation(value = "根据项目和设备类型查询设备")
    public ResultVo<List<MachineResponse>> getDeviceByProjectAndType(@PathVariable("version") String version, @RequestBody SmartServiceRequest request) {
        return Result.success(deviceService.getDeviceByProjectAndType(request));
    }

    /**
     * get /smartSite/device/count
     *
     * @return
     */
    @GetMapping("/count")
    @PassToken
    public ResultVo<DeviceCountResponse> count(@RequestParam(value = "projectId", required = false) Long projectId) {
        DeviceCountResponse response = new DeviceCountResponse();
        List<DeviceCount2Response> count = deviceMapper.count(projectId);
        if(!CollectionUtils.isEmpty(count)){
            Map<Integer, List<DeviceCount2Response>> collect = count.stream().filter(device -> null != device.getDeviceType()).collect(Collectors.groupingBy(DeviceCount2Response::getDeviceType));
            if (MapUtil.isNotEmpty(collect)) {
                collect.forEach((k, v) -> {
                    if (DeviceTypeEnum.CAMERA.getType().equals(k)) {
                        Map<String, List<DeviceCount2Response>> collect1 = v.stream().collect(Collectors.groupingBy(DeviceCount2Response::getOnline));
                        if (collect1.get("0") != null) {
                            response.setMonitorCameraTotalOnline(collect1.get("0").get(0).getNum());
                        }
                        if (collect1.get("1") != null) {
                            response.setMonitorCameraTotalOffline(collect1.get("1").get(0).getNum());
                        }
                        response.setMonitorCameraTotal(response.getMonitorCameraTotalOffline() + response.getMonitorCameraTotalOnline());
                    } else if (DeviceTypeEnum.HAWKEYE_CAMERA.getType().equals(k)) {
                        Map<String, List<DeviceCount2Response>> collect1 = v.stream().collect(Collectors.groupingBy(DeviceCount2Response::getOnline));
                        if (collect1.get("0") != null) {
                            response.setEagleEyeCameraTotalOnline(collect1.get("0").get(0).getNum());
                        }
                        if (collect1.get("1") != null) {
                            response.setEagleEyeCameraTotalOffline(collect1.get("1").get(0).getNum());
                        }
                        response.setEagleEyeCameraTotal(response.getEagleEyeCameraTotalOffline() + response.getEagleEyeCameraTotalOnline());
                    } else if (DeviceTypeEnum.FACE_RECOGNITION_DEVICE.getType().equals(k)) {
                        Map<String, List<DeviceCount2Response>> collect1 = v.stream().collect(Collectors.groupingBy(DeviceCount2Response::getOnline));
                        if (collect1.get("0") != null) {
                            response.setFacePadTotalOnline(collect1.get("0").get(0).getNum());

                        }
                        if (collect1.get("1") != null) {
                            response.setFacePadTotalOffline(collect1.get("1").get(0).getNum());

                        }
                        response.setFacePadTotal(response.getFacePadTotalOffline() + response.getFacePadTotalOnline());
                    } else if (DeviceTypeEnum.ALGORITHM_SERVER.getType().equals(k)) {
                        Map<String, List<DeviceCount2Response>> collect1 = v.stream().collect(Collectors.groupingBy(DeviceCount2Response::getOnline));
                        if (collect1.get("0") != null) {
                            response.setServerTotalOnline(collect1.get("0").get(0).getNum());
                        }
                        if (collect1.get("1") != null) {
                            response.setServerTotalOffline(collect1.get("1").get(0).getNum());

                        }

                        response.setServerTotal(response.getServerTotalOffline() + response.getServerTotalOnline());
                    } else if (DeviceTypeEnum.MACHINE_DEVICE.getType().equals(k)) {
                        Map<String, List<DeviceCount2Response>> collect1 = v.stream().collect(Collectors.groupingBy(DeviceCount2Response::getOnline));
                        if (collect1.get("0") != null) {
                            response.setInputMachineTotalOnline(collect1.get("0").get(0).getNum());

                        }
                        if (collect1.get("1") != null) {
                            response.setInputMachineTotalOffline(collect1.get("1").get(0).getNum());

                        }
                        response.setInputMachineTotal(response.getInputMachineTotalOffline() + response.getInputMachineTotalOnline());
                    }
                });
            }
        }
        response.setTotal(response.getFacePadTotal() + response.getInputMachineTotal() + response.getEagleEyeCameraTotal() + response.getServerTotal() + response.getMonitorCameraTotal());
        response.setTotalOnline(response.getFacePadTotalOnline() + response.getInputMachineTotalOnline() + response.getEagleEyeCameraTotalOnline() + response.getServerTotalOnline() + response.getMonitorCameraTotalOnline());
        response.setTotalOffline(response.getFacePadTotalOffline() + response.getInputMachineTotalOffline() + response.getEagleEyeCameraTotalOffline() + response.getServerTotalOffline() + response.getMonitorCameraTotalOffline());
        return Result.success(response);
    }

    /**
     * 物联设备关联操作  post /smartSite/device/v2/iotDeviceBind
     *
     * @return
     */
    @PostMapping("{version}/iotDeviceBind")
    @ApiOperation(value = "物联设备关联操作")
    public ResultVo iotDeviceBind(@PathVariable("version") String version, @RequestBody IotDeviceBindRequest request) {
        deviceService.iotDeviceBind(request);
        return Result.success();
    }

    /**
     * 获取摄像头和哨兵车绑定情况  get /smartSite/device/v2/getIotDeviceBindInfo?deviceId={deviceId}
     *
     * @return
     */
    @GetMapping("{version}/getIotDeviceBindInfo")
    @ApiOperation(value = "获取摄像头和哨兵车绑定情况")
    public ResultVo<List<IotDeviceBindInfoResponse>> getIotDeviceBindInfo(@PathVariable("version") String version, Long deviceId) {
        return Result.success(deviceService.getIotDeviceBindInfo(deviceId));
    }

    @ApiOperation(value = "查询所有边缘设备", notes = "查询所有边缘设备")
    @GetMapping("{version}/getEdgeDeviceList/{deviceTypeName}")
    @PassToken
    public ResultVo<List<DeviceInfoResponse>> getEdgeDeviceList(@PathVariable("deviceTypeName") String deviceTypeName) {
        return Result.success(deviceService.getEdgeDeviceList(deviceTypeName));
    }


    @ApiOperation(value = "查询所有设备", notes = "告警过滤器规则设备查询")
    @PostMapping("{version}/getFilterDeviceList")
    public ResultVo<List<DeviceListResponse>> getDeviceList(@PathVariable("version") String version,@RequestBody DeviceRequest request) {
        return Result.success(deviceService.getDeviceList(request));
    }



    @PostMapping("{version}/getDeviceAlgorithms")
    @ApiOperation(value = "保存设备算法参数")
    public ResultVo getDeviceAlgorithms(@PathVariable("version") String version,  @RequestBody DeviceAlgorithmRequest request) {
        return Result.success(deviceService.getDeviceAlgorithms(request));
    }

    @PostMapping("{version}/saveDeviceAlgorithms")
    @ApiOperation(value = "保存设备算法参数")
    public ResultVo saveDeviceAlgorithms(@PathVariable("version") String version, @RequestBody DeviceAlgorithmRequest request) {
        deviceService.saveDeviceAlgorithms(request);
        return Result.success();
    }

    @PostMapping("{version}/getAlgorithmType")
    @ApiOperation(value = "查询选中的算法类型")
    public ResultVo getAlgorithmType(@PathVariable("version") String version, @RequestBody DeviceAlgorithmRequest request) {
        return Result.success(deviceService.getAlgorithmType(request));
    }

    @PostMapping("{version}/putResolution")
    @ApiOperation(value = "重新获取预览图")
    public ResultVo<WebPreviewResponse> putResolution(@PathVariable("version") String version, @RequestBody AlarmTypeRequest request) {
        outDeviceService.updateResolution(request.getSn());
        return Result.success();
    }

    @PostMapping("{version}/getUnboundAreaDevice")
    @ApiOperation(value = "查询未绑定区域点位的设备")
    public ResultVo<List<DeviceUnboundAreaResponse>> getUnboundAreaDevice(@PathVariable("version") String version, @RequestBody MonitorRequest request) {
        return Result.success(deviceService.getUnboundAreaDevice(request));
    }

    @PostMapping("/handlerEnvironmentData")
    @ApiOperation(value = "处理环境监测器数据")
    public ResultVo<List<DeviceUnboundAreaResponse>> getUnboundAreaDevice(@RequestBody DeviceRequest request) {
        sdEnvironmentalMonitorSevice.handler(request.getCreateTimeBegin(),request.getCreateTimeEnd());
        return Result.success();
    }

    @PostMapping("{version}/saveDeviceLinkParams")
    @ApiOperation(value = "保存纽带参数")
    public ResultVo saveDeviceLinkParams(@PathVariable("version") String version, @RequestBody DeviceAlgorithmRequest request) {
        deviceService.saveDeviceLinkParams(request);
        return Result.success();
    }

}
