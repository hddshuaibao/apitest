package com.weixt.cases;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.weixt.config.TestConfig;
import com.weixt.model.CostTypeConfig;
import com.weixt.model.GetParam;
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

public class cost_type_configSaveTest {


    @Test(dependsOnGroups = "loginTrue196",description = "新增配置项")
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

    @Test(dependsOnGroups = "loginTrue196",description = "修改配置信息")
    public void configUpdate() throws IOException {


        SqlSession sqlSession = DatabaseUtil.getAutoSession();
        SqlSession sqlSession1 = DatabaseUtil.getTestSession();
        GetParam getParam = sqlSession.selectOne("cost_type_configSaveCase",6);
        List<CostTypeConfig> costTypeConfigList =sqlSession1.selectList(getParam.getExpected(),196);

        JSONObject jsonObject = JSONObject.parseObject(getParam.getApiparams());
        JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.getString("params"));
        JSONArray jsonArray = JSONArray.parseArray(jsonObject1.getString("costTypeList"));
        jsonArray.getJSONObject(0).put("costTypeid",costTypeConfigList.get(0).getId());
        jsonArray.getJSONObject(1).put("costTypeid",costTypeConfigList.get(1).getId());
        System.out.println(costTypeConfigList.get(0).getId() +"   "  +costTypeConfigList.get(1).getId());

        String result = getUpdateResult(getParam,jsonObject.toString());
        JSONObject jsonObject2 = JSONObject.parseObject("result");
        JSONObject jsonObject3 = JSONObject.parseObject(jsonObject2.getString("ret"));
        Assert.assertEquals(jsonObject3.getString("code"),200);

//        for(int i = 0;i<jsonArray.size();i++){
//            List<CostTypeConfig> costTypeConfigList1 =sqlSession1.selectList(getParam.getExpected(),196);
//            Assert.assertEquals(costTypeConfigList1.get(i).toString(),jsonArray.get(i).toString());
//
//        }




    }

    private String getUpdateResult(GetParam getParam,String params) throws IOException {

        HttpPost post = new HttpPost(ConfigFile.getUrlNew(getParam.getApi()));
        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
        pairList.add(new BasicNameValuePair("apiparams",params ));
        post.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));
        post.setHeader("Content-type","application/x-www-form-urlencoded");
        post.setHeader("Cookie","JSSSID_COOKIE="+TestConfig.token);
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        return result;

    }

    private String getResult(GetParam getParam) throws IOException {

        HttpPost post = new HttpPost(ConfigFile.getUrlNew(getParam.getApi()));
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
