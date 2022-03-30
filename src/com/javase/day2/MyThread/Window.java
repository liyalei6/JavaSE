package com.javase.day2.MyThread;/**
 * @author liyalei
 * @description TODO
 * @date 2022-03-30 6:51 下午
 */

import oracle.jrockit.jfr.jdkevents.ThrowableTracer;

import java.util.concurrent.locks.ReentrantLock;

/**
 @ClassName Window
 @Description TODO
 @Author liyalei
 @Date 2022/3/30  6:51 下午
 @Version 1.0
 **/
public class Window implements Runnable{
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try {
                lock.lock();
                if(ticket > 0){
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "号窗口买票，票号：" + ticket--);
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}

class WindowTest{
    public static void main(String[] args) {
        Window window = new Window();
        Thread threa1 = new Thread(window);
        Thread threa2 = new Thread(window);
        Thread threa3 = new Thread(window);

        threa1.setName("1");
        threa1.setName("2");
        threa1.setName("3");


        threa1.start();
        threa2.start();
        threa3.start();

    }
}
