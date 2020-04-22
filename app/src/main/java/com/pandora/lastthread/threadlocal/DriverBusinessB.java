package com.pandora.lastthread.threadlocal;


import android.util.Log;

import com.pandora.lastthread.bean.DriverUser;

public class DriverBusinessB {

    private String TAG = this.getClass().getSimpleName();

    private DriverUser mDriverUser;

    public DriverBusinessB() {
        //获取到当前线程绑定的属性
        mDriverUser = DriverUser.getInstance();
        String driverStr = mDriverUser.toString();
        Log.d(TAG, Thread.currentThread().getName() + ",DriverBusinessB: driverStr = " + driverStr);
    }

    public void payMoney() {
        String driverStr = mDriverUser.toString();
        Log.d(TAG, Thread.currentThread().getName() + ",DriverBusinessB: payMoney: " + ",driverStr = " + driverStr);
    }
}
