package com.lt.sdk.event.facebook;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * FaceBook事件记录sdk
 */
public class FaceBook_EventSDK
{
    public static boolean UseFacebookEventSdk = true;   // 是否使用FaceBook事件sdk
    public static boolean isDebugMode = false;          // 调试模式时可输出log信息

    private static AppEventsLogger logger = null;

    /**
     * 事件sdk初始化
     */
    public static void Init(Context context, String deviceId)
    {
        if(!UseFacebookEventSdk)  return;
        if(isDebugMode)
        {
            FacebookSdk.setIsDebugEnabled(true);
            FacebookSdk.addLoggingBehavior(LoggingBehavior.APP_EVENTS);
        }

        if (logger == null) logger = AppEventsLogger.newLogger(context);

        if(deviceId == null) deviceId = "";
        logger.logEvent("Init");
        logger.logEvent("Init(" + deviceId + ")");
    }

    /**
     * 记录自定义事件:
     * 只需将事件名称作为字符串传递.如："BattleTheMonster"
     * <p>
     * This function assumes logger is an instance of AppEventsLogger and has been
     * created using AppEventsLogger.newLogger() call.
     */
    public static void logCustomEvent(String eventName)
    {
        if(!UseFacebookEventSdk)  return;
        logger.logEvent(eventName);
    }

