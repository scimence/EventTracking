
package com.lt.sdk.event;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.appevents.AppEventsConstants;
import com.lt.function.DeviceInfo;
import com.lt.function.ThreadTool;
import com.lt.sdk.event.facebook.FaceBook_EventSDK;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;


public class EventSDK
{
    public static String SdkVersion = "v20190321_17.39";
    public static Context context;
    public static String appId = "";
    public static String channelId = "";
    public static String deviceId = "";


    //	/** 获取设备Id */
    //	public static String getDeviceID(Context context)
    //	{
    //		String deviceId = DeviceInfo.getDeviceID(context);
    //		return deviceId;
    //	}

    /** 初始化 */
    public static void Init(Context context, /* final SdkCallBack call, */String appId, String channelId)
    {
        EventSDK.context = context;
        EventSDK.deviceId = DeviceInfo.getDeviceID(context);

        EventSDK.appId = appId;
        EventSDK.channelId = channelId;

        FaceBook_EventSDK.UseFacebookEventSdk = LtConfig.getConfig(context,"UseFacebookEventSdk", "false").equals("true");
        FaceBook_EventSDK.isDebugMode = LtConfig.getConfig(context,"FaceBook_EventSDK_isDebugMode", "false").equals("true");

        Server.SendInit(context, null, deviceId, appId, channelId, SdkVersion);
        FaceBook_EventSDK.Init(context, deviceId);
    }

    /** 发送支付订单信息 */
    public static void Send_OrderInfo(String OrderId, String ProductId, String ProductName, String ProductMoney)
    {
        Server.SendOrder(context, null, deviceId, appId, channelId, OrderId, ProductId, ProductName, ProductMoney);
        FaceBook_EventSDK.logAddPaymentInfoEvent(true, OrderId, ProductId, ProductName, ProductMoney);
    }

    /** 发送自定义事件 */
    public static void Send_Event(String eventName)
    {
        Server.SendEvent(context, null, deviceId, appId, channelId, eventName);
        FaceBook_EventSDK.logCustomEvent(eventName);
    }

    /** 发送自定义事件(仅发送至乐堂服务器) */
    private static void SendEventX(String eventName)
    {
        Server.SendEvent(context, null, deviceId, appId, channelId, eventName);
    }

    /** 完成关卡 */
    public static void Send_LevelFinish(String level)
    {
        SendEventX("LevelFinish("+ level +")");
        FaceBook_EventSDK.logAchieveLevelEvent(level);
    }

    /** 应用内广告点击 */
    public static void Send_AdClick(String adType)
    {
        SendEventX("AdClick("+ adType +")");
        FaceBook_EventSDK.logAdClickEvent(adType);
    }

    /** 应用内广告展示 */
    public static void Send_AdShowing(String adType)
    {
        SendEventX("AdShowing("+ adType +")");
        FaceBook_EventSDK.logAdImpressionEvent(adType);
    }

    /**
     * 加入购物车：
     * 将商品添加到购物车或购物篮。例如，在网站上点击“加入购物车”按钮。
     */
    public static void Send_AddToCart(String contentData, String contentId, String contentType, String currency, double price)
    {
        SendEventX("AddToCart(" + "contentData:" + contentData + ", contentId:" + contentId+ ", contentType:" + contentType+ ", currency:" + currency+ ", price:" + price + ") ");
        FaceBook_EventSDK.logAddToCartEvent(contentData, contentId, contentType, currency, price);
    }

    /**
     * 加入心愿单：
     * 将商品添加到心愿单。例如，在网站上点击“加入心愿单”按钮。
     */
    public static void Send_AddToWishlist(String contentData, String contentId, String contentType, String currency, double price)
    {
        SendEventX("AddToWishlist(" + "contentData:" + contentData + ", contentId:" + contentId+ ", contentType:" + contentType+ ", currency:" + currency+ ", price:" + price + ") ");
        FaceBook_EventSDK.logAddToWishlistEvent(contentData, contentId, contentType, currency, price);
    }

    /** 完成注册 */
    public static void Send_RegistrationComplete()
    {
        SendEventX("RegistrationComplete");

        String registrationMethod = "RegistrationComplete";
        FaceBook_EventSDK.logCompleteRegistrationEvent(registrationMethod);
    }

