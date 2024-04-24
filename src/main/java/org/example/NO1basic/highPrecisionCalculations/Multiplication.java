package org.example.NO1basic.highPrecisionCalculations;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.max;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/15 9:31
 * @Version 1.0
 */
public class Multiplication {
    public static void main(String[] args) throws IOException {
//        高精度*低精度
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        char[] chars = s.toCharArray();
        int[] num1 = new int[s.length()];
        for(int i = 0,j=s.length()-1;i<s.length() && j>=0;i++,j--){
            num1[i] = Integer.parseInt(String.valueOf(chars[j]));
        }
        String s1 = bf.readLine();
        int b = Integer.parseInt(s1);
        int[] result = multiplicate(num1, b);
//        倒序了，再翻一下就可以
        System.out.println(Arrays.toString(result));

    }
    static int[] multiplicate(int[] a,int b){
        int t = 0;
        int length = max(a.length,String.valueOf(b).length())*2;
//        两个三位数相乘最大就是6位数
        int[] result = new int[length];
        for(int i =0;i<a.length || t!=0;i++){
            if(i<a.length){
                t +=a[i] * b;
            }
            result[i] = t%10;
            t/=10;
        }
//      将length中多出来的0删掉
        int firsrNonZeroIndex = length - 1;
        while(firsrNonZeroIndex>0 && result[firsrNonZeroIndex]==0){
            firsrNonZeroIndex--;
        }
        return Arrays.copyOf(result,firsrNonZeroIndex+1);
    }
}
