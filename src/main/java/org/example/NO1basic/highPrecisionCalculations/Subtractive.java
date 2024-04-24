package org.example.NO1basic.highPrecisionCalculations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/14 21:19
 * @Version 1.0
 */
public class Subtractive {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        char[] chars = s.toCharArray();
        int[] array1 = new int[chars.length];
        for(int i = 0,j=chars.length-1;i<chars.length && j>=0;i++,j--){
            array1[i] = Integer.parseInt(String.valueOf(chars[j]));
        }
        System.out.println(Arrays.toString(array1));
//        第二个数
        String s1 = bufferedReader.readLine();
        char[] chars1 = s1.toCharArray();

        int[] array2 = new int[chars1.length];
        for(int i = 0,j=chars1.length-1;i<chars1.length && j>=0;i++,j--){
            array2[i] = Integer.parseInt(String.valueOf(chars1[j]));
        }
        System.out.println(Arrays.toString(array2));
//        int[] result = new int[subArray(array1, array2).length];
//        for(int i = 0,j=result.length-1;i<result.length && j>=0;i++,j--){
//            result[i] = Integer.parseInt(String.valueOf(subArray(array1, array2)[j]));
//        }
        if(bigger(array1,array2)) {
            System.out.println(Arrays.toString(subArray(array1, array2)));
        }else{
            System.out.println(Arrays.toString(subArray(array2, array1)));
        }
    }
    static int[] subArray(int[] a,int[] b){
        int length = max(a.length,b.length);
        int[] result = new int[length];
        for(int index = 0, t =0;index<length;index++){
            int digitA = (index<a.length)?a[index]:0;
            int digitB = (index<b.length)?b[index]:0;
            int difference = digitA-digitB-t;
            if(difference<0){
                difference +=10;
                t=1;
            }else t=0;
            result[index] = difference;
        }
//        将相减之后的0，删除
        int firsrNonZeroIndex = length - 1;
        while(firsrNonZeroIndex>0 && result[firsrNonZeroIndex]==0){
            firsrNonZeroIndex--;
        }

        return Arrays.copyOf(result,firsrNonZeroIndex+1);
    }

    static boolean bigger(int[] a,int[] b){
        Boolean bool = new Boolean(true);

        if(a.length>b.length){

        }else if(a.length == b.length){
            for(int i = 0;i<a.length;i++){
                if(a[i] != b[i]){
                    bool = (a[i]>b[i]);
                }
            }
        }else{
            bool =false;
        }
        return bool;
    }
}
