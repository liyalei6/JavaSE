package com.javase.day2.MyThread;/**
 * @author liyalei
 * @description TODO
 * @date 2022-03-29 4:53 下午
 */

/**
 @ClassName MyRunable
 @Description TODO
 @Author liyalei
 @Date 2022/3/29  4:53 下午
 @Version 1.0
 **/
public class MyRunable implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}

class MyRunableTest{
    public static void main(String[] args) {
        MyRunable myRunable = new MyRunable();
//        Thread thread = new Thread(myRunable);
//        thread.start();
        myRunable.run();
    }

}
