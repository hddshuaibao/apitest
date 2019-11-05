package com.weixt.cases;

import com.alibaba.fastjson.JSONObject;
import com.weixt.config.TestConfig;
import com.weixt.model.CostBalance;
import com.weixt.model.GetParam;
import com.weixt.utils.ConfigFile;
import com.weixt.utils.DatabaseUtil;
import com.weixt.utils.DateUtil;
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

public class Cost_saveInitBalanceTest {

    @Test(dependsOnGroups = "loginTrue196")
    public void saveInitBalanceTest() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getAutoSession();
        SqlSession sqlSession1 = DatabaseUtil.getTestSession();
        GetParam getParam = sqlSession.selectOne("cost_type_configSaveCase",7);

        String result = getResult(getParam);
        JSONObject jsonObject = JSONObject.parseObject(result);
        Assert.assertEquals(jsonObject.get("data"),getParam.getExpected());
        CostBalance costBalance = sqlSession1.selectOne("cost_Init_Balance", DateUtil.getCurrentDate()+"%");
        Assert.assertEquals(costBalance.getCampusid(),196);
        System.out.println("初始化成功！");

        


    }

    private String getResult(GetParam getParam) throws IOException {

        HttpPost post = new HttpPost(ConfigFile.getUrlNew(getParam.getApi()));
        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
        pairList.add(new BasicNameValuePair("apiparams",getParam.getApiparams() ));
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
