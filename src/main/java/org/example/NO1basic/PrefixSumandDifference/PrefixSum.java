package org.example.NO1basic.PrefixSumandDifference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/15 11:37
 * @Version 1.0
 */
public class PrefixSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = bf.readLine().toCharArray();
        int[] array = new int[chars.length];
        for(int i= 0;i<chars.length;i++){
            array[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        int l =Integer.parseInt(bf.readLine());
        int r = Integer.parseInt(bf.readLine());
        int sum = Prefix(array, l, r);
        System.out.println(sum);
    }
    static int Prefix(int[] array,int l,int r){
//        方法1  使用l,r作为边界进行输出
//        int sum = 0;
//        if(l<r && r<=array.length){
//            for(int i = l-1;i<=r-1;i++){
//                sum+=array[i];
//            }
//        }else{
//            return 0;
//        }
//        return sum;
//        方法2 将s[i]数组全都计算出来，然后进行相减得到最终值
        int[] s = new int[array.length];
        if(array.length==0){
           return 0;
        }else{
            s[0]=0;
            for(int i = 1;i<array.length;i++){
                s[i] +=array[i-1]+s[i-1];
            }
        }
        System.out.println(Arrays.toString(s));
        int result = s[r]-s[l-1];
        return result;


    }
}
