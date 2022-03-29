package com.javase.day1;/**
 * @author liyalei
 * @description TODO
 * @date 2022-03-28 6:48 下午
 */

import org.junit.Test;

import java.util.Scanner;

/**
 @ClassName MyException
 @Description TODO
 @Author liyalei
 @Date 2022/3/28  6:48 下午
 @Version 1.0
 **/
public class MyException  extends Exception{

    @Test
    public void test01(){
        int a = 10;
        int b = 0;
        System.out.println(a/b);
    }

    @Test
    public void test02(){
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        System.out.println(score);
        scanner.close();
    }

    @Test
    public void test03(){
        String str = "123";
        str = "abc";
        int num = Integer.parseInt(str);
    }

}
