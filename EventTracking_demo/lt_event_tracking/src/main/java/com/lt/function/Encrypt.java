package com.lt.function;

/** Encrypt.java: 对字符串或文件进行自定义加解密。
 * 加密字符串：Encryption(String str, int change)
 * 解密字符串：Encryption(String str, int -change)
 * 加密byte数组：Encryption(byte[] bytes, int change)
 * 解密byte数组：Encryption(byte[] bytes, int -change)
 * ----- 2018-10-22 下午5:50:35 scimence */
public class Encrypt
{
    /** 对字符串数据进行加解密， change加密、 -chage解密 */
    public static String Encryption(String str, int change)
    {
        if ((str.equals("")) || (str == null)) return "";

        byte[] bytes;
        if (change < 0)
            bytes = toBytes(str);
        else bytes = str.getBytes();

        Encryption(bytes, change);

        if (change < 0)
            str = new String(bytes);
        else str = toHex(bytes);

        return str;
    }

    /** 对bytes数据进行加密、解密操作， change加密、 -chage解密 */
    public static void Encryption(byte[] bytes, int change)
    {
        short sign = 1;
        if (change < 0)
        {
            sign = -1;
            change *= -1;
        }

        int num = 0;
        for (int i = 0; i < bytes.length; i++)
        {
            if (num == 0) num = change;

            int tmp = bytes[i] + sign * (num % 3);

            if (tmp > 127)
                tmp -= 255;
            else if (tmp < -128) tmp += 255;

            bytes[i] = ((byte) tmp);
            num /= 3;
        }
    }

    private static String toHex(byte[] B)
    {
        String tmp = "";
        byte[] arrayOfByte = B;
        int j = B.length;
        for (int i = 0; i < j; i++)
        {
            byte b = arrayOfByte[i];
            tmp = tmp + toHex(b);
        }
        return tmp;
    }

    public static byte[] toBytes(String Hex)
    {
        byte[] B = new byte[Hex.length() / 2];
        for (int i = 0; i + 1 < Hex.length(); i += 2)
        {
            String hexStr = Hex.substring(i, i + 2);
            B[(i / 2)] = toByte(hexStr);
        }

        return B;
    }

    private static String toHex(byte B)
    {
        int N = B + 128;
        return "" + (char) (65 + N / 26) + (char) (65 + N % 26);
    }

    private static byte toByte(String Hex)
    {
        int N = (Hex.charAt(0) - 'A') * 26 + (Hex.charAt(1) - 'A');
        return (byte) (N - 128);
    }


    /** 判断数据是否为加密的数据 */
    public static boolean isEncrypt(String data)
    {
        return data.startsWith("DATA$");
    }

}