    /** 完成登录 */
    public static void Send_LoginComplete()
    {
        Send_Event("LoginComplete");
    }

    /** 退出 */
    public static void Send_Exit()
    {
        EventSDK.Send_Event("Exit");
    }

    /** 完成教程学习 */
    public static void Send_TutorialComplete(String contentData, String contentId, boolean success)
    {
        SendEventX("TutorialComplete(" + "contentId:" + contentId + ", contentData:" + contentData + ") " + success);
        FaceBook_EventSDK.logCompleteTutorialEvent(contentData, contentId, success);
    }

    /** 查看联系方式事件：
     * 电话、短信、邮件、聊天，或者客户和您公司之间的其他联系方式。 */
    public static void Send_Contact()
    {
        SendEventX("ContactEvent");
        FaceBook_EventSDK.logContactEvent();
    }


    /**
     * 定制产品：
     * 通过配置工具或您公司拥有的其他应用程序完成产品定制。
     */
    public static void Send_CustomizeProduct()
    {
        SendEventX("CustomizeProduct");
        FaceBook_EventSDK.logCustomizeProductEvent();
    }

    /**
     * 捐款：
     * 通过配置工具或您公司拥有的其他应用程序完成产品定制。
     */
    public static void Send_DonateEvent()
    {
        SendEventX("Donate");
        FaceBook_EventSDK.logDonateEvent();
    }

    /** 查找位置：
     * 用户通过网络或应用查找您的某家分店，并有意前往。例如，搜索某个产品并找到您的某家本地商店。
     * */
    public static void Send_FindLocation()
    {
        SendEventX("FindLocation");
        FaceBook_EventSDK.logFindLocationEvent();
    }

    /** 发起结账（调用支付开始）*/
    public static void Send_PayStart(String productId, String productName, String productDescription, double totalPrice_Yuan)
    {
        SendEventX("PayStart(" + "productId:" + productId+ ", productName:" + productName+ ", productDescription:" + productDescription+ ", totalPrice_Yuan:" + totalPrice_Yuan);
        FaceBook_EventSDK.logInitiateCheckoutEvent(productDescription, productId, productName, 1, true, "", totalPrice_Yuan);
    }

    /** 购买完成：
     * 完成购买交易，标志性事件通常是收到订单、购买确认或交易收据。*/
    public static void Send_PayFinish(String productId, String productName, String productDescription, double totalPrice_Yuan)
    {
        SendEventX("PayFinish(" + "productId:" + productId+ ", productName:" + productName+ ", productDescription:" + productDescription+ ", totalPrice_Yuan:" + totalPrice_Yuan);

        BigDecimal purchaseAmount = BigDecimal.valueOf(1);
        Currency currency = Currency.getInstance(Locale.CHINA);
        Bundle parameters = new Bundle();
        parameters.putString("currencyType", "RMB");
        parameters.putString("productId", productId);
        parameters.putString("productName", productName);
        parameters.putString("productDescription", productDescription);
        parameters.putString("totalPrice_Yuan", totalPrice_Yuan + "");
        parameters.putString("productDescription", productDescription);

        FaceBook_EventSDK.logPurchase(purchaseAmount, currency, parameters);
    }


    /**
     * 评分：
     * 对应用、公司或组织中某个项目的评分。例如，在餐厅点评应用中为餐厅评分。
     *
     * maxRatingValue=[0,5]
     * ratingGiven总分
     */
    public static void Send_Rate(String contentType, String contentData, String contentId, int maxRatingValue, double ratingGiven)
    {
        SendEventX("Rate(" + "contentType:" + contentType + ", contentData:" + contentData+ ", contentId:" + contentId+ ", maxRatingValue:" + maxRatingValue+ ", ratingGiven:" + ratingGiven);

        if(maxRatingValue < 0) maxRatingValue=0;
        if(maxRatingValue > 5) maxRatingValue=5;

        FaceBook_EventSDK.logRateEvent(contentType, contentData, contentId, maxRatingValue, ratingGiven);
    }


    /** 排期：预约访问您的某家分店。
     * */
    public static void Send_Schedule()
    {
        SendEventX("Schedule");
        FaceBook_EventSDK.logScheduleEvent();
    }

