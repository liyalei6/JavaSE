package com.javase.day1;/**
 * @author liyalei
 * @description TODO
 * @date 2022-03-28 6:16 下午
 */

import java.util.Scanner;

/**
 @ClassName ScannerTest
 @Description TODO
 @Author liyalei
 @Date 2022/3/28  6:16 下午
 @Version 1.0
 **/
public class ScannerTest {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("please input your name:");
//        String name = scanner.next();
//        System.out.println(name);
//
//        System.out.println("please input your age:");
//        int age = scanner.nextInt();
//        System.out.println(age);
//
//        System.out.println("please input your weight:");
//        double weight = scanner.nextDouble();
//        System.out.println(weight);
//
//        System.out.println("please input your will:");
//        boolean will = scanner.nextBoolean();
//        System.out.println(will);
//
//        System.out.println("please input your gender:");
//        String gender = scanner.next();
//        char gendenCharAt = gender.charAt(0);
//        System.out.println(gendenCharAt);

        String input = "1 fish 2 fish 3 fish red fish blue fish";
        Scanner newScanner = new Scanner(input).useDelimiter("\\s*fish\\s*");
        System.out.println(newScanner.nextInt());
        System.out.println(newScanner.nextInt());
        System.out.println(newScanner.nextInt());
        System.out.println(newScanner.next());
        System.out.println(newScanner.next());

    }
}
