package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.aliyun.dingtalkcontact_1_0.models.GetUserResponse;
import com.example.result.Result;
import com.example.result.ResultVo;
import com.example.utils.AccessTokenUtil;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *
 *  第三方企业应用免登
 * @author openapi@dingtalk
 * 2020-11-3
 */
@RestController
@RequestMapping
@Slf4j
public class LoginController {

    /**
     * 欢迎页面，通过 /welcome 访问，判断后端服务是否启动
     *
     * @return 字符串 welcome
     */
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    /**
     *
     * @param authCode
     * @return
     * ServiceResult
     * 2020-11-3
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResultVo<Map<String, Object>> login (@RequestParam("code") String authCode) throws Exception {
        log.info("LoginController_login111");
        // 获取access_token，注意正式代码要有异常流处理
        String accessToken= AccessTokenUtil.getUserToken(authCode);
        GetUserResponse response = null;
        try {
            log.info("LoginController_login222");
            response = AccessTokenUtil.getUserInfo(accessToken);
            log.info("LoginController_response:{}", JSON.toJSONString(response));
        } catch (ApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return Result.success();
    }
}