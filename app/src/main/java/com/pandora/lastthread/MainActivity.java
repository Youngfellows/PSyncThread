package com.pandora.lastthread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 测试线程同步
     *
     * @param view
     */
    public void onThreadSync(View view) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronizedTask(Thread.currentThread());
                }
            }, "thread_" + i);
            thread.start();
        }
    }


    /**
     * 同步锁对象
     */
    private static final Lock mLock = new ReentrantLock();

    /**
     * 这是需要被同步的方法
     */
    public void synchronizedTask(Thread thread) {
        try {
            //尝试获取锁，修改等待时间
            if (mLock.tryLock(3000, TimeUnit.MILLISECONDS)) {
                try {
                    Log.d(TAG, "线程" + thread.getName() + "获取当前锁"); //打印当前锁的名称
                    Thread.sleep(4000);//为看出执行效果，设置休眠时间
                } catch (Exception e) {
                    Log.d(TAG, "线程" + thread.getName() + "发生了异常释放锁");
                } finally {
                    Log.d(TAG, "线程" + thread.getName() + "执行完毕释放锁");
                    mLock.unlock(); //释放锁
                }

            } else {
                Log.d(TAG, "synchronizedTask " + thread.getName() + "未成功，锁占用");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e(TAG, "synchronizedTask ");
        }
    }

    /**
     * 多线程共享的静态数据
     */
    private static int mSalary = 0;

    /**
     * 线程范围的共享变量
     *
     * @param view
     */
    public void onThreadSharaData1(View view) {
        //多个业务模块针对同一个static变量的操作 要保证在不同线程中 各模块操作的是自身对应的变量对象
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mSalary = new Random().nextInt();
                    Log.d(TAG, Thread.currentThread().getName() + " ,has put mSalary: " + mSalary);
                    PersionA persionA = new PersionA();
                    PersionB persionB = new PersionB();
                    persionA.getSalary();
                    persionB.getSalary();
                }
            }, "thread_" + i).start();
        }
    }

    public static class PersionA {
        public int getSalary() {
            Log.d(TAG, "getSalary: PersionA from " + Thread.currentThread().getName() + ", mSalary: " + mSalary);
            return mSalary;
        }
    }

    public static class PersionB {
        public int getSalary() {
            Log.d(TAG, "getSalary: PersionB from " + Thread.currentThread().getName() + ", mSalary: " + mSalary);
            return mSalary;
        }
    }


    // 使用一个map来保证不同线程间的数据不会相互影响，统一线程中的数据共享
    private static Map<Thread, Integer> mThreadData = new HashMap<>();

    /**
     * 使用Map实现线程范围内数据的共享
     *
     * @param view
     */
    public void onThreadSharaData2(View view) {
        // 新建两个线程（需要保证这两个线程之间的数据不会相互影响）
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int price = new Random().nextInt();
                    Log.d(TAG, Thread.currentThread().getName() + ",put car price: " + price);
                    mThreadData.put(Thread.currentThread(), price);
                    CarA carA = new CarA();
                    CarB carB = new CarB();
                    carA.getPrice();
                    carB.getPrice();
                }
            }, "thread_" + i).start();
        }
    }

    public class CarA {

        public CarA() {

        }

        public int getPrice() {
            Integer price = mThreadData.get(Thread.currentThread());
            Log.d(TAG, "CarA: getPrice, price: " + price);
            return price;
        }
    }

    public class CarB {

        public CarB() {

        }

        public int getPrice() {
            Integer price = mThreadData.get(Thread.currentThread());
            Log.d(TAG, "CarB: getPrice, price: " + price);
            return price;
        }
    }

    /**
     * ThreadLocal实现线程范围内数据的共享
     *
     * @param view
     */
    public void onThreadSharaData3(View view) {

    }

    /**
     * ThreadLocal优化实现线程范围内数据的共享
     *
     * @param view
     */
    public void onThreadSharaData4(View view) {

    }

}
