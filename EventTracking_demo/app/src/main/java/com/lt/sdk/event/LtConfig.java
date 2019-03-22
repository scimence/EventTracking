package com.lt.sdk.event;

import com.lt.function.AssetProperty;

import android.content.Context;

/** LtConfig.java: ----- 2018-6-4 上午10:44:39 wangzhongyuan */
public class LtConfig
{
    private static String configFileName = "event_tracking_config.txt";
    private static String LTSDK_SERVER_NAME = "";

    /** 获取服务器网址 */
    public static String ServerName(Context context)
    {
        if (LTSDK_SERVER_NAME.equals(""))
        {
            AssetProperty config = new AssetProperty(context, configFileName);
            LTSDK_SERVER_NAME = config.getConfig("LtsdkServerName", LTSDK_SERVER_NAME); // 获取乐堂服务器名称
        }
        return LTSDK_SERVER_NAME;
    }

    /** 获取乐堂计费服务器对应地址 */
    public static String URL(Context context, String relative)
    {
        return "http://" + ServerName(context) + relative;
    }

    // ------------------
    // 其他配置信息

    private  static AssetProperty config = null;
    /** 获取配置信息 */
    public static String getConfig(Context context, String key, String defultValue)
    {
        if(config == null) config = new AssetProperty(context, configFileName);
        return  config.getConfig(key, defultValue);   // 获取乐堂服务器名称
    }
}
