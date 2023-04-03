package com.example.mapper.app;

import com.example.dto.app.device.request.DeviceRequest;
import com.example.dto.app.device.response.DeviceListResponse;
import com.example.sqlprovider.DeviceProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface DeviceMapper {

    @SelectProvider(type = DeviceProvider.class,method = "")
    List<DeviceListResponse> findBy(@Param("request") DeviceRequest request);
}
