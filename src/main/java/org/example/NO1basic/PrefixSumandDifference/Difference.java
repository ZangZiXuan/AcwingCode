package org.example.NO1basic.PrefixSumandDifference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/16 19:40
 * @Version 1.0
 */
public class Difference {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        char[] chars = s.toCharArray();
        int[] sequence = new int[chars.length];
        for(int i =0 ;i<sequence.length;i++){
            sequence[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        int m = Integer.parseInt(bf.readLine());
        int l =0,r=0,c=0;
        while(m>0){
            l = Integer.parseInt(bf.readLine());
            r = Integer.parseInt(bf.readLine());
            c = Integer.parseInt(bf.readLine());
            m--;
        }
        int[] results = addC(sequence, l, r, c);
        System.out.println(Arrays.toString(results));
    }

    static int[] addC(int[] array,int l,int r,int c){
        int[] result = new int[array.length];
        int[] b = new int[array.length];
        b[0]=0;
        for(int i =1;i<array.length;i++){
            b[i] = array[i]-array[i-1];
        }

        for(int i =0;i<b.length;i++){
            if(i>=l-1 && i<r){
                result[i] = b[i]+c;
            }else{
                result[i] = b[i];
            }
        }
        return result;
    }
}
