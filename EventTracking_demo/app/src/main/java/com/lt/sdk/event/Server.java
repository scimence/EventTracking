
package com.lt.sdk.event;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.lt.function.CallBack2;
import com.lt.function.FJHttp;
import com.lt.function.ThreadTool;


public class Server
{
    /** 发送初始化信息 */
    public static void SendInit(final Context context, final CallBack2 call, final String deviceId, final String appId, final String channelId, final String SdkVersion)
    {
        ThreadTool.RunInCachedThread(new ThreadTool.ThreadPram()
        {
            @Override
            public void Function()
            {
                // 在非主线程执行逻辑
                try
                {
                    // String Url = LtConfig.URL(context, "/Coupon/lists");
                    String Url = LtConfig.URL(context, "/index.php/api/game/getUuid");

                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("deviceId", deviceId);
                    map.put("appId", appId);
                    map.put("channelId", channelId);
                    map.put("platTye", "android");
                    map.put("SdkVersion", SdkVersion);

                    // AddSign(map, Url);

                    // String rdata = "";
                    String rdata = FJHttp.request(Url, map, "post");

                    EventSDK.showText("SendInit信息 ->> " + Url + "?" + FJHttp.praseMap(map, FJHttp.DEFAULT_CHARSET));    // 请求参数信息
                    EventSDK.showText("服务器返回信息 ->> " + rdata);

                    // // 解析获取的ClientId
                    // JSONObject userJson = new JSONObject(rdata);
                    // String clientId = userJson.optString("uuid", "");

                    if (call != null) call.OnSuccess(rdata);
                }
                catch (Exception ex)
                {
                    EventSDK.showToast(context, "SendInit信息异常！");
                    ex.printStackTrace();

                    if (call != null) call.Onfail();
                }
            }
        });
    }

    /** 发送订单信息 */
    public static void SendOrder(final Context context, final CallBack2 call, final String deviceId, final String appId, final String channelId, final String OrderId, final String ProductId, final String ProductName, final String ProductMoney)
    {
        ThreadTool.RunInCachedThread(new ThreadTool.ThreadPram()
        {
            @Override
            public void Function()
            {
                // 在非主线程执行逻辑
                try
                {
                    // String Url = LtConfig.URL(context, "/Coupon/lists");
                    String Url = LtConfig.URL(context, "/index.php/api/game/getUuid");

                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("deviceId", deviceId);
                    map.put("appId", appId);
                    map.put("channelId", channelId);
                    map.put("platTye", "android");
                    map.put("OrderId", OrderId);
                    map.put("ProductId", ProductId);
                    map.put("ProductName", ProductName);
                    map.put("ProductMoney", ProductMoney);

                    // AddSign(map, Url);

                    // String rdata = "";
                    String rdata = FJHttp.request(Url, map, "post");

                    EventSDK.showText("SendOrder信息 ->> " + Url + "?" + FJHttp.praseMap(map, FJHttp.DEFAULT_CHARSET));    // 请求参数信息
                    EventSDK.showText("服务器返回信息 ->> " + rdata);

                    // // 解析获取的ClientId
                    // JSONObject userJson = new JSONObject(rdata);
                    // String clientId = userJson.optString("uuid", "");

                    if (call != null) call.OnSuccess(rdata);
                }
                catch (Exception ex)
                {
                    EventSDK.showToast(context, "SendOrder信息异常！");
                    ex.printStackTrace();

                    if (call != null) call.Onfail();
                }
            }
        });
    }


