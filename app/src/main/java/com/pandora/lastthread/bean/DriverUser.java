package com.pandora.lastthread.bean;

/**
 * 司机用户信息
 */
public class DriverUser {

    /**
     * MQTT注册用户前缀
     */
    public static final String DRIVER_PREFIX = "driver_";

    /**
     * 电话区号
     */
    private String areaCode;

    /**
     * 电话号码
     */
    private String phoneNum;

    /**
     * 司机昵称
     */
    private String petName;

    /**
     * 司机用户ID
     */
    private long uid;

    /**
     * 请求Token
     */
    private String token;

    /**
     * Token的过期时间
     */
    private String expired;

    /**
     * 设备SN码
     */
    private String devicesId;

    /**
     * 司机位置
     */
    private LatLng location;

    /**
     * 地理位置名称
     */
    private String place;

    /**
     * 司机绑定车辆
     */
    private Car car;

    /**
     * 订单ID
     */
    private long orderId;

    /**
     * 订单序列号
     */
    private String orderNo;

    /**
     * 预估距离
     */
    private String distance;

    /**
     * 预估时机
     */
    private String timeEstimate;

    private static ThreadLocal<DriverUser> mThreadLocal = new ThreadLocal<>();

    public static DriverUser getInstance() {
        if (mThreadLocal.get() == null) {
            mThreadLocal.set(new DriverUser());
        }
        return mThreadLocal.get();
    }

    private DriverUser() {

    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getDevicesId() {
        return devicesId;
    }

    public void setDevicesId(String devicesId) {
        this.devicesId = devicesId;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(String timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    @Override
    public String toString() {
        return "DriverUser{" +
                "areaCode='" + areaCode + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", petName='" + petName + '\'' +
                ", uid=" + uid +
                ", token='" + token + '\'' +
                ", expired='" + expired + '\'' +
                ", devicesId='" + devicesId + '\'' +
                ", location=" + location +
                ", place='" + place + '\'' +
                ", car=" + car +
                ", orderId=" + orderId +
                ", orderNo='" + orderNo + '\'' +
                ", distance='" + distance + '\'' +
                ", timeEstimate='" + timeEstimate + '\'' +
                '}';
    }
}
