package com.example.service.app.device;

import com.example.dto.app.device.request.DeviceRequest;
import com.example.dto.app.device.response.DeviceListResponse;
import com.example.utils.PageUtil;

public interface DeviceService {
    PageUtil<DeviceListResponse> getDeviceListPage(DeviceRequest request);
}