    /** 发送自定义事件 */
    public static void SendEvent(final Context context, final CallBack2 call, final String deviceId, final String appId, final String channelId, final String eventName)
    {
        ThreadTool.RunInCachedThread(new ThreadTool.ThreadPram()
        {
            @Override
            public void Function()
            {
                // 在非主线程执行逻辑
                try
                {
                    // String Url = LtConfig.URL(context, "/Coupon/lists");
                    String Url = LtConfig.URL(context, "/index.php/api/game/getUuid");

                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("deviceId", deviceId);
                    map.put("appId", appId);
                    map.put("channelId", channelId);
                    map.put("platTye", "android");
                    map.put("eventName", eventName);

                    // AddSign(map, Url);

                    // String rdata = "";
                    String rdata = FJHttp.request(Url, map, "post");

                    EventSDK.showText("SendEvent("+eventName+")信息 ->> " + Url + "?" + FJHttp.praseMap(map, FJHttp.DEFAULT_CHARSET));    // 请求参数信息
                    EventSDK.showText("服务器返回信息 ->> " + rdata);

                    // // 解析获取的ClientId
                    // JSONObject userJson = new JSONObject(rdata);
                    // String clientId = userJson.optString("uuid", "");

                    if (call != null) call.OnSuccess(rdata);
                }
                catch (Exception ex)
                {
                    EventSDK.showToast(context, "SendEvent("+eventName+")信息异常！");
                    ex.printStackTrace();

                    if (call != null) call.Onfail();
                }
            }
        });
    }

    // -------------------

    /** 获取ClientId信息 */
    public static void GetClientId(final Context context, final CallBack2 call)
    {
        ThreadTool.RunInCachedThread(new ThreadTool.ThreadPram()
        {
            @Override
            public void Function()
            {
                // 在主线程执行逻辑
                try
                {
                    // String Url = LtConfig.URL(context, "/Coupon/lists");
                    String Url = LtConfig.URL(context, "/index.php/api/game/getUuid");

                    HashMap<String, String> map = new HashMap<String, String>();
                    // map.put("game_id", appId);
                    // map.put("uid", uid);
                    // map.put("appNames", appNames);
                    // map.put("language", language);

                    // AddSign(map, Url);

                    // String rdata = "";
                    String rdata = FJHttp.request(Url, map, "post");

                    EventSDK.showText("GetClientId信息 ->> " + Url + "?" + FJHttp.praseMap(map, FJHttp.DEFAULT_CHARSET));    // 请求参数信息
                    EventSDK.showText("服务器返回信息 ->> " + rdata);

                    // 解析获取的ClientId
                    JSONObject userJson = new JSONObject(rdata);
                    String clientId = userJson.optString("uuid", "");

                    if (call != null) call.OnSuccess(clientId);
                }
                catch (Exception ex)
                {
                    EventSDK.showToast(context, "GetClientId信息异常！");
                    ex.printStackTrace();
                }
            }
        });
    }

    // private static boolean localDebug = true;

