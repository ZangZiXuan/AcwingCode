package org.example.NO1basic.highPrecisionCalculations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

import static java.lang.Math.max;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/14 17:41
 * @Version 1.0
 */
public class Additionality {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        char[] chars = s.toCharArray();

        int[] array = new int[s.length()];
        for(int i=0;i<s.length();i++){
            array[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        reverseArray(array);
        System.out.println(Arrays.toString(array));
        String s1 = bf.readLine();
        char[] chars1 = s1.toCharArray();

        int[] array1 = new int[s1.length()];
        for(int i=0;i<s1.length();i++){
            array1[i] = Integer.parseInt(String.valueOf(chars1[i]));
        }
        reverseArray(array1);
        System.out.println(Arrays.toString(array1));
        int[] ints = addArray(array, array1);

        reverseArray(ints);
        System.out.println(Arrays.toString(ints));


    }

    private static void reverseArray(int[] array) {
        int i=0;
        int j=array.length-1;
        while(i<j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
    static int[] addArray(int[] a,int[] b){
        int maxlength = max(a.length,b.length)+1;
        int[] addArray = new int[maxlength];
        int t= 0;
//        t 是进位的数
        for(int i=0;i<maxlength;i++){
            int a1 = 0;
            int a2 = 0;
            if(i<a.length){
                a1 = a[i];
            }else{
                a1 = 0;
            }
            if(i<b.length){
                a2 = b[i];
            }else{
                a2 = 0;
            }
            int sum = a1+a2+t;
            addArray[i] = sum%10;
            t = sum/10;
        }
        return addArray;
    }
}