    /**
     * 搜索：
     * 在网站、应用或其他平台上进行的搜索，例如产品搜索、旅行搜索等。
     */
    public static void Send_Search(String contentType, String contentData, String contentId, String searchString, boolean success)
    {
        SendEventX("Search(" + "contentType:" + contentType + ", contentData:" + contentData+ ", contentId:" + contentId+ ", searchString:" + searchString+ ", success:" + success);
        FaceBook_EventSDK.logSearchEvent(contentType, contentData, contentId, searchString, success);
    }

    /**
     * 花费点数：
     * 用户在完成交易时花费您公司或应用程序专用的点数，例如应用内货币。
     */
    public static void Send_SpendCredits(String contentData, String contentId, String contentType, double totalValue)
    {
        SendEventX("SpendCredits(" + "contentType:" + contentType + ", contentData:" + contentData+ ", contentId:" + contentId+ ", totalValue:" + totalValue);
        FaceBook_EventSDK.logSpendCreditsEvent(contentData, contentId, contentType, totalValue);
    }
    /**
     * 开始试用：
     * 开始免费试用您提供的产品或服务，例如试订。
     */
    public static void Send_StartTrial(String orderId, String currency, double price)
    {
        SendEventX("StartTrial(" + "orderId:" + orderId + ", currency:" + currency+ ", price:" + price);
        FaceBook_EventSDK.logStartTrialEvent(orderId, currency, price);
    }

    /**
     * 提交申请：
     * 就您提供的产品、服务或计划（如信用卡、教育计划或工作）提交申请。
     */
    public static void Send_SubmitApplication()
    {
        SendEventX("SubmitApplication");
        FaceBook_EventSDK.logSubmitApplicationEvent();
    }

    /**
     * 订阅：
     * 开始付费订阅您提供的产品或服务。
     */
    public static void Send_Subscribe(String orderId, String currency, double price)
    {
        SendEventX("Subscribe(" + "orderId:" + orderId + ", currency:" + currency+ ", price:" + price);
        FaceBook_EventSDK.logSubscribeEvent(orderId, currency, price);
    }

    /**
     * 解锁成就：
     * 完成您在应用程序、公司或组织中想要奖励的特定活动或操作。例如，推荐一位好友、完善个人主页等。
     */
    public static void Send_UnlockAchievement(String description)
    {
        SendEventX("UnlockAchievement(" + "description:" + description);
        FaceBook_EventSDK.logUnlockAchievementEvent(description);
    }

    /**
     * 查看内容：
     * 访问您关心的内容页面，例如产品页面、落地页或文章。您查看过的页面信息可能会发送给 Facebook，用于投放动态广告。
     */
    public static void Send_ViewContentEvent(String contentType, String contentData, String contentId, String currency, double price)
    {
        SendEventX("ViewContent(" + "contentType:" + contentType + ", contentData:" + contentData+ ", contentId:" + contentId+ ", currency:" + currency+ ", price:" + price);
        FaceBook_EventSDK.logViewContentEvent(contentType, contentData, contentId, currency, price);
    }

    // --------------

    public static String TAG = "ltsdk_EventTracking.SDK";
    public static boolean needShowToast = false;		// 是否已Toast形式，显示异常提示信息
    public static boolean ShowDebugInfo = true;			// 是否显示ShowDebugInfo调试信息

    public static void showToast(final Context context, final String info)
    {
        if (!ShowDebugInfo) return;

        ThreadTool.RunInMainThread(new ThreadTool.ThreadPram()
        {
            @Override
            public void Function()
            {
                // 在主线程执行逻辑
                Log.d(TAG, info);
                if (needShowToast) Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void showToastFrorce(final Context context, final String info)
    {
        ThreadTool.RunInMainThread(new ThreadTool.ThreadPram()
        {
            @Override
            public void Function()
            {
                // 在主线程执行逻辑
                Log.d(TAG, info);
                Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void showText(final String info)
    {
        if (!ShowDebugInfo) return;

        ThreadTool.RunInMainThread(new ThreadTool.ThreadPram()
        {
            @Override
            public void Function()
            {
                // 在主线程执行逻辑
                Log.d(TAG, info);
            }
        });
    }

    // --------------
}