    /** 上传客户端信息；并获取服务器端返回的任务状态信息 */
    public static void GetServerData(final Context context, final String PackageName, final String ClientId, final String installedApps, final String language,
                                     final String GameType, final String SecureAndroidId, final String SdkVersion, final String gameInfo, final CallBack2 call)
    {
        ThreadTool.RunInCachedThread(new ThreadTool.ThreadPram()
        {
            @Override
            public void Function()
            {
                // 在主线程执行逻辑
                try
                {
                    // String Url = LtConfig.URL(context, "/Coupon/lists");
                    String Url = LtConfig.URL(context, "/index.php/api/game/index");

                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("source_app_name", PackageName);
                    map.put("uuid", ClientId);
                    map.put("app_names", installedApps);
                    map.put("language", language);
                    map.put("gameType", GameType);
                    map.put("SecureAndroidId", SecureAndroidId);
                    map.put("SdkVersion", SdkVersion);
                    map.put("gameInfo", gameInfo);

                    // AddSign(map, Url);

                    String rdata = FJHttp.request(Url, map, "post");

                    // Url = "https://raw.githubusercontent.com/joymeng/thumbsup/master/files/page6.txt";
                    // String rdata = WebTool.GetString(Url);

                    // String str =
                    // "DATA$EJCJCLJRFNFKFJGIJJJKISJMJNJJGGHGGGGYGWGUGQFMFKFJGGJDJLIZGIHGGEGGEBBXCFDYBXAEEAAKASDXAKBGGIGSFLFIFJGIJFJHIUIVGHHGGGGGGVGIGSFNFKFHGGJLITJLJBGGHGGGJMJKJLIVGRFNFKFHGGJLJAJHJPIPIRJAIWGIHEGEGIGXHAGSGVGZJTGYGWHBGZGWJUIVJHJDGSJDJMJLIUJBGUJMJAJNJDISJKJNJIGSIUIXJFJHGIGQFLFJFJGIIXIRJFIXGIHGGEJRFMFKFJFHGGJIJBIVJMJLJIIWGXGIHEGEGIJAJMJMJGHEINGVIOGTIXJGJEJBJDIVGSIUJEJFJFISJBGUIVJHJDIMGUJLJMIRJKJBIVIOGVIRIUJEJBJGIMGTJBJFIZIOGTIXISJFIXIPJJJEJBIWIXJIIMGUGXIRJJJCJBIWIXJKGSJGJFIZGIGQFLFKFJFJGIJGIZIUJMJNJIIVGYGIHGGGGGIYJLJMJIHEIMGVIOGVIZJEJCJAJDIXGSITJEJFJHIUIZGSIUJHJFIMGTJLJMITJMIZITINGVITIUJDJBJGIOGVIZJDIYIOGVIXIRJFIXIRJLJCIZIVIXJKIMGTGXIRJLJEIZIUIWJKGUJGJEIZGIGSFNFIFHFIGIJIIZITJMJNJKIXGXGGHFGGGIIYJKJMJIHGIOGTIMGUIZJGJCIZJDIXGUIVJCJDJGIUJBGSITJHJFIOGVJJJKISJMJBITIMGVITIWJFIZJEINGVJBJDIXIOGVIZITJDIVIQJLJEIZIUIXJKIOGVGVIPJKJEJBIUIVJKGUJIJGIXGGGRFNFKFHFHGIJMJBJMJCIVGHHGGGGGDXAHCBEACBBODZBZALDYCEBDEDBJCDEJCIAMEBAQCFDXAPAYDZAHAPEACACGEDAJARDXCGADGIGSFLFIFIFJGIJDJFIWIXGIHGGEGGGWGIFNFIFHJVGSFNFKFHGGIVITJMIRGGHGGGINJTFLFIFIFJGIIRIPJBIWGIHGGEGGGWHAGIGQFLFKFJFJGIIXIRJEIXIRJCJFIZJHGIHGGEGGIZJMJMJGHEIOGVIOGVIXJEJDJBJDIVGSIVJEJFJHISIZGTIVJHJDIMGVJLJMITJKIZIUIOGVIRIUJFJBJGIOGTIZJEIZIOGTIXITJFIXIRIZITJGJGIOGTHAGUJIJGIZGGGQFMFKFJFHGGJNJKJEGIHEGEGHGIGSFLFIFJFJGIJMIZJKJDIXGIHEGEGIDZBWAODYAIAREAAOAHDXBWBCDYCJCHDXALBJEJCIAMECAQCFDZCKAXDYAHAPEACACHDZBNAYDXAKBYGIGSFLFIFJFJGIJFJJIXIQJIJBITJKJNJKIXGIHEGEGHJAJMJKJGHGIOGVIOGTIXJFJEJBJBIVGUIVJEJFJFISJAGUIVJFJDIOGVJLJMIRJKJAIVIOGTIRIWJFJBJGIMGTJAJFIZIMGTIZITJFIXIPJDJKIZIOGTIWIUGUJIJGIXGGGRFNFKFHFHGIJEJBIZIYJKIQJBJFIXGGHGGGGIJAJKJKJHHGIOGTIMGVIZJGJEIZJBIWGUIVJCJDJHIUJBGUITJFJEIOGVJJJKITJMJBIVIMGTISIWJFIZJEIOGVJBJFIXIMGUIZITJDIVIRITJMJMIVJEJLJBJHJEIMGVJEJBIZIYJKGTJIJGIXGGGSFNFKFJFHGGIVITJKJBIPJBJFIZGIHEGEGHJAJMJKJGHGIOGVIOGTIXJFJEJBJBIVGUIVJEJFJFISJAGUIVJFJDIOGVJLJMIRJKJAIVIOGTIRIWJFJBJGIMGTJAJFIZIMGTIZITJFIXIPIRJLJMIXJEJKJBJHJGIOGTIUISJKJDGSJGJGIZGIGSFLFIFIFJGIIRJGJIIRJNJKJCGGHFGGGIJJIZJGITJPIXIZISJGHGIOGTIMGVJNJLIXJIIZJFIYJHHJJLJBIWHJHBGXHCHAGYHBHDGYHAGZGIGSFLFIFIFJGIJGIRIVJDITIZIVIPJFITJFIVGGHGGGGIJPIVIZITJHGIGQFLFKFJFJGIJGJIJAIVIXGGHEGGGIGWGIGQFLFJFJFJGGITJHJNJGJMIVJIGHHGGGGGGXGIGSFNFKFHFHGHJFJLIXIPJLJPJBJMITIYGHHGGGGGGVGIFNFKFJJTGQGFJTFNFIFHFJGIITIRIZIUGHHGGGGGGVHBGIGSFNFIFHFIGIIZIRJDIXIRJEJHIXJFGHHGGGGGIYJMJMJIHGIMGTINGVIZJEJCJBJDIXGUITJCJEJHIUIZGSIVJHJFIOGTJJJLITJMIZITIOGVITIWJDIZJFIOGVIZJDIZIOGVIZIRJDIWIRJBITJFJGIOGVHCGSJGJFIZGIGQFLFKFJFJGIJLJIJDGIHGGEGGGIGSFNFKFHFHGHJMJBJKJCIXGIHGGGGGDZCACJEBCHBFEACEAKEAABBVDZBIAJEBBIBAGXGIGSFLFIFIFJGIJDJJIZIRJIJBITJKJMJKIXGGHEGGGIJAJMJKJGHFIOGVIMGTIZJGJEJBJBIVGTIVJEJDJFIUJBGUIVJFJDINGVJLJKIRJMJBIVIOGTIRIVJFJBJEIMGVJBJFIZIMGTIYITJFIVIPJFJLIZIOGTIWITGUJIJEIXGIGSFNFKFHFHGHJEJBIXIYJMIRJBJFIXGGHFGGGIIYJKJMJIHGIOGTIMGUIZJGJCIZJDIXGUIVJCJDJGIUJBGSITJHJFIOGVJJJKISJMJBITIMGVITIWJFIZJEINGVJBJDIXIOGVIZITJDIVIQITJMJKIVJGJMJBJHJEIMGUJEJBIXIYJMGUJIJGIXGGGRFNFKFHFHGIIWITJKJBIPJAJFIZGGHEGGGIJAJMJKJGHFIOGVIMGTIZJGJEJBJBIVGTIVJEJDJFIUJBGUIVJFJDINGVJLJKIRJMJBIVIOGTIRIVJFJBJEIMGVJBJFIZIMGTIYITJFIVIPITJMJMIXJEJKJAJHJGIMGTIWITJKJDGSJGJFIZGIGQFLFKFJFJGIIRJGJHIRJNJIJCGIHGGGGIJJJEJKJLIWJBGVGXGYHEHGIMGTINGVJNJJIVJKIOGVJIJIJFIXJBJEIVIMGVGXGWHBHBGVGZHCGYHCGVHAGYGIGSFLFIFIFJGIJGIRIVJDITIZIVIPJFITJFIVGGHGGGGIIWJFJLJQJBJGGGGQFNFKFJFJGGJGJJJBIVIVGGHGGGGIGWGGGQFMFKFJFHGGIVJHJNJGJKIVJJGIHGGEGGHBGIGSFNFIFHFIGIJFJJIXIRJLJPJBJKITIZGIHGGEGGGXGIFNFKFHJTIOFNFKJT";
                    // String str =
                    // "DATA$EJCJCLJRFNFKFJGIJJJKISJMJNJJGGHGGGGYGWGUGQFMFKFJGGJDJLIZGIHGGEGGEBBXCFDYBXAEEAAKASDXAKBGGIGSFLFIFJGIJFJHIUIVGHHGGGGGGWGIGSFNFKFHGGJLITJLJBGGHGGGJMJKJLIVGRFNFKFHGGJLJAJHJPIPIRJAIWGIHEGEGIGXHBGIGQFLFJFJGIIXIRJFIXGIHGGEILIOGSFNFIFHGIIWITJMIRGGHFGGJTFLFIFJFJGIITJGJGIQJNJKJCGGHGGGGIJLJEJJJKIWJDGVGVGYHEHGIOGTIMGUJNJLIVJIIOGVJIJKJFIWJAJEIXIMGTGXGWHBHDGVGYHBGYHEGVGYGYGIGSFNFIFHFIGIJFJJIXIRJIJBIVJKJLJJIXGIHEGEGIJAJMJMJGHEINGVIOGTIXJGJEJBJDIVGSIUJEJFJFISJBGUIVJHJDIMGUJLJMIRJKJBIVIOGVIRIUJEJBJGIMGTJBJFIZIOGTIXISJFIXIPJDJLIZIOGVIWISGTJIJGIXGGGSFNFKFJFHGGIUJHJNJEJKIXJKGIHGGEGGHAGIGSFLFIFJFJGIJFJJIXIQJLJPIZJKIVJAGIHGGEGGGWGIGSFLFIFJFJGIITIPIZIVGIHGGEGGGXHBGIFNFIFHJUFNFKJT";
                    // rdata = Encrypt.Encryption(str.substring(5), -65537);

                    EventSDK.showText("GetServerData ->> " + Url + "?" + FJHttp.praseMap(map, FJHttp.DEFAULT_CHARSET));    // 请求参数信息
                    EventSDK.showText("服务器返回信息 ->> " + rdata);

                    // rdata =
                    // "{\"status\":200,\"msg\":\"\u67e5\u8be2\u6210\u529f\",\"data\":{\"useable\":[{\"cid\":\"12345677abce\",\"value_type\":\"0\",\"value\":\"256\",\"limit\":\"\"},{\"cid\":\"12345678abce\",\"value_type\":\"1\",\"value\":\"0.80\",\"limit\":\"\"},{\"cid\":\"12345679abce\",\"value_type\":\"0\",\"value\":\"1001\",\"limit\":\"\"}],\"unuseable\":[{\"cid\":\"12345678abcd\",\"value_type\":\"0\",\"value\":\"127.99\",\"limit\":\"\"}]}}";

                    rdata = rdata.trim();
                    JSONArray array = null;
                    try
                    {
                        array = new JSONArray(rdata);
                    }
                    catch (Exception ex)
                    {
                        JSONObject iteam = new JSONObject(rdata);
                        array = new JSONArray().put(iteam);
                        // array = new JSONArray("[" + rdata + "]");
                    }

                    JSONObject userJson = array.getJSONObject(0);
                    // JSONObject userJson = new JSONObject(rdata);
                    int status = userJson.getInt("status");
                    String msg = userJson.getString("msg");

                    EventSDK.showText(msg);
                    // Tools.showToast(context, msg);

                    // // 优惠券信息
                    // JSONObject data = userJson.getJSONObject("data");

                    switch (status)
                    {
                        case 200:        // 成功
                            // call.OnSuccess(data);
                            // if (call != null) call.OnSuccess(userJson);
                            if (call != null) call.OnSuccess(array);
                            break;

                        default:        // 失败
                            if (call != null) call.Onfail();
                            break;
                    }
                }
                catch (Exception ex)
                {
                    EventSDK.showToast(context, "GetServerData，服务器返回信息异常！");
                    ex.printStackTrace();
                    if (call != null) call.Onfail();
                }
            }
        });
    }

