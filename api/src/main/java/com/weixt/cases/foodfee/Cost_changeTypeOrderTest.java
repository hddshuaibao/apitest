package com.weixt.cases.foodfee;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Cost_changeTypeOrderTest {


    private final Logger logger = LoggerFactory.getLogger(Cost_changeTypeOrderTest.class);

    @Test(dependsOnGroups = "loginTrue196",description = "更改配置排序order=1换成order=2")
    public void  changeTypeOrderTest() throws IOException {

        String params = "";
        SqlSession sqlSession = DatabaseUtil.getAutoSession();
        SqlSession sqlSession1 = DatabaseUtil.getTestSession();
        GetParam getParam = sqlSession.selectOne("cost_type_configSaveCase",8);
        List<CostTypeConfig> costTypeConfigs = sqlSession1.selectList("cost_type_config",196);
        BigInteger costTypeid = costTypeConfigs.get(0).getId();
        logger.info("取到的typeid 为："+costTypeid);
        params = getParam.getApiparams().replace("191104143562215984",costTypeid.toString());
        logger.info("替换后的入参 "+params);

        String result = getResult(getParam,params);
        Assert.assertEquals(result,getParam.getExpected());
        logger.info("返回验证成功！");




    }

    private String getResult(GetParam getParam,String params) throws IOException {

        HttpPost post = new HttpPost(ConfigFile.getUrlNew(getParam.getApi()));
        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
        pairList.add(new BasicNameValuePair("apiparams",params ));
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
