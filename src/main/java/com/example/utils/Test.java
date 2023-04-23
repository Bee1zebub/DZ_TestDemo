package com.example.utils;

import com.alibaba.fastjson.JSON;
import com.aliyun.dingtalkoauth2_1_0.models.GetUserTokenRequest;
import com.aliyun.dingtalkoauth2_1_0.models.GetUserTokenResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;

public class Test {
    public static com.aliyun.dingtalkoauth2_1_0.Client createClient() throws Exception {
        Config config = new Config();
        config.protocol = "https";
        config.regionId = "central";
        return new com.aliyun.dingtalkoauth2_1_0.Client(config);
    }
    public  void getUserToken() throws Exception {
        com.aliyun.dingtalkoauth2_1_0.Client client = Test.createClient();
        GetUserTokenRequest getUserTokenRequest = new GetUserTokenRequest()
                .setClientId("dingj0hs12hws4mp3wvu") //第一步创建应用时获取的AppKey。
                .setClientSecret("t88Fl32Ez2ovwwYdqjuRckbl45RG2O1sj0CCifKjqUAJs7AZig1hwRD8DzQbUNJF") //第一步创建应用时获取的AppSecret。
                .setCode("7e4fbc9f0c113001a810dfcf1017db2f") //第四步获取的authCode。
                .setGrantType("authorization_code");
        try {
            GetUserTokenResponse userToken = client.getUserToken(getUserTokenRequest);
            System.out.println(JSON.toJSONString(userToken));
        } catch (TeaException err) {
            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
                // err 中含有 code 和 message 属性，可帮助开发定位问题
                System.out.println(JSON.toJSONString(err));
            }

        } catch (Exception _err) {
            TeaException err = new TeaException(_err.getMessage(), _err);
            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
                // err 中含有 code 和 message 属性，可帮助开发定位问题
                System.out.println(JSON.toJSONString(err));

            }

        }
    }

}