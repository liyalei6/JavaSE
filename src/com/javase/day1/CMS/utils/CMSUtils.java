package com.javase.day1.CMS.utils;/**
 * @author liyalei
 * @description TODO
 * @date 2022-03-28 7:01 下午
 */

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

/**
 @ClassName CMSUtils
 @Description TODO
 @Author liyalei
 @Date 2022/3/28  7:01 下午
 @Version 1.0
 **/
public class CMSUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static char readMenuSelection(){
        char c;
        for(;;){
            String chars = readKeyBoard(1, false);
            c = chars.charAt(0);
            if(c != '0' && c!= '1' && c != '2' && c != '3' && c != '4' && c != '5'){
                System.out.println("error input");
            }else
                break;
        }
        return c;
    }

    public static char readChar(){
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    public static char readChar(char defauleValue){
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defauleValue : str.charAt(0);
    }

    public static int readInt(){
        int n;
        for(;;){
            String str = readKeyBoard(2, false);

            try {
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("error input");
            }
        }
        return n;
    }

    public static int readInt(int defauleValue){
        int n;
        for(;;){
            String str = readKeyBoard(2, true);
            if(str.equals("")){
                return defauleValue;
            }
            try {
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("error input");
            }
        }
        return n;
    }

    public static String readString(int limit){
        return readKeyBoard(limit, false);
    }

    public static String readString(int limit, String defaultValue){
        String str = readKeyBoard(limit, true);
        return (str.equals(""))?defaultValue:str;
    }

    public static char readConfirmSelection(){
        char c;
        for(;;){
            String chars = readKeyBoard(1, false).toUpperCase();
            c = chars.charAt(0);
            if(c == 'Y' || c == 'N'){
                break;
            }else {
                System.out.println("error input");
            }
        }
        return c;
    }

    public static String readKeyBoard(int limit, boolean blankRetrun){
        String line="";
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            if(line.length() == 0){
                if(blankRetrun){
                    return line;
                }
                else
                    continue;
            }
            if(line.length() < 1 && line.length() > limit){
                System.out.println("error input");
                continue;
            }
            break;
        }
        return line;
    }

}
