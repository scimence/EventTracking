package com.lt.function;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import android.content.Context;
import android.util.Log;


/** AssetProperty.java: 读取assets目录中的配置文件信息----- 2018-2-27 下午8:08:10 wangzhongyuan */
public class AssetProperty
{
    // 示例：
    private void Example()
    {
        // assets目录下的文件如： assets/payconfig.txt
        // #文件内容：
        // ShowAlipay=true
        // ShowWeChat=true

        AssetProperty config = new AssetProperty(context, "payconfig.txt");
        String ShowAlipay = config.getConfig("ShowAlipay", "true");			// 读取配置信息

        // 备注：直接在文件目录下添加文件，getAssets().open()可能会报错： java.io.FileNotFoundException: payconfig.txt
        // 在assets中添加配置文件，需选中assets文件夹（右键）-> New -> File -> 输入文件名（payconfig.txt）-> Finish
    }

    // -------------------------------

    String filepath = "";	// assets目录下的文件如： assets/payconfig.txt
    Context context;
    Properties prop = null;

    /** 创建AssetProperty */
    public AssetProperty(Context context, String filepath)
    {
        this.context = context;
        this.filepath = filepath;

        // if (prop == null) prop = getAssetsProperty(context, filepath);
        if (prop == null) prop = getAssetsPropertyEncrypt(context, filepath);
    }

    /** 读取AssetProperty中的配置信息 */
    public String getConfig(String name, String defval)
    {
        if (prop == null)
            return defval;
        else return prop.getProperty(name, defval);
    }

    /** 读取Assest文件夹下资源，返回Properties */
    public static Properties getAssetsProperty(Context context, String filepath)
    {
        try
        {
            Properties prop = new Properties();
            InputStreamReader reader = new InputStreamReader(context.getAssets().open(filepath), "UTF-8");
            prop.load(reader);

            reader.close();
            return prop;
        }
        catch (Exception e)
        {
            Log.e("AssetProperty", e.toString());
        }
        return null;
    }

    /** 读取Assest文件夹下资源，返回Properties。若为加密数据则自动解密 */
    public static Properties getAssetsPropertyEncrypt(Context context, String filepath)
    {
        try
        {
            // 读取assets数据
            InputStream inputStream = context.getAssets().open(filepath);
            String data = TypeTool.InputStreamToString(inputStream);
            inputStream.close();

            // assets数据解密逻辑
            if (Encrypt.isEncrypt(data)) data = Encrypt.Encryption(data.substring(5), -65537);		// 解密数据

            // ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());
            // InputStreamReader reader = new InputStreamReader(in);
            InputStreamReader reader = TypeTool.StringToInputStreamReader(data);

            Properties prop = new Properties();
            prop.load(reader);

            reader.close();

            return prop;
        }
        catch (Exception e)
        {
            Log.e("AssetProperty", e.toString());
        }
        return null;
    }
}
