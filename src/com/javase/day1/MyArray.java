package com.javase.day1;/**
 * @author liyalei
 * @description TODO
 * @date 2022-03-28 6:39 下午
 */

/**
 @ClassName MyArray
 @Description TODO
 @Author liyalei
 @Date 2022/3/28  6:39 下午
 @Version 1.0
 **/
public class MyArray {
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 9, 7};

        int maxNum = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(maxNum < nums[i]){
                maxNum = nums[i];
            }
        }
        System.out.println("max num is: " + maxNum);

        int minNum = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(minNum > nums[i]){
                minNum = nums[i];
            }
        }
        System.out.println("min num is: " + minNum);

        float sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        System.out.println("average is: " + (sum/nums.length));


    }
}