    /**
     * 完成关卡:
     * 完成您在应用程序、公司或组织中定义的特定关卡。
     * This function assumes logger is an instance of AppEventsLogger and has been
     * created using AppEventsLogger.newLogger() call.
     */
    public static void logAchieveLevelEvent(String level)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_LEVEL, level);
        logger.logEvent(AppEventsConstants.EVENT_NAME_ACHIEVED_LEVEL, params);
    }

    /**
     * 应用内广告点击：
     * 来自第三方平台的广告在您的应用内获得点击。
     * 传递广告类型adType
     */
    public static void logAdClickEvent(String adType)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_AD_TYPE, adType);
        logger.logEvent(AppEventsConstants.EVENT_NAME_AD_CLICK, params);
    }

    /**
     * 应用内广告展示：
     * 来自第三方平台的广告出现在应用的显示屏幕上。
     * 传递广告类型adType
     */
    public static void logAdImpressionEvent(String adType)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_AD_TYPE, adType);
        logger.logEvent(AppEventsConstants.EVENT_NAME_AD_IMPRESSION, params);
    }

    /**
     * 添加支付信息：
     * 在结账流程中添加客户支付信息。
     */
    public static void logAddPaymentInfoEvent(boolean success, String OrderId, String ProductId, String ProductName, String ProductMoney)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString("OrderId", OrderId);
        params.putString("ProductId", ProductId);
        params.putString("ProductName", ProductName);
        params.putString("ProductMoney", ProductMoney);

        params.putInt(AppEventsConstants.EVENT_PARAM_SUCCESS, success ? 1 : 0);
        logger.logEvent(AppEventsConstants.EVENT_NAME_ADDED_PAYMENT_INFO, params);
    }

    /**
     * 加入购物车：
     * 将商品添加到购物车或购物篮。例如，在网站上点击“加入购物车”按钮。
     */
    public static void logAddToCartEvent(String contentData, String contentId, String contentType, String currency, double price)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT, contentData);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, contentId);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_TYPE, contentType);
        params.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency);

        logger.logEvent(AppEventsConstants.EVENT_NAME_ADDED_TO_CART, price, params);
    }

    /**
     * 加入心愿单：
     * 将商品添加到心愿单。例如，在网站上点击“加入心愿单”按钮。
     */
    public static void logAddToWishlistEvent(String contentData, String contentId, String contentType, String currency, double price)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT, contentData);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, contentId);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_TYPE, contentType);
        params.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency);
        logger.logEvent(AppEventsConstants.EVENT_NAME_ADDED_TO_WISHLIST, price, params);
    }

    /**
     * 完成注册：
     * 客户提交信息以换取您公司提供的服务。例如，注册以获取邮件订阅。
     */
    public static void logCompleteRegistrationEvent(String registrationMethod)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_REGISTRATION_METHOD, registrationMethod);
        logger.logEvent(AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, params);
    }

    /**
     * 完成教程学习：
     * 客户提交信息以换取您公司提供的服务。例如，注册以获取邮件订阅。
     */
    public static void logCompleteTutorialEvent(String contentData, String contentId, boolean success)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT, contentData);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, contentId);
        params.putInt(AppEventsConstants.EVENT_PARAM_SUCCESS, success ? 1 : 0);
        logger.logEvent(AppEventsConstants.EVENT_NAME_COMPLETED_TUTORIAL, params);
    }

    /**
     * 联系方式：
     * 电话、短信、邮件、聊天，或者客户和您公司之间的其他联系方式。
     */
    public static void logContactEvent()
    {
        if(!UseFacebookEventSdk)  return;

        logger.logEvent(AppEventsConstants.EVENT_NAME_CONTACT);
    }

    /**
     * 定制产品：
     * 通过配置工具或您公司拥有的其他应用程序完成产品定制。
     */
    public static void logCustomizeProductEvent()
    {
        if(!UseFacebookEventSdk)  return;

        logger.logEvent(AppEventsConstants.EVENT_NAME_CUSTOMIZE_PRODUCT);
    }

    /**
     * 捐款：
     * 通过配置工具或您公司拥有的其他应用程序完成产品定制。
     */
    public static void logDonateEvent()
    {
        if(!UseFacebookEventSdk)  return;

        logger.logEvent(AppEventsConstants.EVENT_NAME_NONATE);
    }

    /**
     * 查找位置：
     * 用户通过网络或应用查找您的某家分店，并有意前往。例如，搜索某个产品并找到您的某家本地商店。
     */
    public static void logFindLocationEvent()
    {
        if(!UseFacebookEventSdk)  return;

        logger.logEvent(AppEventsConstants.EVENT_NAME_FIND_LOCATION);
    }

    /**
     * 发起结账（支付）：
     * 开始结账流程。
     */
    public static void logInitiateCheckoutEvent(String contentData, String contentId, String contentType, int numItems, boolean paymentInfoAvailable, String currency, double totalPrice)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT, contentData);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, contentId);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_TYPE, contentType);
        params.putInt(AppEventsConstants.EVENT_PARAM_NUM_ITEMS, numItems);
        params.putInt(AppEventsConstants.EVENT_PARAM_PAYMENT_INFO_AVAILABLE, paymentInfoAvailable ? 1 : 0);
        params.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency);
        logger.logEvent(AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT, totalPrice, params);
    }

    /**
     * 购买完成：
     * 完成购买交易，标志性事件通常是收到订单、购买确认或交易收据。
     * EVENT_NAME_INITIATED_CHECKOUT
     * currency ="USD"、"RMB"
     */
    public static void logPurchase(BigDecimal purchaseAmount, Currency currency, Bundle parameters)
    {
        if(!UseFacebookEventSdk)  return;

        logger.logPurchase(purchaseAmount, currency, parameters);
    }

    /**
     * 评分：
     * 对应用、公司或组织中某个项目的评分。例如，在餐厅点评应用中为餐厅评分。
     *
     * maxRatingValue=[0,5]
     * ratingGiven总分
     */
    public static void logRateEvent(String contentType, String contentData, String contentId, int maxRatingValue, double ratingGiven)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_TYPE, contentType);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT, contentData);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, contentId);
        params.putInt(AppEventsConstants.EVENT_PARAM_MAX_RATING_VALUE, maxRatingValue);
        logger.logEvent(AppEventsConstants.EVENT_NAME_RATED, ratingGiven, params);
    }

    /**
     * 排期：
     * 预约访问您的某家分店。
     */
    public static void logScheduleEvent()
    {
        if(!UseFacebookEventSdk)  return;

        logger.logEvent(AppEventsConstants.EVENT_NAME_SCHEDULE);
    }

    /**
     * 搜索：
     * 在网站、应用或其他平台上进行的搜索，例如产品搜索、旅行搜索等。
     */
    public static void logSearchEvent(String contentType, String contentData, String contentId, String searchString, boolean success)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_TYPE, contentType);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT, contentData);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, contentId);
        params.putString(AppEventsConstants.EVENT_PARAM_SEARCH_STRING, searchString);
        params.putInt(AppEventsConstants.EVENT_PARAM_SUCCESS, success ? 1 : 0);
        logger.logEvent(AppEventsConstants.EVENT_NAME_SEARCHED, params);
    }

    /**
     * 花费点数：
     * 用户在完成交易时花费您公司或应用程序专用的点数，例如应用内货币。
     */
    public static void logSpendCreditsEvent(String contentData, String contentId, String contentType, double totalValue)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT, contentData);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, contentId);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_TYPE, contentType);
        logger.logEvent(AppEventsConstants.EVENT_NAME_SPENT_CREDITS, totalValue, params);
    }

    /**
     * 开始试用：
     * 开始免费试用您提供的产品或服务，例如试订。
     */
    public static void logStartTrialEvent(String orderId, String currency, double price)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_ORDER_ID, orderId);
        params.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency);
        logger.logEvent(AppEventsConstants.EVENT_NAME_START_TRIAL, price, params);
    }

    /**
     * 提交申请：
     * 就您提供的产品、服务或计划（如信用卡、教育计划或工作）提交申请。
     */
    public static void logSubmitApplicationEvent()
    {
        if(!UseFacebookEventSdk)  return;

        logger.logEvent(AppEventsConstants.EVENT_NAME_SUBMIT_APPLICATION);
    }

    /**
     * 订阅：
     * 开始付费订阅您提供的产品或服务。
     */
    public static void logSubscribeEvent(String orderId, String currency, double price)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_ORDER_ID, orderId);
        params.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency);
        logger.logEvent(AppEventsConstants.EVENT_NAME_SUBSCRIBE, price, params);
    }

    /**
     * 解锁成就：
     * 完成您在应用程序、公司或组织中想要奖励的特定活动或操作。例如，推荐一位好友、完善个人主页等。
     */
    public static void logUnlockAchievementEvent(String description)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_DESCRIPTION, description);
        logger.logEvent(AppEventsConstants.EVENT_NAME_UNLOCKED_ACHIEVEMENT, params);
    }

    /**
     * 查看内容：
     * 访问您关心的内容页面，例如产品页面、落地页或文章。您查看过的页面信息可能会发送给 Facebook，用于投放动态广告。
     */
    public static void logViewContentEvent(String contentType, String contentData, String contentId, String currency, double price)
    {
        if(!UseFacebookEventSdk)  return;

        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_TYPE, contentType);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT, contentData);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, contentId);
        params.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency);
        logger.logEvent(AppEventsConstants.EVENT_NAME_VIEWED_CONTENT, price, params);
    }
}
