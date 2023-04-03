package com.example.sqlprovider;

import com.example.dto.app.device.request.DeviceRequest;
import org.apache.ibatis.annotations.Param;

public class DeviceProvider {

    public String findBy(@Param("request")DeviceRequest request){

        return null;
    }
}
