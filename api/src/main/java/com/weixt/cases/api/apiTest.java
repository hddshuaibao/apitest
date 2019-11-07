package com.weixt.cases.api;

import com.weixt.config.TestConfig;
import com.weixt.model.api.apiCases;
import com.weixt.utils.ConfigFile;
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

public class apiTest {



    @Test(dependsOnGroups = "loginTrue196",description = "测试集")
    public void apiCases() throws IOException {

        SqlSession sqlSession = DatabaseUtil.getAutoSession();
        List<apiCases> apiCasesList = sqlSession.selectList("apiCases","foodfee");

        for(int i = 0;i<apiCasesList.size();i++){
            String result = getResult(apiCasesList.get(i).getApi(),apiCasesList.get(i).getApi_params());
            Assert.assertEquals(result,apiCasesList.get(i).getExpected(),"失败用例为："+apiCasesList.get(i).getId());
            System.out.println(apiCasesList.get(i).getId()+":actual:"+result+"   "+"expected:"+apiCasesList.get(i).getExpected());

        }





    }

    private String getResult(String api, String api_params) throws IOException {

        HttpPost post = new HttpPost(ConfigFile.getUrlNew(api));
        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
        pairList.add(new BasicNameValuePair("apiparams",api_params));
        post.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));
        post.setHeader("Content-type","application/x-www-form-urlencoded");
        post.setHeader("Cookie","JSSSID_COOKIE="+ TestConfig.token);
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        return result;



    }
}
