package com.javase.day2.MyThread;/**
 * @author liyalei
 * @description TODO
 * @date 2022-03-30 6:49 下午
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 @ClassName A
 @Description TODO
 @Author liyalei
 @Date 2022/3/30  6:49 下午
 @Version 1.0
 **/
public class A {
    private final ReentrantLock lock = new ReentrantLock();
    private void m(){
        lock.lock();
        try {
            //to do something.
        }finally {
            lock.unlock();
        }
    }
}
