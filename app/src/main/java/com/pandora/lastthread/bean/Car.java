package com.pandora.lastthread.bean;


public class Car {

    /**
     * 车辆编号
     */
    private String carNumber;

    /**
     * 车架号
     */
    private String vin;

    /**
     * 车牌号
     */
    private String plateNumber;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 车颜色
     */
    private String colour;

    private static ThreadLocal<Car> mThreadLocal = new ThreadLocal<>();

    public static Car getInstance() {
        if (mThreadLocal.get() == null) {
            mThreadLocal.set(new Car());
        }
        return mThreadLocal.get();
    }

    private Car() {

    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNumber='" + carNumber + '\'' +
                ", vin='" + vin + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
