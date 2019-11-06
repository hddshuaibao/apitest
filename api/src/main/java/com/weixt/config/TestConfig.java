package com.weixt.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

import java.math.BigInteger;
import java.util.List;

public class TestConfig {

    public static String loginUrl;
    public static String versionSaveUrl;
    public static String versionListUrl;
    public static String cost_type_configSaveUrl;
    public static String cost_type_listCostTypeUrl;
    public static String cost_DayDetailSaveUrl;
    public List<BigInteger> typeId;

    public List<BigInteger> getTypeId() {
        return typeId;
    }

    public void setTypeId(List<BigInteger> typeId) {
        this.typeId = typeId;
    }

    public static DefaultHttpClient defaultHttpClient;
    public static CookieStore store;
    public static String token;
}
