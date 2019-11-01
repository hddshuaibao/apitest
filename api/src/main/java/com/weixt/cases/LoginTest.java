package com.weixt.cases;

import com.alibaba.fastjson.JSONObject;
import com.weixt.config.TestConfig;
import com.weixt.model.InterfaceName;
import com.weixt.model.LoginCase;
import com.weixt.utils.ConfigFile;
import com.weixt.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginTest {

    @BeforeTest(groups = "loginTrue196")
    public void beforeTest(){
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.versionSaveUrl = ConfigFile.getUrl(InterfaceName.VERSIONSAVE);
        TestConfig.versionListUrl = ConfigFile.getUrl(InterfaceName.VERSIONLIST);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
        TestConfig.cost_type_configSaveUrl = ConfigFile.getUrl(InterfaceName.COSTTYPECONFIG);


    }

    @Test(groups = "loginTrue196")
    public void loginTrue() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getAutoSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        String result = getResult(loginCase);
        //Assert.assertEquals(loginCase.getExpected(),result);

    }



    private String getResult(LoginCase loginCase) throws IOException {

        //        表单方式
        HttpPost post = new HttpPost("http://weixt.spacetech.com.cn:8090/weixt/api/user_user_login");
        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
        pairList.add(new BasicNameValuePair("apiparams",loginCase.getApiparams() ));
        post.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));
        post.setHeader("Content-type","application/x-www-form-urlencoded");
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        JSONObject jsonResult = JSONObject.parseObject(result);
        String data = jsonResult.getString("data");
        JSONObject dataJson = JSONObject.parseObject(data);
        TestConfig.token = dataJson.getString("token");
        System.out.println(result);
        System.out.println(TestConfig.token);
        return result;

    }

}