    /** 发送服务器链接已点击 */
    public static void SendClickState(final Context context, final String PackageName, final String ClientId, final String a_id, final CallBack2 call)
    {
        ThreadTool.RunInCachedThread(new ThreadTool.ThreadPram()
        {
            @Override
            public void Function()
            {
                // 在主线程执行逻辑
                try
                {
                    // String Url = LtConfig.URL(context, "/Coupon/lists");
                    String Url = LtConfig.URL(context, "/index.php/api/game/attention");

                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("source_app_name", PackageName);
                    map.put("uuid", ClientId);
                    map.put("a_id", a_id);

                    // AddSign(map, Url);
                    String rdata = FJHttp.request(Url, map, "post");

                    EventSDK.showText("SendClickState信息 ->> " + Url + "?" + FJHttp.praseMap(map, FJHttp.DEFAULT_CHARSET));    // 请求参数信息
                    EventSDK.showText("服务器返回信息 ->> " + rdata);

                    // rdata =
                    // "{\"status\":200,\"msg\":\"\u67e5\u8be2\u6210\u529f\",\"data\":{\"useable\":[{\"cid\":\"12345677abce\",\"value_type\":\"0\",\"value\":\"256\",\"limit\":\"\"},{\"cid\":\"12345678abce\",\"value_type\":\"1\",\"value\":\"0.80\",\"limit\":\"\"},{\"cid\":\"12345679abce\",\"value_type\":\"0\",\"value\":\"1001\",\"limit\":\"\"}],\"unuseable\":[{\"cid\":\"12345678abcd\",\"value_type\":\"0\",\"value\":\"127.99\",\"limit\":\"\"}]}}";

                    JSONObject userJson = new JSONObject(rdata);
                    int status = userJson.getInt("status");
                    String msg = userJson.getString("msg");

                    EventSDK.showText(msg);
                    // Tools.showToast(context, msg);

                    // // 优惠券信息
                    // JSONObject data = userJson.getJSONObject("data");

                    switch (status)
                    {
                        case 200:        // 成功
                            // call.OnSuccess(data);
                            if (call != null) call.OnSuccess(userJson);
                            break;

                        default:        // 失败
                            if (call != null) call.Onfail();
                            break;
                    }
                }
                catch (Exception ex)
                {
                    EventSDK.showToast(context, "SendClickState信息异常！");
                    ex.printStackTrace();
                }
            }
        });
    }

