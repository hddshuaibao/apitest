package com.weixt.cases;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weixt.config.TestConfig;
import com.weixt.model.CostTypeConfig;
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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Cost_type_listCostTypeTest {


    @Test(dependsOnGroups = "loginTrue196", description = "查询配置列表")
    public void configListTest() throws IOException {
        SqlSession session = DatabaseUtil.getAutoSession();
        SqlSession session1 = DatabaseUtil.getTestSession();
        GetParam getParam = session.selectOne("cost_type_listCostTypeCase",4);
        System.out.println(getParam.getExpected());
        List<CostTypeConfig> costTypeConfigList =session1.selectList(getParam.getExpected(),196);

        String result = getResult(getParam);
        JSONObject jsonResult = JSONObject.parseObject(result);

        System.out.println("data:"+jsonResult.getString("data"));
        JSONObject jsonData = JSONObject.parseObject(jsonResult.getString("data"));
        JSONArray jsonArray = JSONArray.parseArray(jsonData.getString("listCostTypeJson"));

        Assert.assertEquals(costTypeConfigList.size(),jsonArray.size());
        for (Object object:jsonArray){
            System.out.println("list内容："+object.toString());

        }

        for (int i = 0;i<costTypeConfigList.size();i++){
            Assert.assertEquals(costTypeConfigList.get(i).toString(),jsonArray.get(i).toString());



        }



    }

    private String getResult(GetParam getParam) throws IOException {
        HttpPost post = new HttpPost(TestConfig.cost_type_listCostTypeUrl);
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
