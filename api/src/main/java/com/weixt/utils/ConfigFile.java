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

        }

        testUrl = address + uri;
        return testUrl;


    }
}
