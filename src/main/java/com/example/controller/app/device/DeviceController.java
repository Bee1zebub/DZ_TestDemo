package com.example.controller.app.device;

import com.example.constant.SwaggerConstant;
import com.example.result.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(value = "device", tags = {SwaggerConstant.DEVICE})
@RequestMapping(value = "smartSite/device", produces = "application/json;charset=utf-8")
public class DeviceController {

    //@Log(value = "记录获取设备列表操作日志",logType = 2,operationType = 3,module = 1)
    @ApiOperation(value = "设备列表", notes = "设备列表接口")
    @PostMapping("{version}/deviceList")
    public ResultVo<PageUtil>
}
