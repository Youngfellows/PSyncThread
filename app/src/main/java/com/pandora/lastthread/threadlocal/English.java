package com.pandora.lastthread.threadlocal;


import android.util.Log;

import com.pandora.lastthread.MainActivity;
import com.pandora.lastthread.bean.Student;

public class English {

    private String TAG = this.getClass().getSimpleName();

    private Student mStudent;

    public English() {
        mStudent = MainActivity.mThreadLocal.get();
    }

    public String getStudentInfo() {
        String name = mStudent.getName();
        int age = mStudent.getAge();
        String city = mStudent.getCity();
        double grade = mStudent.getGrade();
        Log.d(TAG, "English: " + Thread.currentThread().getName() + ",name: " + name + ",age: " + age + ",city: " + city + ",grade: " + grade);
        String stuStr = mStudent.toString();
        return stuStr;
    }
}