    /** 发送服务器，游戏已展示了关注推广按钮 */
    public static void SendShowTime(final Context context, final String show_id, final CallBack2 call)
    {
        ThreadTool.RunInCachedThread(new ThreadTool.ThreadPram()
        {
            @Override
            public void Function()
            {
                // 在主线程执行逻辑
                try
                {
                    // String Url = LtConfig.URL(context, "/Coupon/lists");
                    String Url = LtConfig.URL(context, "/index.php/api/game/showTimes");

                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("show_aid", show_id);

                    // AddSign(map, Url);

                    String rdata = FJHttp.request(Url, map, "post");
                    EventSDK.showText("SendShowTime信息 ->> " + Url + "?" + FJHttp.praseMap(map, FJHttp.DEFAULT_CHARSET));    // 请求参数信息
                    EventSDK.showText("服务器返回信息 ->> " + rdata);

                    // rdata =
                    // "{\"status\":200,\"msg\":\"\u67e5\u8be2\u6210\u529f\",\"data\":{\"useable\":[{\"cid\":\"12345677abce\",\"value_type\":\"0\",\"value\":\"256\",\"limit\":\"\"},{\"cid\":\"12345678abce\",\"value_type\":\"1\",\"value\":\"0.80\",\"limit\":\"\"},{\"cid\":\"12345679abce\",\"value_type\":\"0\",\"value\":\"1001\",\"limit\":\"\"}],\"unuseable\":[{\"cid\":\"12345678abcd\",\"value_type\":\"0\",\"value\":\"127.99\",\"limit\":\"\"}]}}";

                    JSONObject userJson = new JSONObject(rdata);
                    int status = userJson.getInt("status");
                    String msg = userJson.getString("msg");

                    EventSDK.showText(msg);
                    // Tools.showToast(context, msg);

                    // // 优惠券信息
                    // JSONObject data = userJson.getJSONObject("data");

                    switch (status)
                    {
                        case 200:        // 成功
                            // call.OnSuccess(data);
                            if (call != null) call.OnSuccess(userJson);
                            break;

                        default:        // 失败
                            if (call != null) call.Onfail();
                            break;
                    }
                }
                catch (Exception ex)
                {
                    EventSDK.showToast(context, "SendShowTime信息异常！");
                    ex.printStackTrace();
                }
            }
        });
    }

