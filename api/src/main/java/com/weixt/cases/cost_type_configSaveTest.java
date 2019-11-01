package com.weixt.cases;

import com.alibaba.fastjson.JSONObject;
import com.weixt.config.TestConfig;
import com.weixt.model.GetParam;
import com.weixt.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class cost_type_configSaveTest {


    @Test(dependsOnGroups = "loginTrue196")
    public void configSave() throws IOException {

        SqlSession session = DatabaseUtil.getAutoSession();
        GetParam getParam = session.selectOne("cost_type_configSaveCase",3);
        System.out.println(TestConfig.cost_type_configSaveUrl);

        String result = getResult(getParam);
        JSONObject jsonResult = JSONObject.parseObject(result);
        String ret = jsonResult.getString("ret");
        JSONObject dataJson = JSONObject.parseObject(ret);
        System.out.println(dataJson.get("code"));
        Assert.assertEquals(getParam.getExpected(),dataJson.get("code"));


    }

    private String getResult(GetParam getParam) throws IOException {

        HttpPost post = new HttpPost(TestConfig.cost_type_configSaveUrl);
        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
        pairList.add(new BasicNameValuePair("apiparams",getParam.getApiparams() ));
        post.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));
        post.setHeader("Content-type","application/x-www-form-urlencoded");
        post.setHeader("Cookie","JSSSID_COOKIE="+TestConfig.token);
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        return result;


    }


}
