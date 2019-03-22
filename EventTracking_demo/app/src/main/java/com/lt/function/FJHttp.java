package com.lt.function;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import android.util.Log;


/** FJHttp.java: ----- 2017-4-12 下午8:37:35 wangzhongyuan */
public class FJHttp
{

    public static final String DEFAULT_CHARSET = "UTF-8";
    private static int mConnectTimeout = 5000;
    private static int mReadTimeout = 15000;

    public static void setConnectTimeout(int connectTimeout)
    {
        mConnectTimeout = connectTimeout;
    }

    public static void setReadTimeout(int readTimeout)
    {
        mReadTimeout = readTimeout;
    }

    /** http请求，获取网页信息 */
    public static String request(String http, HashMap<String, String> map, String method) throws Exception
    {
        if (method == null || method.equals("")) method = "post";

        String data = "";
        Exception e0 = null;
        try
        {
            data = request(http, praseMap(map, DEFAULT_CHARSET), method, DEFAULT_CHARSET);				// 使用正常的域名访问
        }
        catch (Exception ex)
        {
            e0 = ex;
        }

        if (e0 != null)		// 若通过域名直接访问失败，则通过解析域名的ip，再次进行访问
        {
            try
            {
                data = request(getIpUrl(http), praseMap(map, DEFAULT_CHARSET), method, DEFAULT_CHARSET);// 使用域名对应的ip进行访问
            }
            catch (Exception ex)
            {
                throw e0;
            }
        }

        return data;
    }

    public static String request(String http, HashMap<String, String> map, String method, String charset) throws Exception
    {
        return request(http, praseMap(map, charset), method, charset);
    }

    public static String request(String http, String data, String method) throws Exception
    {
        return request(http, data, method, DEFAULT_CHARSET);
    }

    public static boolean NeedEncoder = true;

    public static String request(String http, String data, String method, String charset) throws Exception
    {
        data = (data == null) ? "" : data;
        if (NeedEncoder) data = EncoderTool_Alphabet.Encode(data);

        if ("GET".equalsIgnoreCase(method) && !"".equals(data))
        {
            http += "?" + data;
            data = "";
        }

        HttpURLConnection conn = (HttpURLConnection) new URL(http).openConnection();
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(mConnectTimeout);
        conn.setReadTimeout(mReadTimeout);
        if ("POST".equalsIgnoreCase(method)) conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.connect();

        // send data
        if (!"".equals(data))
        {
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), charset);
            writer.write(data);
            writer.flush();
            writer.close();
        }
        // receive data
        StringBuffer sb = new StringBuffer();
        if (conn.getResponseCode() == 200)
        {
            InputStreamReader reader = new InputStreamReader(conn.getInputStream(), charset);
            int len;
            char[] buf = new char[1024];
            while ((len = reader.read(buf)) != -1)
            {
                sb.append(buf, 0, len);
            }
            reader.close();
        }
        conn.disconnect();
        String resultData = sb.toString();
        resultData = EncoderTool_Alphabet.Decode(resultData);
        return resultData;
    }

    /** 使用指定的字符集，转化map为http请求参数串 */
    public static String praseMap(HashMap<String, String> map, String charset) throws Exception
    {
        if (charset == null || charset.equals("")) charset = "UTF-8";	// 默认字符集

        StringBuffer sb = new StringBuffer();
        if (map != null && !map.isEmpty())
        {
            for (String k : map.keySet())
            {
                if (k != null && !"".equals(k))
                {
                    String v = map.get(k);
                    if (NeedEncoder)
                        sb.append("&").append(k).append("=").append(v);	// 使用编码方式
                    else sb.append("&").append(k).append("=").append(URLEncoder.encode(v, charset));
                }
            }
        }
        String tmp = sb.toString();
        return tmp.equals("") ? "" : tmp.substring(1);
    }

    /** 获取url中的域名信息 */
    // LTSDK_ORDER_URL = "http://netuser_us.warfarestrike.com/order/allplat";
    public static String getServerName(String url)
    {
        url = url.trim();

        if (url.contains("//"))
        {
            int index = url.indexOf("//") + "//".length();
            url = url.substring(index);		// netuser_us.warfarestrike.com/order/allplat
        }
        if (url.contains("/"))
        {
            int index = url.indexOf("/");
            url = url.substring(0, index);	// netuser_us.warfarestrike.com
        }

        return url;
    }

    /** 解析域名为ip信息 */
    // LTSDK_ORDER_URL = "http://netuser_us.warfarestrike.com/order/allplat";
    public static String getIP(String url)
    {
        String ip = "";

        try
        {
            String ServerName = getServerName(url);
            InetAddress address = InetAddress.getByName(ServerName);
            ip = address.getHostAddress().toString();

            Log.i("FJHttp2:", " 域名(" + ServerName + ") ->> Ip(" + ip + ")");
        }
        catch (Exception e)
        {
            Log.i("FJHttp2", "网络异常，域名(" + url + ")无法访问，解析Ip失败！");
            Log.e("FJHttp2", e.toString());
        }

        return ip;
    }

    /** 替换url中的主机域名为解析获得的ip */
    public static String getIpUrl(String url)
    {
        String ServerName = getServerName(url);
        String ip = getIP(url);
        if (!ip.equals("")) url = url.replaceFirst(ServerName, ip);
        return url;
    }
}

