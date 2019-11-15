package com.weixt.cases;

import com.alibaba.fastjson.JSONObject;
import com.weixt.config.TestConfig;
import com.weixt.model.CostDayRecord;
import com.weixt.model.GetParam;
import com.weixt.model.InterfaceName;
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

public class Cost_DayDetailSaveTest {


    @Test(dependsOnGroups = "loginTrue196",description = "保存当天的费用")
    public void DayDetailSaveTest() throws IOException {

        SqlSession sqlSession = DatabaseUtil.getAutoSession();
        SqlSession sqlSession1 = DatabaseUtil.getTestSession();
        GetParam getParam = sqlSession.selectOne("cost_type_listCostTypeCase",5);
        CostDayRecord costDayRecord = sqlSession1.selectOne("cost_day_record", DateUtil.getCurrentDate());

        String results = getResults(getParam,costDayRecord);
        JSONObject JsonResults = JSONObject.parseObject(results);
        Assert.assertEquals(JsonResults.get("data"),"更新成功");





    }

    private String getResults(GetParam getParam,CostDayRecord costDayRecord) throws IOException {
        TestConfig.cost_DayDetailSaveUrl = ConfigFile.getUrl(InterfaceName.COSTDAYDETAILSAVE);
        HttpPost post = new HttpPost(TestConfig.cost_DayDetailSaveUrl);
        JSONObject newApiparams = JSONObject.parseObject(getParam.getApiparams());
        JSONObject newApiparams2 = JSONObject.parseObject(newApiparams.getString("params"));
        newApiparams2.put("recordid",costDayRecord.getId());
        String apiparams = "{\"params\":"+newApiparams2.toString()+", \"readonly\": true }";

        System.out.println(apiparams);
        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
        pairList.add(new BasicNameValuePair("apiparams",apiparams ));
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
