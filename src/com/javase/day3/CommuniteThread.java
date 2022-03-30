package com.javase.day3;/**
 * @author liyalei
 * @description TODO
 * @date 2022-03-30 7:18 下午
 */

import sun.tools.jconsole.inspector.XObject;

/**
 @ClassName CommuniteThread
 @Description TODO
 @Author liyalei
 @Date 2022/3/30  7:18 下午
 @Version 1.0
 **/
public class CommuniteThread implements Runnable{
    Object object = new Object();
    private int num = 1;
    @Override
    public void run() {
        while(true){
            synchronized (object){
                object.notify();
                if(num <= 100){
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + num);
                    num++;

                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}

class CommunitationTest{
    public static void main(String[] args) {
        CommuniteThread communiteThread = new CommuniteThread();
        Thread thread1 = new Thread(communiteThread);
        Thread thread2 = new Thread(communiteThread);

        thread1.setName("1");
        thread2.setName("2");

        thread1.start();
        thread2.start();
    }
}
