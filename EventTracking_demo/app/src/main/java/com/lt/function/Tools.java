package com.lt.function;




/** Tools.java: ----- 2018-6-4 上午11:32:38 wangzhongyuan */
public class Tools
{
    //	public static String TAG = "ltpay";
    //
    //	public static void showText(final String info)
    //	{
    //		FAApk.getMainHandler().post(new Runnable()
    //		{
    //			@Override
    //			public void run()
    //			{
    //				Log.d(TAG, info);
    //			}
    //		});
    //	}
    //
    //	public static void showToast(final Context context, final String info)
    //	{
    //		FAApk.getMainHandler().post(new Runnable()
    //		{
    //			@Override
    //			public void run()
    //			{
    //				Log.d(TAG, info);
    //				Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
    //			}
    //		});
    //	}
    //
    //	/** 显示界面 */
    //	public static void ShowActivity(final Context context, final String className)
    //	{
    //		FAApk.getMainHandler().post(new Runnable()
    //		{
    //			@Override
    //			public void run()
    //			{
    //				try
    //				{
    //					Class clas = Class.forName(className);
    //					Intent intent = new Intent(context, clas);
    //					context.startActivity(intent);
    //				}
    //				catch (Exception ex)
    //				{
    //					ex.printStackTrace();
    //					Toast.makeText(context, ex.toString(), Toast.LENGTH_SHORT).show();
    //				}
    //			}
    //		});
    //	}
    //
    //	/** 启动Activity，附加拓展参数 */
    //	public static void ShowActivity(final Context context, final Class clas, final String... extras)
    //	{
    //		FAApk.getMainHandler().post(new Runnable()
    //		{
    //			@Override
    //			public void run()
    //			{
    //				try
    //				{
    //					Intent intent = new Intent(context, clas);
    //					for (int i = 0; i + 1 < extras.length; i = i + 2)
    //					{
    //						intent.putExtra(extras[i], extras[i + 1]);	// 添加值名称、对应值
    //					}
    //
    //					context.startActivity(intent);
    //				}
    //				catch (Exception ex)
    //				{
    //					ex.printStackTrace();
    //					Toast.makeText(context, ex.toString(), Toast.LENGTH_SHORT).show();
    //				}
    //			}
    //		});
    //	}
    //
    //	/** 显示界面 */
    //	public static void ShowActivity(final Context context, final Class clas)
    //	{
    //		FAApk.getMainHandler().post(new Runnable()
    //		{
    //			@Override
    //			public void run()
    //			{
    //				try
    //				{
    //					Intent intent = new Intent(context, clas);
    //					context.startActivity(intent);
    //				}
    //				catch (Exception ex)
    //				{
    //					ex.printStackTrace();
    //					Toast.makeText(context, ex.toString(), Toast.LENGTH_SHORT).show();
    //				}
    //			}
    //		});
    //	}
    //
    //	/** 获取MD5值 */
    //	public static String MD5(String data)
    //	{
    //		MessageDigest md5 = null;
    //		try
    //		{
    //			md5 = MessageDigest.getInstance("MD5");
    //		}
    //		catch (Exception e)
    //		{
    //			System.out.println(e.toString());
    //			e.printStackTrace();
    //			return "";
    //		}
    //
    //		char[] charArray = data.toCharArray();
    //		byte[] byteArray = new byte[charArray.length];
    //
    //		for (int i = 0; i < charArray.length; i++)
    //			byteArray[i] = (byte) charArray[i];
    //
    //		byte[] md5Bytes = md5.digest(byteArray);
    //		StringBuffer hexValue = new StringBuffer();
    //		for (int i = 0; i < md5Bytes.length; i++)
    //		{
    //			int val = ((int) md5Bytes[i]) & 0xff;
    //			if (val < 16) hexValue.append("0");
    //			hexValue.append(Integer.toHexString(val));
    //		}
    //
    //		return hexValue.toString();
    //	}
    //
    //	/** 添加签名验证信息 */
    //	public static void AddSign(HashMap<String, String> map, String url)
    //	{
    //		String action = url;
    //		if (url.contains("/")) action = url.substring(url.lastIndexOf("/") + 1);
    //
    //		String timestamp = (System.currentTimeMillis() / 1000) + "";
    //		String sign = Tools.MD5(timestamp + action);
    //
    //		map.put("timestamp", timestamp);
    //		map.put("sign", sign);
    //	}
    //
    //	/** 自动关闭 */
    //	public static void AutoHide(final Activity Instatnce, int millionSecond, final CallBackF call)
    //	{
    //		new Handler().postDelayed(new Runnable()
    //		{
    //			@Override
    //			public void run()
    //			{
    //				if (call != null) call.F();
    //				Instatnce.finish();
    //			}
    //		}, millionSecond);
    //	}
    //
    //	/** 获取activity对应的横竖屏属性 */
    //	public static boolean isLandscape(Context context)
    //	{
    //		if (context == null) { return true; }
    //		boolean landscape = (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);
    //		return landscape;
    //	}
    //
    //	/** 将float型值转化为两位精度串 */
    //	public static String FormatMoneyStr(float MoneyAmount)
    //	{
    //		DecimalFormat fnum = new DecimalFormat("##0.00");
    //		String moneyStr = fnum.format(MoneyAmount);
    //
    //		return moneyStr;
    //	}
    //
    //	/** 将double型值转化为两位精度串 */
    //	public static String FormatMoneyStr(double MoneyAmount)
    //	{
    //		DecimalFormat fnum = new DecimalFormat("##0.00");
    //		String moneyStr = fnum.format(MoneyAmount);
    //
    //		return moneyStr;
    //	}
    //
    //	/** 将float型值转化为1位精度串 */
    //	public static String FormatDiscount(float value)
    //	{
    //		DecimalFormat fnum = new DecimalFormat("##0.0");
    //		String moneyStr = fnum.format(value);
    //
    //		return moneyStr;
    //	}
    //
    //	/** 将字符串转化为，float型值, 如：floatValue= "999.999" */
    //	public static float ParseFloat(String floatValue)
    //	{
    //		float[] I = {0.1f, 0.01f, 0.001f, 0.0001f, 0.00001f, 0.000001f, 0.0000001f, 0.00000001f, 0.000000001f, 0.0000000001f};
    //		float f = 0;
    //		if (floatValue.contains("."))
    //		{
    //			int index = floatValue.indexOf(".");
    //			String A0 = floatValue.substring(0, index);
    //			String A1 = floatValue.substring(index + 1);
    //
    //			// String[] A = floatValue.split("/.");
    //
    //			f = Integer.parseInt(A0);
    //
    //			int i = 0;
    //			for (char c : A1.toCharArray())
    //			{
    //				f += I[i++] * Integer.parseInt(c + "");
    //			}
    //		}
    //
    //		return f;
    //	}
}
