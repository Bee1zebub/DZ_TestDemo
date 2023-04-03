package com.example.service.app.device.impl;

import com.example.dto.app.device.request.DeviceRequest;
import com.example.dto.app.device.response.DeviceListResponse;
import com.example.mapper.app.DeviceMapper;
import com.example.service.app.device.DeviceService;
import com.example.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public PageUtil<DeviceListResponse> getDeviceListPage(DeviceRequest request) {
        //根据 request 中的信息验证整理，然后调用Dao层
        PageHelper.startPage(request.getPage(),request.getPageSize());
//        deviceMapper
        return null;
    }
}
