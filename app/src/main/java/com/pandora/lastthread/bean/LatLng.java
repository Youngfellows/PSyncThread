package com.pandora.lastthread.bean;

/**
 * 经纬度
 */
public class LatLng {

    /**
     * 纬度
     */
    private double latitude;

    /**
     * 经度
     */
    private double longitude;

    private static ThreadLocal<LatLng> mThreadLocal = new ThreadLocal<>();

    public static LatLng getInstance() {
        if (mThreadLocal.get() == null) {
            mThreadLocal.set(new LatLng());
        }
        return mThreadLocal.get();
    }

    private LatLng() {

    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "LatLng{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
