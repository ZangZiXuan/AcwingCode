package org.example.NO1basic.highPrecisionCalculations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/15 10:52
 * @Version 1.0
 */
public class Division {

    public static void main(String[] args) throws IOException {
//        高精度/低精度
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        char[] chars = s.toCharArray();
        int[] num1 = new int[s.length()];
//        除法运算不需要调换顺序存储，但是为了和其他运算保持统一，在此进行倒序的存储
        for(int i = 0,j=s.length()-1;i<s.length() && j>=0;i++,j--){
            num1[i] = Integer.parseInt(String.valueOf(chars[j]));
        }
        String s1 = bf.readLine();
        int b = Integer.parseInt(s1);
        System.out.println("商：");
        System.out.println(Arrays.toString(division(num1,b,0)));
        System.out.println("余数：");
        System.out.println(division(num1,b,0)[division(num1,b,0).length - 1]);
    }
// a/b,商是C，余数是r

    static int[] division(int[] a,int b,int r){
        int[] result = new int[a.length];
        r=0;
        for(int i=a.length-1;i>=0;i--){
            r = r*10 + a[i];
            result[i] = r/b;
            r%=b;
        }
        //      将length中多出来的0删掉
        int firsrNonZeroIndex = result.length - 1;
        while(firsrNonZeroIndex>0 && result[firsrNonZeroIndex]==0){
            firsrNonZeroIndex--;
        }
        return Arrays.copyOf(result,firsrNonZeroIndex+1);
    }
}