    //
    // /** 获取ThumbsList信息 */
    // public static void GetThumbsData(final Context context, final String PackageName, final String ClientId, final String installedApps, final String
    // language,
    // final CallBack2 call, final boolean index2)
    // {
    // ThreadTool.RunInCachedThread(new ThreadTool.ThreadPram()
    // {
    // @Override
    // public void Function()
    // {
    // // 在主线程执行逻辑
    // try
    // {
    // // String Url = LtConfig.URL(context, "/Coupon/lists");
    // String Url = LtConfig.URL(context, "/index.php/api/game/index");
    // if (index2) Url += "2";
    //
    // HashMap<String, String> map = new HashMap<String, String>();
    // map.put("source_app_name", PackageName);
    // map.put("uuid", ClientId);
    // map.put("app_names", installedApps);
    // map.put("language", language);
    //
    // // AddSign(map, Url);
    //
    // String rdata = FJHttp.request(Url, map, "post");
    // EventSDK.showText("获取ThumbsList信息 ->> " + Url + "?" + FJHttp.praseMap(map, FJHttp.DEFAULT_CHARSET)); // 请求参数信息
    // EventSDK.showText("服务器返回信息 ->> " + rdata);
    //
    // // rdata =
    // //
    // "{\"status\":200,\"msg\":\"\u67e5\u8be2\u6210\u529f\",\"data\":{\"useable\":[{\"cid\":\"12345677abce\",\"value_type\":\"0\",\"value\":\"256\",\"limit\":\"\"},{\"cid\":\"12345678abce\",\"value_type\":\"1\",\"value\":\"0.80\",\"limit\":\"\"},{\"cid\":\"12345679abce\",\"value_type\":\"0\",\"value\":\"1001\",\"limit\":\"\"}],\"unuseable\":[{\"cid\":\"12345678abcd\",\"value_type\":\"0\",\"value\":\"127.99\",\"limit\":\"\"}]}}";
    //
    // JSONObject userJson = new JSONObject(rdata);
    // int status = userJson.getInt("status");
    // String msg = userJson.getString("msg");
    //
    // EventSDK.showText(msg);
    // // Tools.showToast(context, msg);
    //
    // // // 优惠券信息
    // // JSONObject data = userJson.getJSONObject("data");
    //
    // switch (status)
    // {
    // case 200: // 成功
    // // call.OnSuccess(data);
    // if (call != null) call.OnSuccess(userJson);
    // break;
    //
    // default: // 失败
    // if (call != null) call.Onfail();
    // break;
    // }
    // }
    // catch (Exception ex)
    // {
    // EventSDK.showToast(context, "获取ThumbsList信息异常！");
    // ex.printStackTrace();
    // }
    // }
    // });
    // }
    //
    // /** 获取任务列表信息 */
    // public static void GetTaskState(final Context context, final String appId, final String uid, final String appNames, final String language,
    // final CallBack2 call)
    // {
    // ThreadTool.RunInCachedThread(new ThreadTool.ThreadPram()
    // {
    // @Override
    // public void Function()
    // {
    // // 在主线程执行逻辑
    // try
    // {
    // // String Url = LtConfig.URL(context, "/Coupon/lists");
    // String Url = LtConfig.URL(context, "/index.php/api/game/checkTask");
    //
    // HashMap<String, String> map = new HashMap<String, String>();
    // map.put("source_app_name", appId);
    // map.put("uuid", uid);
    // map.put("language", language);
    // map.put("app_names", appNames);
    //
    // // AddSign(map, Url);
    //
    // String rdata = FJHttp.request(Url, map, "post");
    // EventSDK.showText("GetTaskState信息 ->> " + Url + "?" + FJHttp.praseMap(map, FJHttp.DEFAULT_CHARSET)); // 请求参数信息
    // EventSDK.showText("服务器返回信息 ->> " + rdata);
    //
    // // 解析获取的ClientId
    // JSONObject userJson = new JSONObject(rdata);
    // String haveTask = userJson.optString("task", "");
    //
    // if (call != null) call.OnSuccess(haveTask);
    // }
    // catch (Exception ex)
    // {
    // EventSDK.showToast(context, "GetTaskState信息异常！");
    // ex.printStackTrace();
    // }
    // }
    // });
    // }
    //
    // /** 上传游戏相关信息 */
    // public static void UploadGameInfo(final Context context, final String ClientId, final String gameInfo, final CallBack2 call)
    // {
    // ThreadTool.RunInCachedThread(new ThreadTool.ThreadPram()
    // {
    // @Override
    // public void Function()
    // {
    // // 在主线程执行逻辑
    // try
    // {
    // // String Url = LtConfig.URL(context, "/Coupon/lists");
    // String Url = LtConfig.URL(context, "/index.php/api/game/uploadGameInfo");
    //
    // HashMap<String, String> map = new HashMap<String, String>();
    // map.put("uuid", ClientId);
    // map.put("gameInfo", gameInfo);
    //
    // // AddSign(map, Url);
    //
    // String rdata = FJHttp.request(Url, map, "post");
    // EventSDK.showText("UploadGameInfo信息 ->> " + Url + "?" + FJHttp.praseMap(map, FJHttp.DEFAULT_CHARSET)); // 请求参数信息
    // EventSDK.showText("服务器返回信息 ->> " + rdata);
    //
    // // 解析获取的ClientId
    // JSONObject userJson = new JSONObject(rdata);
    // int status = userJson.getInt("status");
    // String msg = userJson.getString("msg");
    //
    // EventSDK.showText(msg);
    // // Tools.showToast(context, msg);
    //
    // // 优惠券信息
    // // JSONObject data = userJson.getJSONObject("data");
    // switch (status)
    // {
    // case 200: // 成功
    // if (call != null) call.OnSuccess(userJson);
    // break;
    //
    // default: // 失败
    // if (call != null) call.Onfail();
    // break;
    // }
    // }
    // catch (Exception ex)
    // {
    // EventSDK.showToast(context, "UploadGameInfo信息异常！");
    // ex.printStackTrace();
    // }
    // }
    // });
    // }
    //
    /** 添加签名验证信息 */
    public static void AddSign(HashMap<String, String> map, String url)
    {
        String action = url;
        if (url.contains("/")) action = url.substring(url.lastIndexOf("/") + 1);

        String timestamp = (System.currentTimeMillis() / 1000) + "";
        String sign = MD5(timestamp + action);

        map.put("timestamp", timestamp);
        map.put("sign", sign);
    }

