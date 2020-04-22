package com.pandora.lastthread.threadlocal;


import android.util.Log;

import com.pandora.lastthread.bean.DriverUser;

public class DriverBusinessA {
    private String TAG = this.getClass().getSimpleName();

    private DriverUser mDriverUser;

    public DriverBusinessA() {
        //获取到当前线程绑定的属性
        mDriverUser = DriverUser.getInstance();
        String driverStr = mDriverUser.toString();
        Log.d(TAG, Thread.currentThread().getName() + ",DriverBusinessA: driverStr = " + driverStr);
    }

    public void login() {
        String driverStr = mDriverUser.toString();
        Log.d(TAG, Thread.currentThread().getName() + ",DriverBusinessA,login: " + ",driverStr = " + driverStr);
    }
}
