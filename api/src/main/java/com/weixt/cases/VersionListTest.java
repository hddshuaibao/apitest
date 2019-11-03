package com.weixt.cases;

import com.alibaba.fastjson.JSONArray;
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

public class VersionListTest {

    @Test(dependsOnGroups = "loginTrue")
    public void versionList() throws IOException {

        SqlSession session = DatabaseUtil.getTestSession();
        GetParam getParam = session.selectOne("versionListCase",2);
        System.out.println(getParam.toString());
        System.out.println(TestConfig.versionListUrl);

        String result = getResult(getParam);
        Assert.assertEquals(getParam.getExpected(),result);

    }


    private String getResult(GetParam getParam) throws IOException {
        HttpPost post = new HttpPost(TestConfig.versionListUrl);
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
