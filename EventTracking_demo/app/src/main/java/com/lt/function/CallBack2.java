package com.lt.function;

/**
 * CallBack2.java:
 * -----
 * 2018-6-6 下午5:08:03
 * wangzhongyuan
 */
public interface CallBack2
{
    // 成功
    public void OnSuccess(Object... data);

    // 失败
    public void Onfail(Object... data);
}

