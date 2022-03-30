package com.javase.day2.MyThread;/**
 * @author liyalei
 * @description TODO
 * @date 2022-03-29 4:51 下午
 */

/**
 @ClassName MyThread
 @Description TODO
 @Author liyalei
 @Date 2022/3/29  4:51 下午
 @Version 1.0
 **/
public class MyThread extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
