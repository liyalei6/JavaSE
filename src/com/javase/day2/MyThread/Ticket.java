package com.javase.day2.MyThread;/**
 * @author liyalei
 * @description TODO
 * @date 2022-03-29 5:06 下午
 */

import org.junit.internal.runners.statements.RunAfters;

/**
 @ClassName Ticket
 @Description TODO
 @Author liyalei
 @Date 2022/3/29  5:06 下午
 @Version 1.0
 **/
public class Ticket implements Runnable {
    private int ticket = 100;
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

class TicketTest{
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);
        Thread thread3 = new Thread(ticket);

        thread1.setName("01");
        thread2.setName("02");
        thread3.setName("03");

        thread1.start();
        thread2.start();
        thread3.start();
    }


}
