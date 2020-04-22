package com.pandora.lastthread.bean;


public class Student {

    private String name;

    private int age;

    private String city;

    private double grade;

    public Student() {

    }

    public Student(String name, int age, String city, double grade) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", grade=" + grade +
                '}';
    }
}
