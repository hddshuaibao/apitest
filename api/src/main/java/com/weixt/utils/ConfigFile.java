package com.weixt.utils;

import com.weixt.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {

    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static  String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");
        String uri="";
        String testUrl;
        if(name == InterfaceName.VERSIONSAVE){
            uri = bundle.getString("versionSave.url");

        }else if(name == InterfaceName.LOGIN){
            uri = bundle.getString("login.url");

        }else if(name == InterfaceName.VERSIONLIST){

            uri = bundle.getString("versionList.url");

        }else if(name == InterfaceName.COSTTYPECONFIG){

            uri = bundle.getString("costTypeConfigSave.url");

        }else if(name == InterfaceName.COSTTYPELIST){
            uri = bundle.getString("costTypeList.url");

        }else if(name == InterfaceName.COSTDAYDETAILSAVE){
            uri = bundle.getString("costDayRecord_save.url");

        }

        testUrl = address + uri;
        return testUrl;


    }


    public static String getUrlNew(String api){
        String address = bundle.getString("test.url");
        String testUrl="";
        if(!api.equals("")||api!=null){
            testUrl = address+"/api/pc/"+api;
            System.out.println("request address :"+testUrl);
        }else {

            System.out.println("request address 为空");

        }

        return testUrl;

    }



}
