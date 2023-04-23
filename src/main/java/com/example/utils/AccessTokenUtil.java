package com.example.utils;

import com.alibaba.fastjson.JSON;
import com.aliyun.dingtalkcontact_1_0.models.GetUserHeaders;
import com.aliyun.dingtalkcontact_1_0.models.GetUserResponse;
import com.aliyun.dingtalkoauth2_1_0.models.GetUserTokenRequest;
import com.aliyun.dingtalkoauth2_1_0.models.GetUserTokenResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccessTokenUtil {
    public static com.aliyun.dingtalkoauth2_1_0.Client createClient() throws Exception {
        Config config = new Config();
        config.protocol = "https";
        config.regionId = "central";
        return new com.aliyun.dingtalkoauth2_1_0.Client(config);
    }

    public static String getUserToken(String authCode) throws Exception {
        String accessToken = "";
        com.aliyun.dingtalkoauth2_1_0.Client client = Test.createClient();
        GetUserTokenRequest getUserTokenRequest = new GetUserTokenRequest()
                .setClientId("dingj0hs12hws4mp3wvu") //第一步创建应用时获取的AppKey。
                .setClientSecret("t88Fl32Ez2ovwwYdqjuRckbl45RG2O1sj0CCifKjqUAJs7AZig1hwRD8DzQbUNJF") //第一步创建应用时获取的AppSecret。
                .setCode(authCode) //第四步获取的 authCode。
                .setGrantType("authorization_code");
        log.info("AccessTokenUtil_getUserToken_authCode:{}",authCode);
        try {
            GetUserTokenResponse userToken = client.getUserToken(getUserTokenRequest);
            accessToken = userToken.body.accessToken;
            log.info("AccessTokenUtil_getUserToken_accessToken:{}",accessToken);
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
        return accessToken;
    }

    public static com.aliyun.dingtalkcontact_1_0.Client createClient2() throws Exception {
        Config config = new Config();
        config.protocol = "https";
        config.regionId = "central";
        return new com.aliyun.dingtalkcontact_1_0.Client(config);
    }

    public static GetUserResponse getUserInfo(String accessToken) throws Exception {
        log.info("AccessTokenUtil_getUserInfo111");
        com.aliyun.dingtalkcontact_1_0.Client client = createClient2();
        GetUserHeaders getUserHeaders = new GetUserHeaders();
        getUserHeaders.xAcsDingtalkAccessToken = accessToken;//第五步获取的个人用户Token。
        log.info("AccessTokenUtil_getUserInfo_accessToken:{}",accessToken);
        GetUserResponse response = null;
        try {
//            client.getUserWithOptions("me", getUserHeaders, new RuntimeOptions());

            response = client.getUserWithOptions("me", getUserHeaders, new RuntimeOptions());
            log.info("AccessTokenUtil_getUserInfo_response:{}", JSON.toJSONString(response));

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
        return response;

    }
//    public static String getToken() {
//        String accessToken = "";
//        try {
//            DingTalkClient client1 = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
//            OapiGettokenRequest req1 = new OapiGettokenRequest();
//            req1.setAppkey("dingj0hs12hws4mp3wvu");
//            req1.setAppsecret("t88Fl32Ez2ovwwYdqjuRckbl45RG2O1sj0CCifKjqUAJs7AZig1hwRD8DzQbUNJF");
//            req1.setHttpMethod("GET");
//            OapiGettokenResponse rsp1 = client1.execute(req1);
//            log.info("rsp1:{}",rsp1.getBody());
//            accessToken = rsp1.getAccessToken();
//        } catch (Exception e) {
//            //} catch (ApiException e) {
//            e.printStackTrace();
//        }
//        return accessToken;
//    }
}
