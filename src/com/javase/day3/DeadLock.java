package com.javase.day3;/**
 * @author liyalei
 * @description TODO
 * @date 2022-03-30 7:00 下午
 */

/**
 @ClassName DeadLock
 @Description TODO
 @Author liyalei
 @Date 2022/3/30  7:00 下午
 @Version 1.0
 **/
public class DeadLock {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        new Thread(){
            @Override
            public void run(){
                synchronized (sb1){
                    sb1.append("a");
                    sb2.append("1");
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                synchronized (sb2){
                    sb1.append("b");
                    sb2.append("2");

                    System.out.println(sb1);
                    System.out.println(sb2);
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                synchronized (sb2){
                    sb1.append("c");
                    sb2.append("3");
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                synchronized (sb1){
                    sb1.append("d");
                    sb2.append("4");

                    System.out.println(sb1);
                    System.out.println(sb2);
                }
            }
        }.start();

    }
}
