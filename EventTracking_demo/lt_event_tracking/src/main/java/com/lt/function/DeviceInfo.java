package com.lt.function;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;


public class DeviceInfo
{
    private static String sDeviceID;

    // <!-- 读取手机IMEI的权限，须在获得此权限后再初始化sdk，如果缺少此权限，会以AndroidID作为设备唯一标识符 -->
    // <uses-permission android:name="android.permission.READ_PHONE_STATE" />

    /** 获取设备Id */
    public static String getDeviceID(Context context)
    {
        if ((sDeviceID != null) && (!"unknown".equals(sDeviceID))) return sDeviceID;

        try
        {
            TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
            sDeviceID = tm.getDeviceId();

            if ((sDeviceID == null) || (sDeviceID.length() == 0))
            {
                sDeviceID = getAndroidId(context);
            }

            return sDeviceID;
        }
        catch (Exception e)
        {}

        sDeviceID = getAndroidId(context);

        return sDeviceID;
    }

    /** 获取安卓Id */
    public static String getAndroidId(Context context)
    {
        String androidid = "unknown";
        try
        {
            androidid = Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if ((androidid == null) || (androidid.length() == 0)) { return "unknown"; }
        return androidid;
    }
}

