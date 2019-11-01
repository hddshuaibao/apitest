package com.weixt.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestConfig {

    public static String loginUrl;
    public static String versionSaveUrl;
    public static String versionListUrl;
    public static String cost_type_configSaveUrl;


    public static DefaultHttpClient defaultHttpClient;
    public static CookieStore store;
    public static String token;
}
