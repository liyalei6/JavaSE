package com.javase.day2.MyThread;/**
 * @author liyalei
 * @description TODO
 * @date 2022-03-29 5:16 下午
 */

/**
 @ClassName Ticket2
 @Description TODO
 @Author liyalei
 @Date 2022/3/29  5:16 下午
 @Version 1.0
 **/
public class Ticket2 extends Thread{
    private int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        while(true){
            synchronized (this){
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + "号窗口买票，票号：" + ticket--);
                }else {
                    break;
                }
            }
        }
    }
}

class Ticket2Test(){
    public static void main(String[] args) {

    }
}