    /** 获取MD5值 */
    public static String MD5(String data)
    {
        MessageDigest md5 = null;
        try
        {
            md5 = MessageDigest.getInstance("MD5");
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        char[] charArray = data.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];

        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++)
        {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();
    }

    /** 从网络上下载图片资源 */
    public static Bitmap DownloadBitmap(String imgUrl)
    {
        Bitmap bmp = null;
        try
        {
            URL picUrl = new URL(imgUrl);

            // 打开连接
            URLConnection con = picUrl.openConnection();
            InputStream in = con.getInputStream();
            bmp = BitmapFactory.decodeStream(in);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return bmp;
    }

    // 缓存Drawable图像
    private static HashMap<String, Drawable> DrawableDic = new HashMap<String, Drawable>();

    /** 从网络上下载图片,转为Drawable */
    public static Drawable DownloadDrawable(String imgUrl)
    {
        Drawable drawable = null;

        if (DrawableDic.containsKey(imgUrl))
            drawable = DrawableDic.get(imgUrl);	// 从缓存读取图像
        else
        {
            Bitmap bmp = DownloadBitmap(imgUrl);						// 从服务器端下载图像
            if (bmp != null) drawable = Bitmap2Drawable(bmp);			// 转化为Drawable
            if (drawable != null) DrawableDic.put(imgUrl, drawable);		// 记录图像
        }

        return drawable;
    }

    /** Bitmap转化为Drawable */
    public static Drawable Bitmap2Drawable(Bitmap bitmap)
    {
        BitmapDrawable drawable = new BitmapDrawable(bitmap);
        return drawable;
    }

    /** Drawable转化为Bitmap */
    public static Bitmap Drawable2Bitmap(Drawable drawable)
    {
        BitmapDrawable bitDrawable = (BitmapDrawable) drawable;
        return bitDrawable.getBitmap();
    }

}
